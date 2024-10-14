package com.tinne.dao;

import com.tinne.pojo.Manufacture;

public interface IManufacture extends genericDAO<Manufacture> {

    boolean chkMoreT100();

    int countEmployee();

    Manufacture chkCriteria() ;
}
