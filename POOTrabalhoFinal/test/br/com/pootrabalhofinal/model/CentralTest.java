/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.MessageStatus;
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
     * Test of Central constructor, of class Central
     */
    @Test
    public void testCentral() {
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        assertNotNull(central);
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
        
        assertEquals(result, expResult);
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
        
        assertEquals(result, expResult);
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
        
        assertEquals(result, expResult);
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
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        ArrayList<Antenna> antennas = new ArrayList<>();
        antennas.add(antenna);
        
        central.setAntennas(antennas);
        
        assertArrayEquals(antennas.toArray(), central.getAntennas().toArray());
    }

    /**
     * Test of setAntennas method, of class Central.
     */
    @Test
    public void testSetAntennas() {
        System.out.println("setAntennas");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        ArrayList<Antenna> antennas = new ArrayList<>();
        antennas.add(antenna);
        
        central.setAntennas(antennas);
        
        assertArrayEquals(antennas.toArray(), central.getAntennas().toArray());
    }

    /**
     * Test of getMessages method, of class Central.
     */
    @Test
    public void testGetMessages() {
        System.out.println("getMessages");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        Stack<Message> messages = new Stack<>();
        messages.add(message);
        
        central.addAntenna(antenna);
        central.addMessage(message);
        
        assertArrayEquals(central.getMessages().toArray(), messages.toArray());
    }

    /**
     * Test of setMessages method, of class Central.
     */
    @Test
    public void testSetMessages() {
        System.out.println("setMessages");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        Stack<Message> messages = new Stack<>();
        messages.add(message);
        
        central.addAntenna(antenna);
        central.setMessages(messages);
        
        assertArrayEquals(central.getMessages().toArray(), messages.toArray());
    }
    
    /**
     * Test of addAntenna method, of class Central.
     */
    @Test
    public void testAddAntenna() {
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        central.addAntenna(antenna);
        
        assertEquals(central.getAntennas().get(0), antenna);
    }
    
    /**
     * Test of addMessage method, of class Central.
     */
    @Test
    public void testAddMessage() {
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        central.addMessage(message);
        
        assertEquals(central.getMessages().lastElement(), message);
    }
}
