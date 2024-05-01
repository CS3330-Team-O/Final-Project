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

    public boolean updateCustomer(String name, String email){
        try{
            current.name = name;
            current.email = email;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean newCustomer(String name, String email){
        try{
            current = new Customer(name, email);
            customers.add(current);
            return true;
        } catch (Exception e){
            return false;
        }
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

    protected static class Customer{
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