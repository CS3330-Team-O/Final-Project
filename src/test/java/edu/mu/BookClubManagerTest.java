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
    static void setUpPreClass() throws Exception {
        bookTest = new BookClubManager();
    }

    @AfterAll
    static void tearDownPostClass() throws Exception {

    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Running Before Each");
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void newCustomerTest() throws Exception {
        assertTrue(bookTest.newCustomer("Test name"));
    }

    @Test
    void findCustomerTest() throws Exception {
        assertFalse(bookTest.newCustomer("wrong name"));
        assertTrue(bookTest.findCustomer("Test name"));
    }

    @Test
    void loadCustomers() throws Exception {
        assertTrue(bookTest.newCustomer("Test name"));
        assertTrue(bookTest.newCustomer("James"));
        assertTrue(bookTest.newCustomer("Test name"));
        assertTrue(bookTest.newCustomer("29"));
    }

    @Test
    void bookClubTest() throws Exception {
        String sample1 = "1 \n Isaiah Shavers \n";
        String sample2 = "2 \n 2 \n ";
        Scanner scanner = new Scanner(sample1);
        assertTrue(bookTest.BookClub(scanner));
        scanner.close();
        Scanner scanner1 = new Scanner(sample2);
        assertFalse(bookTest.BookClub(scanner1));
    }

    @Test
    void joinBookclub() throws Exception {

    }

}
