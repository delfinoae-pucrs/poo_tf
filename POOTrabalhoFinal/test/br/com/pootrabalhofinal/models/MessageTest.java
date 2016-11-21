/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.utils.MessageStatus;
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
     * Test of Message constructor, of class Message
     */
    @Test
    public void testMessage() {
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        assertNotNull(message);
    }
    
    /**
     * Test of getOriginPhone method, of class Message.
     */
    @Test
    public void testGetOriginPhone() {
        System.out.println("getOriginPhone");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        assertEquals(message.getOriginPhone(), originPhone);
    }

    /**
     * Test of setOriginPhone method, of class Message.
     */
    @Test
    public void testSetOriginPhone() {
        System.out.println("setOriginPhone");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(destinationPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        message.setOriginPhone(originPhone);
        
        assertEquals(message.getOriginPhone(), originPhone);
    }

    /**
     * Test of getDestinationPhone method, of class Message.
     */
    @Test
    public void testGetDestinationPhone() {
        System.out.println("getDestinationPhone");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        assertEquals(message.getDestinationPhone(), destinationPhone);
    }

    /**
     * Test of setDestinationPhone method, of class Message.
     */
    @Test
    public void testSetDestinationPhone() {
        System.out.println("setDestinationPhone");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, originPhone, MessageStatus.SUCCESSFUL);
        message.setDestinationPhone(destinationPhone);
        
        assertEquals(message.getDestinationPhone(), destinationPhone);
    }

    /**
     * Test of getStatus method, of class Message.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        assertEquals(message.getStatus(), MessageStatus.SUCCESSFUL);
    }

    /**
     * Test of setStatus method, of class Message.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        message.setStatus(MessageStatus.FAILURE_DELIVERED);
        
        assertEquals(message.getStatus(), MessageStatus.FAILURE_DELIVERED);
    }
    
    /**
     * Test of isWaitForNextTime method, of class Message.
     */
    @Test
    public void testIsWaitForNextTime() {
        System.out.println("setStatus");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        message.setWaitForNextTime(true);
        
        assertTrue(message.isWaitForNextTime());
    }
    
    /**
     * Test of setWaitForNextTime method, of class Message.
     */
    @Test
    public void testSetWaitForNextTime() {
        System.out.println("setStatus");
        
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        message.setWaitForNextTime(false);
        message.setWaitForNextTime(true);
        
        assertTrue(message.isWaitForNextTime());
    }
    
    /**
     * Test of equals method, of class Message.
     */
    @Test
    public void testEquals() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone1 = new Phone("Phone 0", antenna);
        Phone destinationPhone1 = new Phone("Phone 1", antenna);
        
        Phone originPhone2 = new Phone("Phone 0", antenna);
        Phone destinationPhone2 = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone1, destinationPhone1, MessageStatus.PHONE_TO_ANTENNA);
        Message message2 = new Message(originPhone2, destinationPhone2, MessageStatus.PHONE_TO_ANTENNA);
        
        boolean sameMessage = message.equals(message2);
        assertTrue(sameMessage);
    }
    
}
