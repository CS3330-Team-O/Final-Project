package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Scanner;

public class BookClubManagerTest{
    private static BookClubManager bookTest;

    @BeforeAll
    static void setUpPreClass(){
        bookTest = new BookClubManager();
    }

    @AfterAll
    static void tearDownPostClass() {

    }

    @BeforeEach
    void setUp(){
        System.out.println("Running Before Each");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void newCustomerTest() {
        assertTrue(bookTest.newCustomer("Test name"));
    }

    @Test
    @Order(2)
    void findCustomerTest()  {
        assertFalse(bookTest.newCustomer("wrong name"));
        assertTrue(bookTest.findCustomer("Test name"));
    }

    @Test
    @Order(3)
    void loadCustomers(){
        assertTrue(bookTest.newCustomer("Test name"));
        assertTrue(bookTest.newCustomer("James"));
        assertTrue(bookTest.newCustomer("Test name"));
        assertTrue(bookTest.newCustomer("29"));
    }

    @Test
    @Order(4)
    void bookClubTest() {
        String sample1 = "2 \n 1 \n Isaiah Shavers \n";
        String sample2 = "2 \n 2 \n ";
        Scanner scanner = new Scanner(sample1);
        assertTrue(bookTest.BookClub(scanner));
        scanner.close();
        Scanner scanner1 = new Scanner(sample2);
        assertFalse(bookTest.BookClub(scanner1));
    }

}
