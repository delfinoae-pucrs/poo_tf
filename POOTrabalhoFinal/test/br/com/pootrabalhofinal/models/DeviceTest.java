/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

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
public class DeviceTest {
    
    public DeviceTest() {
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
     * Test of Device constructor, of class Device.
     */
    @Test
    public void testDevice() {
        Device device = new Device();
        assertNotNull(device);
    }
    
    /**
     * Test of DeviceIdentifier constructor, of class Device.
     */
    @Test
    public void testDeviceIdentifier() {
        Device device = new Device("Device 1");
        assertNotNull(device);
    }
    
    /**
     * Test of getIdentifier method, of class Device.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");
        
        Device device = new Device("Device 1");
        
        assertEquals(device.getIdentifier(), "Device 1");
    }

    /**
     * Test of setIdentifier method, of class Device.
     */
    @Test
    public void testSetIdentifier() {
        System.out.println("setIdentifier");
        
        Device device = new Device("Device 1");
        device.setIdentifier("Device 2");
        
        assertEquals(device.getIdentifier(), "Device 2");
    }
    
}
