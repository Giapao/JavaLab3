package com.tinne.implement;

import com.tinne.dao.IManufacture;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ManufactureDAO extends AbstractDAO<Manufacture> implements IManufacture {

    public ManufactureDAO(Class<Manufacture> clazz) {
        super(clazz);
    }

    @Override
    public boolean chkMoreT100() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Manufacture.class);
            cr.add(Restrictions.gt("employee", 100));
            return !cr.list().isEmpty();
        }
    }

    @Override
    public int countEmployee() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Phone.class);
            cr.setProjection(Projections.sum("employee"));
            List<?> result = cr.list();
            if (result.isEmpty()) {
                return -1;
            }
            return (int) result.get(0);
        }
    }

    @Override
    public Manufacture chkCriteria() {
        try (Session session = AbstractDAO.getFactory().openSession()) {
            Criteria cr = session.createCriteria(Phone.class);
            cr.add(Restrictions.ilike("location", "%US%"));
            List<?> result = cr.list();
            if (result.isEmpty()) {
                return null;
            }
            return (Manufacture) result.get(0);
        }
    }

    @Override
    public List<Manufacture> getAll() {
        String hql = "FROM Manufacture";
        return this.query(hql);
    }
}
