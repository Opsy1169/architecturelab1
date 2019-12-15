package dao;

import entities.Showroom;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDao<T> implements Dao<T> {

//    @EJB(beanName = "HibernateSessionFactory")
//    protected HibernateSessionFactory hibernateSessionFactory;

    @Override
    public void saveEntity(Object object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateEntity(Object object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteEntity(Object object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }
}
