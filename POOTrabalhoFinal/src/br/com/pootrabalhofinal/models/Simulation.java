/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.utils.Logger;
import br.com.pootrabalhofinal.utils.MessageStatus;
import br.com.pootrabalhofinal.utils.Range;
import br.com.pootrabalhofinal.utils.Utils;
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
    private ArrayList<Event> events = new ArrayList<>();
    
    private Logger logger = new Logger();
    
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
     * Run the simulation.
     */
    public void run() {
        int duration = getDuration();
        createMessagesForPhones();
        
        while(duration > 0) {
            getLogger().addLog("Unidade de tempo: " + String.valueOf(duration));
            
            // Update messages of central
            this.central.updateMessages(getLogger());
            
            // Update messages of antennas
            ArrayList<Antenna> antennas = this.central.getAntennas();
            antennas.forEach((antenna) -> {
                antenna.updateMessages(getLogger());
            });
            
            // Update messages of phones
            antennas.forEach((antenna) -> {
                ArrayList<Phone> phones = antenna.getPhones();
                phones.forEach((phone) -> {
                    phone.updateMessages(getLogger());
                });
            });
            duration--;
        }
    }
    
    /**
     * Create messages for phones by events.
     */
    private void createMessagesForPhones() {
        int msgQtd = getMessageQuantityInterval().randomValue();
        getEvents().forEach((event)->{
            Phone originPhone = event.getOriginPhone();
            
            Message message = new Message(originPhone, event.getDestinationPhone(), MessageStatus.PHONE_TO_ANTENNA);
            if ( msgQtd > 0 ) {
                message.setSendQuantity(msgQtd);
                message.setSendAgain(false);
                
                originPhone.addMessageToOutbox(message);
            }
        });
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

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    
}
