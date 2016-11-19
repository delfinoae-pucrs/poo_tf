/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.MessageStatus;
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
public class MessageTest {
    
    public MessageTest() {
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
     * Test of getOriginPhone method, of class Message.
     */
    @Test
    public void testGetOriginPhone() {
        System.out.println("getOriginPhone");
        Message instance = new Message();
        Phone expResult = null;
        Phone result = instance.getOriginPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOriginPhone method, of class Message.
     */
    @Test
    public void testSetOriginPhone() {
        System.out.println("setOriginPhone");
        Phone originPhone = null;
        Message instance = new Message();
        instance.setOriginPhone(originPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestinationPhone method, of class Message.
     */
    @Test
    public void testGetDestinationPhone() {
        System.out.println("getDestinationPhone");
        Message instance = new Message();
        Phone expResult = null;
        Phone result = instance.getDestinationPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestinationPhone method, of class Message.
     */
    @Test
    public void testSetDestinationPhone() {
        System.out.println("setDestinationPhone");
        Phone destinationPhone = null;
        Message instance = new Message();
        instance.setDestinationPhone(destinationPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Message.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Message instance = new Message();
        MessageStatus expResult = null;
        MessageStatus result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Message.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        MessageStatus status = null;
        Message instance = new Message();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
