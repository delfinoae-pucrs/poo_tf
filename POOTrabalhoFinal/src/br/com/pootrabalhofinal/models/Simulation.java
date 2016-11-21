/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.utils.Range;
import br.com.pootrabalhofinal.utils.Utils;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Simulation {
    private String name;
    private int duration;
    private Range messageQuantityInterval;
    
    private Central central;
    private ArrayList<Event> events = new ArrayList<>();
    
    /**
     * Constructor
     */
    public Simulation() {
        
    }
    
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
    
    /**
     * Run the simulation
     * 
     */
    public void run() {
        int duration = getDuration();
        
        while(duration > 0) {
            Utils.debug("Unidade de tempo: " + String.valueOf(duration));
            
            // Update messages of central
            this.central.updateMessages();
            
            // Update messages of antennas
            ArrayList<Antenna> antennas = this.central.getAntennas();
            antennas.forEach((antenna) -> {
                antenna.updateMessages();
            });
            
            // Update messages of phones
            antennas.forEach((antenna) -> {
                ArrayList<Phone> phones = antenna.getPhones();
                phones.forEach((phone) -> {
                    phone.updateMessages();
                });
            });
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
            }
            duration--;
        }
    }
    
    /**
     * Add event to list
     * 
     * @param event event to add
     */
    public void addEvent(Event event) {
        getEvents().add(event);
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
