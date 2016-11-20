/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.LinkedList;
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
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
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
        Range otherRange = new Range(5, 8);
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);

        instance.setAttendanceTimeInterval(otherRange);
        assertEquals(instance.getAttendanceTimeInterval(), otherRange);
    }

    /**
     * Test of getIdentifier method, of class Antenna.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        String expResult = "Antenna 1";
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdentifier method, of class Antenna.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String newIdentifier = "Anntena 3";
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        instance.setIdentifier(newIdentifier);
        String expResult = "Anntena 3";
        assertEquals(expResult, instance.getIdentifier());
    }

    /**
     * Test of getQueueCapacity method, of class Antenna.
     */
    @Test
    public void testGetQueueCapacity() {
        System.out.println("getQueueCapacity");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 10;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        int expResult = 10;
        int result = instance.getQueueCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQueueCapacity method, of class Antenna.
     */
    @Test
    public void testSetQueueCapacity() {
        System.out.println("setQueueCapacity");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        int newQueueCapacityAntenna = 6;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        instance.setQueueCapacity(newQueueCapacityAntenna);
        assertEquals(Integer.valueOf(instance.getQueueCapacity()), Integer.valueOf(newQueueCapacityAntenna));

    }

    /**
     * Test of getCentral method, of class Antenna.
     */
    @Test
    public void testGetCentral() {
        System.out.println("getCentral");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        Central expResult = c;
        Central result = instance.getCentral();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCentral method, of class Antenna.
     */
    @Test
    public void testSetCentral() {
        System.out.println("setCentral");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        Central central2 = new Central (identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        
        instance.setCentral(central2);
        assertEquals(instance.getCentral(),central2);
    }

    /**
     * Test of getPhones method, of class Antenna.
     */
    @Test
    public void testGetPhones() {
        System.out.println("getPhones");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        ArrayList<Phone> expResult = new ArrayList<>();
        ArrayList<Phone> result = instance.getPhones();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setPhones method, of class Antenna.
     */
    @Test
    public void testSetPhones() {
        System.out.println("setPhones");
        ArrayList<Phone> phones = new ArrayList<>();
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        instance.setPhones(phones);
        assertEquals(instance.getPhones(), phones);
    }

    /**
     * Test of getMessages method, of class Antenna.
     */
    @Test
    public void testGetMessages() {
        System.out.println("getMessages");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c); 
        Queue<Message> result = new LinkedList<>();                
        assertEquals(result, instance.getMessages()); 
    }

    /**
     * Test of setMessages method, of class Antenna.
     */
    @Test
    public void testSetMessages() {
        System.out.println("setMessages");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Queue<Message> otherQueue = new LinkedList<Message>();
        
        
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna instance = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c); 
        instance.setMessages(otherQueue);
        assertEquals(instance.getMessages(),otherQueue);
        

    }

}
