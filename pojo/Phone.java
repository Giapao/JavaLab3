package com.tinne.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mobilephone")
public class Phone implements Serializable {

        @Id
        private String id;

        private String name;
        private int price;
        private String color;
        private String country;
        private int quantity;

        // Many-to-one relationship
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "manufacture_id")
        private Manufacture manufacture;

        // Constructor có tham số
        public Phone(String id, String name, int price, String color, String country, int quantity, Manufacture manufacture) {
                this.id = id;
                this.name = name;
                this.price = price;
                this.color = color;
                this.country = country;
                this.quantity = quantity;
                this.manufacture = manufacture;
        }

        // Constructor mặc định
        public Phone() {
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

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public Manufacture getManufacture() {
                return manufacture;
        }

        public void setManufacture(Manufacture manufacture) {
                this.manufacture = manufacture;
        }

        // Override phương thức toString
        @Override
        public String toString() {
                return String.format("%s\t%s\t%d\t%s\t%s\t%d\n", id, name, price, color, country, quantity);
        }
}
