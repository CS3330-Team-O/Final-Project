package edu.mu;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookClubManager {
    Customer current;
    static private final ArrayList<Customer> customers = new ArrayList<Customer>();

    BookClubManager(){
        current = new Customer();
        customers.add(current);
    }

    BookClubManager(String name){
        current = new Customer(name);
        customers.add(current);
    }

    public boolean updateCustomer(String name){
        try{
            current.name = name;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean newCustomer(String name){
        try{
            current = new Customer(name);
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
        protected String name ; //first, last
        protected Date joined; //member since

        Customer(){
            this.name = "doe, john";
            this.joined = new Date();
        }

        Customer(String n1){
            this.name = n1;
            this.joined = new Date();
        }

    }

    /**
     * Helper method that adds a member to the book club
     */

    public void joinBookClub(Scanner scanner) {
        System.out.println("Enter your name \"last,first\"");

        boolean success =  false;

        do {


            try {
                String name = scanner.nextLine();
                if (this.newCustomer(name)) {
                    success = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
            }
        }while(!success);
    }

    /**
     * Handles book club membership during transaction
     *
     * @return {boolean}
     */
    public boolean BookClub(Scanner s1){
        System.out.println("Are you a member of the book club?\n1. yes \n2. no");
        boolean success = false;
        do {
            try {
                int type = s1.nextInt();
                if (type == 1) {
                    success = true;
                } else if (type == 2) {
                    System.out.println("Would you like to join the book club? \n1. yes \n2. no");
                    int type2 = s1.nextInt();
                    if (type2 == 1) {
                        joinBookClub(s1);
                        return true;
                    } else if (type2 == 2) {
                        return false;
                    }
                } else {
                    System.out.println("Invalid input. Enter a 1 or a 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }while(!success);

        //Name enter to search for customer in book club
        System.out.println("Please enter your name in format (last, first)");
        try {
            String name = s1.nextLine();
            return this.findCustomer(name);
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter your name in format (last, first)");
        }


        return false;
    }



}