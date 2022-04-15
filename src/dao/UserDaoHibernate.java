package dao;


import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DbUtil;
import util.HibernateSessionFactoryUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernate {

    public void save(UserEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public UserEntity selectUser(int id) {

        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            UserEntity user = (UserEntity) session.get(UserEntity.class,id);
            // commit transaction
            return user;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return new UserEntity();

    }

    public void update(UserEntity user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        UserEntity user = selectUser(id);
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<UserEntity> findAll() {
        //List<UserEntity> users =  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From users").list();
        Session session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<UserEntity> users = session.createQuery("from UserEntity", UserEntity.class).getResultList();

        return users;
    }
}