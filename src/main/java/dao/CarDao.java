package dao;

import entities.Car;
import org.hibernate.Session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;


@Stateless(name = "CarDao")
@Local(value = Dao.class)
public class CarDao extends AbstractDao<Car> {
    @Override
    public List<Car> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select c from Car c", Car.class).getResultList();
    }

    @Override
    public Car getById(UUID id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select c from Car c where c.id = :id", Car.class)
                .setParameter("id", id).getSingleResult();
    }
}
