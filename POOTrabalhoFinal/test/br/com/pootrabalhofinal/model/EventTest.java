/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

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
        Event instance = null;
        Phone expResult = null;
        Phone result = instance.getOriginPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOriginPhone method, of class Event.
     */
    @Test
    public void testSetOriginPhone() {
        System.out.println("setOriginPhone");
        Phone originPhone = null;
        Event instance = null;
        instance.setOriginPhone(originPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
