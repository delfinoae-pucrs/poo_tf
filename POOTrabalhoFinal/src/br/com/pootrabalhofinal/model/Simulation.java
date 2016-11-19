/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Simulation {
    private String name;
    private int duration;
    private Range messageQuantityInterval;
    
    private Central central;
    private ArrayList<Event> events;
    
    /**
     * Constructor
     * 
     * @param name name of the simulation
     * @param duration duration of the simulation
     * @param messageQuantityInterval interval of quantity of messages sent by the phones
     */
    public Simulation(String name, int duration, Range messageQuantityInterval) {
        this.name = name;
        this.duration = duration;
        this.messageQuantityInterval = messageQuantityInterval;
    }
    
    /*
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public Range getMessageQuantityInterval() {
        return messageQuantityInterval;
    }

    public void setMessageQuantityInterval(Range messageQuantityInterval) {
        this.messageQuantityInterval = messageQuantityInterval;
    }

    public Central getCentral() {
        return central;
    }

    public void setCentral(Central central) {
        this.central = central;
    }
    
    public ArrayList<Event> getEvents() {
        return this.events;
    }
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
    
}
