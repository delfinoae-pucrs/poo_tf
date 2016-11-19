/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Phone {
    private String identifier;
    private Antenna antenna;
    
    /**
     * Constructor
     * 
     * @param identifier identifier of the phone
     * @param antenna antenna connected to the phone
     */
    public Phone(String identifier, Antenna antenna) {
        this.identifier = identifier;
        this.antenna = antenna;
    }
    
    /*
     * Getters and Setters
     */
    public Antenna getAntenna() {
        return antenna;
    }

    public void setAntenna(Antenna antenna) {
        this.antenna = antenna;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
}