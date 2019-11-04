package dao;

import entities.Car;
import entities.Showroom;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class DAO {


    public static  void createAndSaveCar() {
//        SessionFactory factory = new Configuration().buildSessionFactory();
//        Session session = factory.openSession();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setManufacturer("manufacturer");
        car.setModel("model");
        session.save(car);
        transaction.commit();
        session.close();
    }

    public static List<Car> getAllCars(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select c from Car c", Car.class).getResultList();
    }

    public static Car getCarById(UUID id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select c from Car c where c.id = :id", Car.class)
                .setParameter("id", id).getSingleResult();
    }

    public static List<Showroom> getAllShowrooms(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select s from Showroom s", Showroom.class).getResultList();
    }

    public static Showroom getShowroomById(UUID id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select s from Showroom s where s.id = :id", Showroom.class)
                .setParameter("id", id).getSingleResult();
    }

    public static void saveEntity(Object car){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    public static void updateEntity(Object object){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    public static void deleteEntity(Object object){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

}
