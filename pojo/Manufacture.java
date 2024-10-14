package com.tinne.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "manufacture")
public class Manufacture implements Serializable {

    @Id
    private String id;

    private String name;
    private String location;
    private int employee;

    // One-to-many relationship with Phone
    @OneToMany(mappedBy = "manufacture", fetch = FetchType.LAZY)
    private List<Phone> phones;

    // Constructor mặc định
    public Manufacture() {
    }

    // Constructor có tham số
    public Manufacture(String id, String name, String location, int employee) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employee = employee;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%d\n", id, name, location, employee);
    }
}
