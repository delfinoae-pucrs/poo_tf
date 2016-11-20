/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.Queue;
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
public class AntennaTest {
    
    public AntennaTest() {
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
     * Test of getAttendanceTimeInterval method, of class Antenna.
     */
    @Test
    
    public void testGetAttendanceTimeInterval() {
        System.out.println("getAttendanceTimeInterval");
        Range attendanceTimeInterval = new Range(0,5);
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Central c = new Central(identifierCentral, 5, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, 5, attendanceTimeInterval,c);
        Range expResult = attendanceTimeInterval;
        Range result = instance.getAttendanceTimeInterval();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttendanceTimeInterval method, of class Antenna.
     */
    @Test
    public void testSetAttendanceTimeInterval() {
        System.out.println("setAttendanceTimeInterval");
        Range attendanceTimeInterval = new Range(10,50);
        Range otherRange = new Range(5,8);        
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Central c = new Central(identifierCentral, 5, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, 5, attendanceTimeInterval,c);
        instance.setAttendanceTimeInterval(otherRange);
        assertEquals(instance.getAttendanceTimeInterval(),otherRange);
    }

    /**
     * Test of getIdentifier method, of class Antenna.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        Range attendanceTimeInterval = new Range(10,50);
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        String expResult = "Antenna 1";
        Central c = new Central(identifierCentral, 5, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, 5, attendanceTimeInterval,c);

        String result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdentifier method, of class Antenna.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String identifier = "Anntena 3";
   
        Range attendanceTimeInterval = new Range(10,50);       
        Central c = new Central("Central 1", 5, attendanceTimeInterval);
        Antenna instance = new Antenna("Antenna 1", 5, attendanceTimeInterval,c);
        instance.setIdentifier(identifier);

    }

    /**
     * Test of getQueueCapacity method, of class Antenna.
     */
    @Test
    public void testGetQueueCapacity() {
        System.out.println("getQueueCapacity");
        Antenna instance = null;
        int expResult = 0;
        int result = instance.getQueueCapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQueueCapacity method, of class Antenna.
     */
    @Test
    public void testSetQueueCapacity() {
        System.out.println("setQueueCapacity");
        int queueCapacity = 0;
        Antenna instance = null;
        instance.setQueueCapacity(queueCapacity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCentral method, of class Antenna.
     */
    @Test
    public void testGetCentral() {
        System.out.println("getCentral");
        Antenna instance = null;
        Central expResult = null;
        Central result = instance.getCentral();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCentral method, of class Antenna.
     */
    @Test
    public void testSetCentral() {
        System.out.println("setCentral");
        Central central = null;
        Antenna instance = null;
        instance.setCentral(central);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhones method, of class Antenna.
     */
    @Test
    public void testGetPhones() {
        System.out.println("getPhones");
        Antenna instance = null;
        ArrayList<Phone> expResult = null;
        ArrayList<Phone> result = instance.getPhones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhones method, of class Antenna.
     */
    @Test
    public void testSetPhones() {
        System.out.println("setPhones");
        ArrayList<Phone> phones = null;
        Antenna instance = null;
        instance.setPhones(phones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessages method, of class Antenna.
     */
    @Test
    public void testGetMessages() {
        System.out.println("getMessages");
        Antenna instance = null;
        Queue<Message> expResult = null;
        Queue<Message> result = instance.getMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessages method, of class Antenna.
     */
    @Test
    public void testSetMessages() {
        System.out.println("setMessages");
        Queue<Message> messages = null;
        Antenna instance = null;
        instance.setMessages(messages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
