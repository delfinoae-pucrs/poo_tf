/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

/**
 * This class represents a device that have an identifier
 * 
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Device {
    private String identifier;
    
    /**
     * Constructor
     */
    public Device() {}
    
    /**
     * Constructor
     * 
     * @param identifier identifier of device
     */
    public Device(String identifier) {
        this.identifier = identifier;
    }
    
    /*
     * Getters and setters
     */
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
