/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Antenna {
    private String identifier;
    private int queueCapacity;
    private Range attendanceTimeInterval;
    
    private Central central;
    private ArrayList<Phone> phones;
    
    private Queue<Message> messages = new LinkedList<>();
    
    /**
     * Constructor
     * 
     * @param identifier identifier of the antenna
     * @param queueCapacity queue capacity of the antenna
     * @param attendanceTimeInterval time interval of attendance of the antenna
     * @param central central of the antenna is connected
     */
    public Antenna(String identifier, int queueCapacity, Range attendanceTimeInterval, Central central) {
        this.identifier = identifier;
        this.queueCapacity = queueCapacity;
        this.attendanceTimeInterval = attendanceTimeInterval;
        this.central = central;
    }
    
    /*
     * Getters and Setters
     */
    public Range getAttendanceTimeInterval() {
        return attendanceTimeInterval;
    }

    public void setAttendanceTimeInterval(Range attendanceTimeInterval) {
        this.attendanceTimeInterval = attendanceTimeInterval;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public Central getCentral() {
        return central;
    }

    public void setCentral(Central central) {
        this.central = central;
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public Queue<Message> getMessages() {
        return messages;
    }

    public void setMessages(Queue<Message> messages) {
        this.messages = messages;
    }
    
}
