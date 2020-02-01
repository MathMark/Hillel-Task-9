package com.hillel.mvc.springboot;

import com.hillel.mvc.springboot.dao.accountRepository.AccountRepository;
import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.Gender;
import com.hillel.mvc.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootStarter {

    @Autowired
    @Qualifier("accountRepositoryImpl")
    private AccountRepository accountRepository;

    private void execute(){
        //AccountRepository accountRepository = new AccountRepositoryImpl();
        User user = new User();
        user.setFirstName("Vadim");
        user.setLastName("Martsun");
        user.setGender(Gender.MALE);
        user.setBirthDate(LocalDate.of(1997,4,6));

        Account account = new Account();
        account.setCreationDate(LocalDate.of(2019,11,10));
        account.setAmount(1000f);
        account.setUser(user);

        accountRepository.save(account);
        System.out.println(accountRepository.getById(1));
    }

    public static void main(String...args){
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBootStarter.class);
        SpringBootStarter s = context.getBean(SpringBootStarter.class);
        s.execute();*/
        SpringApplication.run(SpringBootStarter.class, args);
        /*Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setFirstName("Vadim");
        user.setLastName("Martsun");
        user.setGender(Gender.MALE);
        user.setBirthDate(LocalDate.of(1997,4,6));

        Account account = new Account();
        account.setCreationDate(LocalDate.of(2019,11,10));
        account.setAmount(1000f);
        account.setUser(user);

       // user.getAccounts().add(account);

        session.persist(account);

        session.getTransaction().commit();

        Account account1 = session.get(Account.class, 1);
        System.out.println(account1);

        User user2 = session.get(User.class, 1);
        System.out.println(user2);

        session.close();*/

       // session = HibernateUtil.getSessionFactory().openSession();



        //session.close();
    }
}
