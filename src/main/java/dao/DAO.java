package dao;

import entities.Car;
import entities.Showroom;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class DAO {


    private static DAO dao;

    private DAO() {
    }

    public static DAO getInstance() {
        if (dao == null) {
            dao = new DAO();
        }
        return dao;
    }



    public List<Car> getAllCars() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select c from Car c", Car.class).getResultList();
    }

    public Car getCarById(UUID id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select c from Car c where c.id = :id", Car.class)
                .setParameter("id", id).getSingleResult();
    }

    public List<Showroom> getAllShowrooms() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select s from Showroom s", Showroom.class).getResultList();
    }

    public Showroom getShowroomById(UUID id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select s from Showroom s where s.id = :id", Showroom.class)
                .setParameter("id", id).getSingleResult();
    }

    public void saveEntity(Object car) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    public void updateEntity(Object object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    public void deleteEntity(Object object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

}
