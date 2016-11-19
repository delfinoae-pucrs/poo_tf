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
     * Test of getAntenna method, of class Phone.
     */
    @Test
    public void testGetAntenna() {
        System.out.println("getAntenna");
        Phone instance = null;
        Antenna expResult = null;
        Antenna result = instance.getAntenna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAntenna method, of class Phone.
     */
    @Test
    public void testSetAntenna() {
        System.out.println("setAntenna");
        Antenna antenna = null;
        Phone instance = null;
        instance.setAntenna(antenna);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdentifier method, of class Phone.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        Phone instance = null;
        String expResult = "";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentifier method, of class Phone.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String identifier = "";
        Phone instance = null;
        instance.setIdentifier(identifier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
