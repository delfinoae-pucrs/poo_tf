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
     * Test of getIdentifier method, of class Central.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        Central instance = null;
        String expResult = "";
        String result = instance.getIdentifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentifier method, of class Central.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        String identifier = "";
        Central instance = null;
        instance.setIdentifier(identifier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcessorsQuantity method, of class Central.
     */
    @Test
    public void testGetProcessorsQuantity() {
        System.out.println("getProcessorsQuantity");
        Central instance = null;
        int expResult = 0;
        int result = instance.getProcessorsQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcessorsQuantity method, of class Central.
     */
    @Test
    public void testSetProcessorsQuantity() {
        System.out.println("setProcessorsQuantity");
        int processorsQuantity = 0;
        Central instance = null;
        instance.setProcessorsQuantity(processorsQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcessorsTimeInterval method, of class Central.
     */
    @Test
    public void testGetProcessorsTimeInterval() {
        System.out.println("getProcessorsTimeInterval");
        Central instance = null;
        Range expResult = null;
        Range result = instance.getProcessorsTimeInterval();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcessorsTimeInterval method, of class Central.
     */
    @Test
    public void testSetProcessorsTimeInterval() {
        System.out.println("setProcessorsTimeInterval");
        Range processorsTimeInterval = null;
        Central instance = null;
        instance.setProcessorsTimeInterval(processorsTimeInterval);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
