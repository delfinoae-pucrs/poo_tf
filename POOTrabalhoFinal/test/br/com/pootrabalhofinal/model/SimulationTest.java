/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

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
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);

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
        Simulation instance = null;
        Range expResult = null;
        Range result = instance.getMessageQuantityInterval();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessageQuantityInterval method, of class Simulation.
     */
    @Test
    public void testSetMessageQuantityInterval() {
        System.out.println("setMessageQuantityInterval");
        Range messageQuantityInterval = null;
        Simulation instance = null;
        instance.setMessageQuantityInterval(messageQuantityInterval);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCentral method, of class Simulation.
     */
    @Test
    public void testGetCentral() {
        System.out.println("getCentral");
        Simulation instance = null;
        Central expResult = null;
        Central result = instance.getCentral();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCentral method, of class Simulation.
     */
    @Test
    public void testSetCentral() {
        System.out.println("setCentral");
        Central central = null;
        Simulation instance = null;
        instance.setCentral(central);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvents method, of class Simulation.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        Simulation instance = null;
        ArrayList<Event> expResult = null;
        ArrayList<Event> result = instance.getEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvents method, of class Simulation.
     */
    @Test
    public void testSetEvents() {
        System.out.println("setEvents");
        ArrayList<Event> events = null;
        Simulation instance = null;
        instance.setEvents(events);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
