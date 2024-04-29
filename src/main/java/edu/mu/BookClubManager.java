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

    protected class Customer{
        protected String email;
        protected String name ; //first, last
        protected int storeCredit = 0;
        protected ArrayList<Integer> purchased = new ArrayList<Integer>();

        Customer(){
            this.email = "example@email.com";
            this.name = "doe, john";
        }

        Customer(String n1, String e1){
            this.name = n1;
            this.email = e1;
        }

        protected void bookBought(int bookID) {
            this.purchased.add(bookID);

        }

        public void newCustomer(String name, String email){
            current = new Customer(name, email);
            customers.add(current);
        }

        public boolean findCustomer(String name){
            for(int i = 0; i < customers.size(); ++i){
                if(customers.get(i).name.equals(name)){
                    current = customers.get(i);
                    return true;
                }
            }
            return false;
        }

        public boolean useCredit(String name){
            if(current.storeCredit > 0) {
                current.storeCredit --;
                return true;
            }
            return false;
        }

        public void updateCredit(String name){
            if(current.purchased.size() % 10 == 0){
                current.storeCredit++;
            }
        }
    }


}