package com.tinne.implement;

import com.tinne.dao.IPhoneDAO;
import com.tinne.pojo.Phone;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PhoneDAO extends AbstractDAO<Phone> implements IPhoneDAO {

    public PhoneDAO(Class<Phone> clazz) {
        super(clazz);
    }

    @Override
    public List<Phone> getAll() {
        String hql = "FROM Phone";
        return this.query(hql);
    }

    @Override
    public Phone topSell() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Phone.class);
            cr.setProjection(Projections.max("price"));
            List<?> result = cr.list();
            if (result.isEmpty()) {
                return null;
            }
            String hql = "FROM Phone WHERE price = " + result.get(0);
            List<Phone> list = this.query(hql);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    @Override
    public List<Phone> sort() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Phone.class);
            cr.addOrder(Order.asc("country"));
            cr.addOrder(Order.desc("price"));
            return cr.list();
        }
    }

    @Override
    public boolean above50Milion() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Phone.class);
            cr.add(Restrictions.gt("price", 50000));
            return !cr.list().isEmpty();
        }
    }

    @Override
    public Phone meetCriteria() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Phone.class);
            cr.add(Restrictions.gt("price", 1500));
            cr.add(Restrictions.ilike("color", "pink"));
            List<?> result = cr.list();
            return result.isEmpty() ? null : (Phone) result.get(0);
        }
    }
}
