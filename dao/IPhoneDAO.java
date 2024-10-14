package com.tinne.dao;

import com.tinne.pojo.Phone;

import java.util.List;

public interface IPhoneDAO extends genericDAO<Phone>{


    Phone topSell();

    List<Phone> sort();

    boolean above50Milion();

    Phone meetCriteria();
}
