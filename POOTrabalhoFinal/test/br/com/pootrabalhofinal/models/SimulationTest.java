/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.models.Simulation;
import br.com.pootrabalhofinal.models.Phone;
import br.com.pootrabalhofinal.models.Antenna;
import br.com.pootrabalhofinal.models.Central;
import br.com.pootrabalhofinal.models.Event;
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
public class SimulationTest {
    
    public SimulationTest() {
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
     * Test of Simulation constructor, of class simulation
     */
    @Test
    public void testSimulation() {
        Simulation simulation = new Simulation();
        
        assertNotNull(simulation);
    }
    
    /**
     * Test of Simulation constructor, of class Simulation
     */
    @Test
    public void testSimulation2() {
        Simulation simulation = new Simulation("Simulação 1", 5, new Range(1, 6));
        
        assertNotNull(simulation);
    }

    /**
     * Test of getName method, of class Simulation.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String name = "Simulation";
        int duration = 50;
        Range range = new Range(3,8);       
        Simulation instance = new Simulation(name, duration, range);
        
        String expResult = "Simulation";
        String result = instance.getName();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of setName method, of class Simulation.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Simulation";
        int duration = 50;
        Range range = new Range(3,8);       
        Simulation instance = new Simulation(name, duration, range);
        
        String otherName = "Simulation 2";        
        instance.setName(otherName);
        
        assertEquals(instance.getName(), otherName);
    }

    /**
     * Test of getDuration method, of class Simulation.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        String name = "Simulation";
        int duration = 50;
        Range range = new Range(3,8);       
        Simulation instance = new Simulation(name, duration, range);
        
        int expResult = 50;
        int result = instance.getDuration();
        
        assertEquals(result, expResult);

    }

    /**
     * Test of setDuration method, of class Simulation.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        String name = "Simulation";
        int duration = 50;
        Range range = new Range(3,8);       
        Simulation instance = new Simulation(name, duration, range);
        
        int newDuration = 30;
        instance.setDuration(newDuration);
        
        assertEquals(instance.getDuration(), newDuration);
    }

    /**
     * Test of getMessageQuantityInterval method, of class Simulation.
     */
    @Test
    public void testGetMessageQuantityInterval() {
        System.out.println("getMessageQuantityInterval");
        String name = "Simulation";
        int duration = 50;
        Range range = new Range(3,8);       
        Simulation instance = new Simulation(name, duration, range);
        Range result = range;
        
        assertEquals(result, instance.getMessageQuantityInterval());        
    }

    /**
     * Test of setMessageQuantityInterval method, of class Simulation.
     */
    @Test
    public void testSetMessageQuantityInterval() {
        System.out.println("setMessageQuantityInterval");
        String name = "Simulation";
        int duration = 50;
        Range range = new Range(3,8);       
        Simulation instance = new Simulation(name, duration, range);
        
        Range otherRange = new Range(2,9);
        instance.setMessageQuantityInterval(otherRange);
        
        assertEquals(instance.getMessageQuantityInterval(), otherRange);
    }

    /**
     * Test of getCentral method, of class Simulation.
     */
    @Test
    public void testGetCentral() {
        System.out.println("getCentral");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Simulation simulation = new Simulation("Simulação 1", 5, new Range(1, 6));
        simulation.setCentral(central);
        
        assertEquals(simulation.getCentral(), central);
    }

    /**
     * Test of setCentral method, of class Simulation.
     */
    @Test
    public void testSetCentral() {
        System.out.println("setCentral");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Simulation simulation = new Simulation("Simulação 1", 5, new Range(1, 6));
        simulation.setCentral(central);
        
        assertEquals(simulation.getCentral(), central);
    }

    /**
     * Test of getEvents method, of class Simulation.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Simulation simulation = new Simulation("Simulação 1", 5, new Range(1, 6));
        simulation.setCentral(central);
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Event event = new Event(originPhone, destinationPhone);
        
        ArrayList<Event> events = new ArrayList<>();
        events.add(event);
        simulation.addEvent(event);
        
        assertArrayEquals(simulation.getEvents().toArray(), events.toArray());
    }

    /**
     * Test of setEvents method, of class Simulation.
     */
    @Test
    public void testSetEvents() {
        System.out.println("setEvents");
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Simulation simulation = new Simulation("Simulação 1", 5, new Range(1, 6));
        simulation.setCentral(central);
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Event event = new Event(originPhone, destinationPhone);
        
        ArrayList<Event> events = new ArrayList<>();
        events.add(event);
        
        simulation.setEvents(events);
        
        assertEquals(simulation.getEvents(), events);
    }
    
    /**
     * Test of addEvent method, of class Simulation.
     */
    @Test
    public void testAddEvent() {
        Simulation simulation = new Simulation("Simulação 1", 5, new Range(1, 6));
        
        Central central = new Central("Central 1", 2, new Range(1, 6));
        
        Antenna antenna = new Antenna("Antena 1", 2, new Range(1,6), central);
        
        Phone originPhone = new Phone("Phone 0", antenna);
        Phone destinationPhone = new Phone("Phone 1", antenna);
        
        Event event = new Event(originPhone, destinationPhone);
        simulation.addEvent(event);
        
        assertEquals(simulation.getEvents().get(0), event);
    }
}
