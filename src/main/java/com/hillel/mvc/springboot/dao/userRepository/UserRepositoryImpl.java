package com.hillel.mvc.springboot.dao.userRepository;

import com.hillel.mvc.springboot.hibernateUtil.HibernateUtil;
import com.hillel.mvc.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.swing.text.TabableView;
import javax.transaction.Transactional;
import java.util.List;


@Slf4j
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        log.info("{} users obtained successfully", users.size());
        session.close();
        return users;
    }

    @Override
    public User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        log.info("User {} successfully obtained from the database", user);
        session.close();
        return user;
    }

    @Override
    public boolean update(int id, User updatedUser) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(updatedUser);
            transaction.commit();
            session.close();
        }catch (HibernateException e){
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
            session.close();
        }catch (HibernateException e){
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void save(User user) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.save(user);
            session.close();
        }catch (HibernateException e){
            log.error(e.getMessage());
        }
        log.info("Saved successfully");
    }

}
