package edu.mu;

import java.util.ArrayList;

public class BookClubManager {
    Customer current;
    static private ArrayList<Customer> customers = new ArrayList<Customer>();

    BookClubManager(){
        current = new Customer();
        customers.add(current);
    }

    BookClubManager(String name, String email){
        current = new Customer(name, email);
        customers.add(current);
    }

    public void updateCustomer(String name, String email){
        current.name = name;
        current.email = email;
    }

    public void newCustomer(String name, String email){
        current = new Customer(name, email);
        customers.add(current);
    }

    public boolean findCustomer(String name){
        for (Customer customer : customers) {
            if (customer.name.equals(name)) {
                current = customer;
                return true;
            }
        }
        return false;
    }

    protected class Customer{
        protected String email;
        protected String name ; //first, last

        Customer(){
            this.email = "example@email.com";
            this.name = "doe, john";
        }

        Customer(String n1, String e1){
            this.name = n1;
            this.email = e1;
        }

    }


}