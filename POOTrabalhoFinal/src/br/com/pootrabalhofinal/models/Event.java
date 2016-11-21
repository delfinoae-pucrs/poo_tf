/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Event {
    private Phone originPhone;
    private Phone destinationPhone;
    
    /**
     * Constructor
     * 
     * @param originPhone origin phone of the event
     * @param destinationPhone destination phone of the event
     */
    public Event(Phone originPhone, Phone destinationPhone) {
        this.originPhone = originPhone;
        this.destinationPhone = destinationPhone;
    }
    
    /*
     * Getters and Setters
     */
    public Phone getOriginPhone() {
        return originPhone;
    }

    public void setOriginPhone(Phone originPhone) {
        this.originPhone = originPhone;
    }

    public Phone getDestinationPhone() {
        return destinationPhone;
    }

    public void setDestinationPhone(Phone destinationPhone) {
        this.destinationPhone = destinationPhone;
    }
    
    @Override
    public String toString() {
        return "Do telefone: " + getOriginPhone().getIdentifier() + " - "
                + " para o telefone: " + " - " + getDestinationPhone().getIdentifier();
    }
    
}
