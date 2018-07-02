package com.ke.test;

import com.ke.dao.UserDao;
import com.ke.entity.User;
import com.ke.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*xml")
public class Hibernat_Test {

    @Resource(name = "sessionFactory")
    private SessionFactory sf;
    @Resource
    private UserDao userDao;
    @Resource
    private UserService userService;
    @Test
    public void test1() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //
        User user = new User();
        user.setUserName("可可");
        user.setUserCode("keke");
        user.setUserPassword("123");
        user.setUserState("1");
        session.save(user);
        //
        tx.commit();

        session.close();

    }

    @Test
    public void test2() {
        User user = new User();
        user.setUserName("可可-");
        user.setUserCode("keke");
        user.setUserPassword("123");
        user.setUserState("1");
        userService.saveUser(user);

    }


}
