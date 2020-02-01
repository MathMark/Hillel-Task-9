package com.hillel.mvc.springboot.dao.accountRepository;

import com.hillel.mvc.springboot.hibernateUtil.HibernateUtil;
import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.requests.AccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public List<Account> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> accounts = session.createQuery("from Account", Account.class).list();
        log.info("{} accounts obtained successfully", accounts.size());
        session.close();
        return accounts;
    }

    @Override
    public Account getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Account account = session.get(Account.class, id);
        log.info("Account obtained successfully {}", account);
        session.close();
        return account;
    }

    @Override
    public boolean save(Account account) {
        Transaction transaction;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.save(account);
            session.close();
        }catch (HibernateException e){
            log.error(e.getMessage());
            return false;
        }
        log.info("Saved successfully");
        return true;
    }

    @Override
    public boolean update(int id, Account account) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(account);
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
            Account account = session.get(Account.class, id);
            session.delete(account);
            transaction.commit();
            session.close();
        }catch (HibernateException e){
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

}
