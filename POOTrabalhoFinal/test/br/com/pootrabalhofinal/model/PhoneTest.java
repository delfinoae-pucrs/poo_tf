/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.models.Message;
import br.com.pootrabalhofinal.models.Phone;
import br.com.pootrabalhofinal.models.Antenna;
import br.com.pootrabalhofinal.models.Central;
import br.com.pootrabalhofinal.utils.MessageStatus;
import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
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
public class PhoneTest {

    public PhoneTest() {
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
     * Test of Phone constructor, of class Phone
     */
    @Test
    public void testPhone() {
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone phone = new Phone("Phone 0", antenna);
        
        assertNotNull(phone);
    }
    
    /**
     * Test of getAntenna method, of class Phone.
     */
    @Test
    public void testGetAntenna() {
        System.out.println("getAntenna");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        String identifierPhone = "Phone 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna ant = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        Phone instance = new Phone(identifierPhone, ant);

        Antenna expResult = ant;
        Antenna result = instance.getAntenna();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of setAntenna method, of class Phone.
     */
    @Test
    public void testSetAntenna() {
        System.out.println("setAntenna");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        String identifierPhone = "Phone 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna ant = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        Phone instance = new Phone(identifierPhone, ant);
        
        Antenna otherAntenna = new Antenna("Antenna 3", 3, new Range(2,6),c);
        instance.setAntenna(otherAntenna);
        
        assertEquals(instance.getAntenna(),otherAntenna);
    }

    /**
     * Test of getIdentifier method, of class Phone.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        String identifierPhone = "Phone 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna ant = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        Phone instance = new Phone(identifierPhone, ant);
        
        String expResult = "Phone 1";
        String result = instance.getIdentifier();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of setIdentifier method, of class Phone.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String identifierCentral = "Central 1";
        String identifierAntenna = "Antenna 1";
        String identifierPhone = "Phone 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int queueCapacityCentral = 4;
        Central c = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna ant = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        Phone instance = new Phone(identifierPhone, ant);
        
        String newIdentifier = "Phone 3";
        instance.setIdentifier(newIdentifier);
        
        assertEquals(instance.getIdentifier(), newIdentifier);
    }
    
    /**
     * Test of getMessagesOutbox method, of class Phone.
     */
    @Test
    public void testGetMessagesOutbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SEND_TO_ANTENNA);
        
        ArrayList<Message> messagesOutbox = new ArrayList<>();
        messagesOutbox.add(message);
        
        originPhone.setMessagesOutbox(messagesOutbox);
        
        assertArrayEquals(originPhone.getMessagesOutbox().toArray(), messagesOutbox.toArray());
    }
    
    /**
     * Test of setMessagesOutbox method, of class Phone.
     */
    @Test
    public void testSetMessagesOutbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SEND_TO_ANTENNA);
        
        ArrayList<Message> messagesOutbox = new ArrayList<>();
        messagesOutbox.add(message);
        
        originPhone.setMessagesOutbox(messagesOutbox);
        
        assertArrayEquals(originPhone.getMessagesOutbox().toArray(), messagesOutbox.toArray());
    }
    
    /**
     * Test of getMessagesSentbox method, of class Phone.
     */
    @Test
    public void testGetMessagesSentbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        ArrayList<Message> messagesSent = new ArrayList<>();
        messagesSent.add(message);
        
        originPhone.setMessagesSentbox(messagesSent);
        
        assertArrayEquals(originPhone.getMessagesSentbox().toArray(), messagesSent.toArray());
    }
    
    /**
     * Test of setMessagesSentbox method, of class Phone.
     */
    @Test
    public void testSetMessagesSentbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        ArrayList<Message> messagesSent = new ArrayList<>();
        messagesSent.add(message);
        
        originPhone.setMessagesSentbox(messagesSent);
        
        assertArrayEquals(originPhone.getMessagesSentbox().toArray(), messagesSent.toArray());
    }
    
    /**
     * Test of getMessagesInbox method, of class Phone.
     */
    @Test
    public void testGetMessagesInbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        ArrayList<Message> messagesInbox = new ArrayList<>();
        messagesInbox.add(message);
        
        originPhone.setMessagesInbox(messagesInbox);
        
        assertArrayEquals(originPhone.getMessagesInbox().toArray(), messagesInbox.toArray());
    }
    
    /**
     * Test of setMessagesInbox method, of class Phone.
     */
    @Test
    public void testSetMessagesInbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        ArrayList<Message> messagesInbox = new ArrayList<>();
        messagesInbox.add(message);
        
        originPhone.setMessagesInbox(messagesInbox);
        
        assertArrayEquals(originPhone.getMessagesInbox().toArray(), messagesInbox.toArray());
    }
    
    /**
     * Test of addMessageToOutbox method, of class Phone.
     */
    @Test
    public void testAddMessageToOutbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        originPhone.addMessageToOutbox(message);
        
        assertEquals(originPhone.getMessagesOutbox().get(0), message);
    }
    
    /**
     * Test of addMessageToOutbox method and status of message, of class Phone.
     */
    @Test
    public void testAddMessageToOutboxSetStatus() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        originPhone.addMessageToOutbox(message);
        
        assertEquals(originPhone.getMessagesOutbox().get(0).getStatus(), MessageStatus.SEND_TO_ANTENNA);
    }
    
    /**
     * Test of addMessageToSentbox method, of class Phone.
     */
    @Test
    public void testAddMessageToSentbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SEND_TO_ANTENNA);
        originPhone.addMessageToSentbox(message);
        
        assertEquals(originPhone.getMessagesSentbox().get(0), message);
    }
    
    /**
     * Test of addMessageToSentbox method and status of message, of class Phone.
     */
    @Test
    public void testAddMessageToSentboxSetStatus() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SEND_TO_ANTENNA);
        originPhone.addMessageToSentbox(message);
        
        assertEquals(originPhone.getMessagesSentbox().get(0).getStatus(), MessageStatus.SUCCESSFUL);
    }
    
    /**
     * Test of addMessageToInbox method, of class Phone.
     */
    @Test
    public void testAddMessageToInbox() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SEND_TO_ANTENNA);
        originPhone.addMessageToInbox(message);
        
        assertEquals(originPhone.getMessagesInbox().get(0), message);
    }
    
    /**
     * Test of addMessageToInbox method and status of message, of class Phone.
     */
    @Test
    public void testAddMessageToInboxSetStatus() {
        Central central = new Central("Central 1", 3, new Range(0, 5));
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(0, 6), central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SEND_TO_ANTENNA);
        originPhone.addMessageToInbox(message);
        
        assertEquals(originPhone.getMessagesInbox().get(0).getStatus(), MessageStatus.SUCCESSFUL);
    }

}
