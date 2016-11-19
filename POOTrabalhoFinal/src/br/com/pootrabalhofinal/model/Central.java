/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Central {
    private String identifier;
    private int processorsQuantity;
    private Range processorsTimeInterval;
    
    private ArrayList<Antenna> antennas;
    
    private Stack<Message> messages = new Stack<>();
    
    /**
     * Constructor
     * 
     * @param identifier identifier of the central
     * @param processorsQuantity quantity of processors of the central
     * @param processorsTimeInterval time interval of attendance of the processors of the central
     */
    public Central(String identifier, int processorsQuantity, Range processorsTimeInterval) {
        this.identifier = identifier;
        this.processorsQuantity = processorsQuantity;
        this.processorsTimeInterval = processorsTimeInterval;
    }
    
    /*
     * Getters and Setters
     */
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getProcessorsQuantity() {
        return processorsQuantity;
    }

    public void setProcessorsQuantity(int processorsQuantity) {
        this.processorsQuantity = processorsQuantity;
    }

    public Range getProcessorsTimeInterval() {
        return processorsTimeInterval;
    }

    public void setProcessorsTimeInterval(Range processorsTimeInterval) {
        this.processorsTimeInterval = processorsTimeInterval;
    }

    public ArrayList<Antenna> getAntennas() {
        return antennas;
    }

    public void setAntennas(ArrayList<Antenna> antennas) {
        this.antennas = antennas;
    }

    public Stack<Message> getMessages() {
        return messages;
    }

    public void setMessages(Stack<Message> messages) {
        this.messages = messages;
    }
    
}
