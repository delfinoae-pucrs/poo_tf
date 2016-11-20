/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
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
public class EventTest {
    
    public EventTest() {
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
     * Test of getOriginPhone method, of class Event.
     */
    @Test
    public void testGetOriginPhone() {
        System.out.println("getOriginPhone");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;        
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna ant = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c); 
        String phoneName1 = "Phone 1";
        String phoneName2 = "Phone 2";
        Phone phone1 = new Phone(phoneName1, ant);
        Phone phone2 = new Phone(phoneName2, ant);
        
        Event instance = new Event(phone1, phone2);
        Phone expResult = phone1;
        Phone result = instance.getOriginPhone();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOriginPhone method, of class Event.
     */
    @Test
    public void testSetOriginPhone() {
        System.out.println("setOriginPhone");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;        
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna ant = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c); 
        String phoneName1 = "Phone 1";
        String phoneName2 = "Phone 2";
        String phoneNameOrigin = "Phone 3";
        Phone phone1 = new Phone(phoneName1, ant);
        Phone phone2 = new Phone(phoneName2, ant);
        Event instance = new Event(phone1, phone2);
        
        Phone otherPhoneOrigin = new Phone(phoneNameOrigin, ant);
        instance.setOriginPhone(otherPhoneOrigin);
        assertEquals(instance.getOriginPhone(), otherPhoneOrigin);
    }

    /**
     * Test of getDestinationPhone method, of class Event.
     */
    @Test
    public void testGetDestinationPhone() {
        System.out.println("getDestinationPhone");
        Event instance = null;
        Phone expResult = null;
        Phone result = instance.getDestinationPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestinationPhone method, of class Event.
     */
    @Test
    public void testSetDestinationPhone() {
        System.out.println("setDestinationPhone");
        Phone destinationPhone = null;
        Event instance = null;
        instance.setDestinationPhone(destinationPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
