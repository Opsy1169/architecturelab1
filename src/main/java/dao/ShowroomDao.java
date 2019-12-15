package dao;

import entities.Car;
import entities.Showroom;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;


@Stateless(name = "ShowroomDao")
@Local(value = Dao.class)
public class ShowroomDao extends AbstractDao<Showroom> {

    @Override
    public List<Showroom> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select s from Showroom s", Showroom.class).getResultList();
    }

    @Override
    public Showroom getById(UUID id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("select s from Showroom s where s.id = :id", Showroom.class)
                .setParameter("id", id).getSingleResult();
    }
}
