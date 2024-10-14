package com.tinne;

import com.tinne.implement.ManufactureDAO;
import com.tinne.implement.PhoneDAO;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;

import java.util.Scanner;

public class Program {

    public static void menu() {
        PhoneDAO phoneDAO = new PhoneDAO(Phone.class);
        ManufactureDAO manufactureDAO = new ManufactureDAO(Manufacture.class);
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------MENU---------------");
            System.out.println("------Phone------");
            System.out.println("1. Add");
            System.out.println("2. Get by ID");
            System.out.println("3. Get all");
            System.out.println("4. Remove");
            System.out.println("5. Top selling");
            System.out.println("6. Sort");
            System.out.println("7. Check if there is a phone priced above 50 million VND.");
            System.out.println("8. Find the first phone with criteria: Pink and costs over 15 million");
            System.out.println("------Manufacture------");
            System.out.println("9. Add");
            System.out.println("10. Get by ID");
            System.out.println("11. Get all");
            System.out.println("12. Remove by ID");
            System.out.println("13. Check whether all manufacturers have more than 100 employees.");
            System.out.println("14. Sum of all employees of the manufacturers.");
            System.out.println("15. Find the last manufacturer based in the US");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();

            String pID, mID, name, color, country, location;
            int price, employee, quantity;
            Phone phone;
            Manufacture manufacture;

            switch (choice) {
                case 1:
                    System.out.println("Enter phone details");
                    System.out.print("ID: ");
                    pID = sc.next();
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Color: ");
                    color = sc.next();
                    System.out.print("Price: ");
                    price = sc.nextInt();
                    System.out.print("Country: ");
                    country = sc.next();
                    System.out.print("Quantity: ");
                    quantity = sc.nextInt();
                    System.out.print("Manufacture ID: ");
                    mID = sc.next();
                    manufacture = manufactureDAO.get(mID);
                    phone = new Phone(pID, name, price, color, country, quantity, manufacture);
                    phoneDAO.add(phone);
                    break;

                case 2:
                    System.out.print("Enter phone ID: ");
                    pID = sc.next();
                    System.out.println("Result: " + phoneDAO.get(pID));
                    break;

                case 3:
                    phoneDAO.print(phoneDAO.getAll());
                    break;

                case 4:
                    System.out.print("Enter phone ID to remove: ");
                    pID = sc.next();
                    phoneDAO.remove(pID);
                    break;

                case 5:
                    System.out.println("Top selling phone: " + phoneDAO.topSell());
                    break;

                case 6:
                    System.out.println("Sorted phone list: " + phoneDAO.sort());
                    break;

                case 7:
                    System.out.printf("Phone priced above 50 million VND: %b\n", phoneDAO.above50Milion());
                    break;

                case 8:
                    System.out.println("First phone matching criteria: " + phoneDAO.meetCriteria());
                    break;

                case 9:
                    System.out.println("Enter manufacture details");
                    System.out.print("ID: ");
                    mID = sc.next();
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Location: ");
                    location = sc.next();
                    System.out.print("Number of employees: ");
                    employee = sc.nextInt();
                    manufacture = new Manufacture(mID, name, location, employee);
                    manufactureDAO.add(manufacture);
                    break;

                case 10:
                    System.out.print("Enter manufacture ID: ");
                    mID = sc.next();
                    System.out.println("Result: " + manufactureDAO.get(mID));
                    break;

                case 11:
                    manufactureDAO.print(manufactureDAO.getAll());
                    break;

                case 12:
                    System.out.print("Enter manufacture ID to remove: ");
                    mID = sc.next();
                    manufactureDAO.remove(mID);
                    break;

                case 13:
                    System.out.printf("All manufacturers have more than 100 employees: %b\n", manufactureDAO.chkMoreT100());
                    break;

                case 14:
                    System.out.printf("Sum of all employees: %d\n", manufactureDAO.countEmployee());
                    break;

                case 15:
                    System.out.println("Last manufacturer based in the US: " + manufactureDAO.chkCriteria());
                    break;

                default:
                    break;
            }
            System.out.println("done!");
        } while (choice != 0);
    }

    public static void main(String[] args) {
        menu();
    }
}
