/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class CentralTest {

    public CentralTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIdentifier method, of class Central.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        String centralIdentifier = "Central 1";
        int centralprocessorsQuantity = 5;
        Range centralProcessorsTimeInterval = new Range(0, 5);
        Central instance = new Central(centralIdentifier, centralprocessorsQuantity, centralProcessorsTimeInterval);

        String expResult = "Central 1";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdentifier method, of class Central.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String centralIdentifier = "Central 1";
        int centralprocessorsQuantity = 5;
        Range centralProcessorsTimeInterval = new Range(0, 5);
        Central instance = new Central(centralIdentifier, centralprocessorsQuantity, centralProcessorsTimeInterval);

        String newIdentifier = "Central 3";
        instance.setIdentifier(newIdentifier);
        assertEquals(instance.getIdentifier(), newIdentifier);
    }

    /**
     * Test of getProcessorsQuantity method, of class Central.
     */
    @Test
    public void testGetProcessorsQuantity() {
        System.out.println("getProcessorsQuantity");
        String centralIdentifier = "Central 1";
        int centralprocessorsQuantity = 5;
        Range centralProcessorsTimeInterval = new Range(0, 5);
        Central instance = new Central(centralIdentifier, centralprocessorsQuantity, centralProcessorsTimeInterval);

        int expResult = 5;
        int result = instance.getProcessorsQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProcessorsQuantity method, of class Central.
     */
    @Test
    public void testSetProcessorsQuantity() {
        System.out.println("setProcessorsQuantity");
        String centralIdentifier = "Central 1";
        int centralprocessorsQuantity = 5;
        Range centralProcessorsTimeInterval = new Range(0, 5);
        Central instance = new Central(centralIdentifier, centralprocessorsQuantity, centralProcessorsTimeInterval);

        int newProcessorsQuantity = 10;
        instance.setProcessorsQuantity(newProcessorsQuantity);
        assertEquals(instance.getProcessorsQuantity(), newProcessorsQuantity);
    }

    /**
     * Test of getProcessorsTimeInterval method, of class Central.
     */
    @Test
    public void testGetProcessorsTimeInterval() {
        System.out.println("getProcessorsTimeInterval");
        String centralIdentifier = "Central 1";
        int centralprocessorsQuantity = 5;
        Range centralProcessorsTimeInterval = new Range(0, 5);
        Central instance = new Central(centralIdentifier, centralprocessorsQuantity, centralProcessorsTimeInterval);

        Range expResult = centralProcessorsTimeInterval;
        Range result = instance.getProcessorsTimeInterval();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProcessorsTimeInterval method, of class Central.
     */
    @Test
    public void testSetProcessorsTimeInterval() {
        System.out.println("setProcessorsTimeInterval");
        String centralIdentifier = "Central 1";
        int centralprocessorsQuantity = 5;
        Range centralProcessorsTimeInterval = new Range(0, 5);
        Central instance = new Central(centralIdentifier, centralprocessorsQuantity, centralProcessorsTimeInterval);

        Range otherRange = new Range(3, 8);
        instance.setProcessorsTimeInterval(otherRange);
        assertEquals(instance.getProcessorsTimeInterval(), otherRange);
    }

    /**
     * Test of getAntennas method, of class Central.
     */
    @Test
    public void testGetAntennas() {
        System.out.println("getAntennas");
        Central instance = null;
        ArrayList<Antenna> expResult = null;
        ArrayList<Antenna> result = instance.getAntennas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAntennas method, of class Central.
     */
    @Test
    public void testSetAntennas() {
        System.out.println("setAntennas");
        ArrayList<Antenna> antennas = null;
        Central instance = null;
        instance.setAntennas(antennas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessages method, of class Central.
     */
    @Test
    public void testGetMessages() {
        System.out.println("getMessages");
        Central instance = null;
        Stack<Message> expResult = null;
        Stack<Message> result = instance.getMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessages method, of class Central.
     */
    @Test
    public void testSetMessages() {
        System.out.println("setMessages");
        Stack<Message> messages = null;
        Central instance = null;
        instance.setMessages(messages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
