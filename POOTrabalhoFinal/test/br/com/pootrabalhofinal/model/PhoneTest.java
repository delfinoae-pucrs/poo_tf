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
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
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

}
