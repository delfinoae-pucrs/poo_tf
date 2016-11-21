/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.MessageStatus;
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
     * Test of Antenna constructor, of class Antenna
     */
    @Test
    public void testAntenna() {
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        assertNotNull(antenna);
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
        
        assertEquals(result, expResult);
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
        
        assertEquals(result, expResult);
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
        
        assertEquals(instance.getIdentifier(), expResult);
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
        
        assertEquals(result, expResult);
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
        
        assertEquals(result, expResult);
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
        
        assertEquals(instance.getCentral(), central2);
    }

    /**
     * Test of getPhones method, of class Antenna.
     */
    @Test
    public void testGetPhones() {
        System.out.println("getPhones");
        
        String identifierCentral = "Central 1";
        Range attendanceTimeInterval = new Range(10, 50);
        int queueCapacityAntenna = 5;
        int stackCapacityCentral = 4;
        Central c = new Central(identifierCentral, stackCapacityCentral, attendanceTimeInterval);
        
        String identifierAntenna = "Antenna 1";
        Antenna antenna = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, c);
        
        Phone phone = new Phone("C1", antenna);
        antenna.addPhone(phone);
        
        ArrayList<Phone> expResult = new ArrayList<>();
        expResult.add(phone);
        ArrayList<Phone> result = antenna.getPhones();
        
        assertArrayEquals(result.toArray(), expResult.toArray());
    }

    /**
     * Test of setPhones method, of class Antenna.
     */
    @Test
    public void testSetPhones() {
        System.out.println("setPhones");
        
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone phone = new Phone("Phone 1", antenna);
        
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(phone);
        
        antenna.setPhones(phones);
        
        assertEquals(antenna.getPhones(), phones);
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
        
        Central central = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna antenna = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        Queue<Message> messages = new LinkedList<>();
        messages.add(message);
        
        antenna.addMessage(message);
        
        assertArrayEquals(antenna.getMessages().toArray(), messages.toArray()); 
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
        
        Central central = new Central(identifierCentral, queueCapacityCentral, attendanceTimeInterval);
        Antenna antenna = new Antenna(identifierAntenna, queueCapacityAntenna, attendanceTimeInterval, central); 
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        
        Queue<Message> messages = new LinkedList<>();
        messages.add(message);
        
        antenna.setMessages(messages);
        
        assertArrayEquals(antenna.getMessages().toArray(), messages.toArray()); 
    }
    
    /**
     * Test of addPhone method, of class Antenna.
     */
    @Test
    public void testAddPhone() {
        System.out.println("addPhone");
        
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone phone = new Phone("Phone 0", antenna);
        antenna.addPhone(phone);
        
        assertEquals(antenna.getPhones().get(0), phone);
    }
    
    /**
     * Test of addMessage method, of class Antenna.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Message message = new Message(originPhone, destinationPhone, MessageStatus.SUCCESSFUL);
        antenna.addMessage(message);
        
        assertEquals(antenna.getMessages().element(), message);
    }
    
    /**
     * Test of getPhoneByIdentifier method, of class Antenna
     */
    @Test
    public void testGetPhoneByIdentifier() {
        Central central = new Central("Central 1", 4, new Range(10, 50));
        
        Antenna antenna = new Antenna("Antenna 1", 5, new Range(10, 50), central);
        
        Phone phone = new Phone("Phone 0", antenna);
        antenna.addPhone(phone);
        
        assertEquals(antenna.getPhoneByIdentifier("Phone 0"), phone);
    }
    
}
