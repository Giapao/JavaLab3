package com.tinne.implement;

import com.tinne.dao.genericDAO;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;

public abstract class AbstractDAO<T> implements genericDAO<T> {

    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract List<T> getAll();

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public boolean add(T t) {
        Transaction tx = null;
        try (Session session = AbstractDAO.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<T> query(String hql) {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        }
    }

    public boolean remove(String id) {
        Transaction tx = null;
        try (Session session = AbstractDAO.getFactory().openSession()) {
            T obj = session.get(clazz, id);
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    public boolean update(T t) {
        Transaction tx = null;
        try (Session session = AbstractDAO.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public T get(String id) {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            return session.get(clazz, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean remove(T t) {
        Transaction tx = null;
        try (Session session = AbstractDAO.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public void print(List<T> list) {
        System.out.println("\n BEGIN ");
        if (list != null) {
            list.forEach(System.out::println);
        } else {
            System.out.println("Null");
        }
        System.out.println("END \n");
    }
}
