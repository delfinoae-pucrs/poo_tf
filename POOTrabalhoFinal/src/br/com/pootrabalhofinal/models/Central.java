/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.protocols.IMessage;
import br.com.pootrabalhofinal.utils.MessageStatus;
import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Central extends Device implements IMessage {
    private int processorsQuantity;
    private Range processorsTimeInterval;
    
    private ArrayList<Antenna> antennas = new ArrayList<>();
    
    private Stack<Message> messages = new Stack<>();
    
    /**
     * Constructor
     */
    public Central() {}
    
    /**
     * Constructor
     * 
     * @param identifier identifier of the central
     * @param processorsQuantity quantity of processors of the central
     * @param processorsTimeInterval time interval of attendance of the processors of the central
     */
    public Central(String identifier, int processorsQuantity, Range processorsTimeInterval) {
        super(identifier);
        this.processorsQuantity = processorsQuantity;
        this.processorsTimeInterval = processorsTimeInterval;
    }
    
    @Override
    public void updateMessages() {
        if (getMessages().size() > 0) {
            Message message = getMessages().peek();
            if ( message.getStatus() == MessageStatus.CENTRAL_TO_ORIGIN_ANTENNA ) {
                Message messageRemoved = getMessages().pop();
                
                Antenna originAntenna = message.getOriginPhone().getAntenna();
                if ( originAntenna.isQueueExhausted() ) {
                    message.setStatus(MessageStatus.FAILURE_NOT_DELIVERED);
                }
                else {
                    originAntenna.addMessage(messageRemoved);
                }
            }
            else if ( message.getStatus() == MessageStatus.CENTRAL_TO_DESTINATION_ANTENNA ) {
                Antenna destinationAntenna = message.getDestinationPhone().getAntenna();
                if ( destinationAntenna.isQueueExhausted() ) {
                    message.setStatus(MessageStatus.CENTRAL_TO_ORIGIN_ANTENNA);
                }
                else {
                    message.setStatus(MessageStatus.ANTENNA_TO_PHONE);
                    message.setWaitForNextTime(true);
                    destinationAntenna.addMessage(getMessages().pop());
                }
            }
        }
    }
    
    /**
     * Find and return an antenna by identifier
     * 
     * @param identifier identifier to find
     * @return Antenna
     */
    public Antenna getAntennaByIdentifier(String identifier) {
        for ( Antenna antenna: getAntennas() ) {
            if ( antenna.getIdentifier().equals(identifier) ) {
                return antenna;
            }
        }
        return null;
    }
    
    /**
     * Find and return a phone by identifier
     * 
     * @param identifier identifier to find
     * @return Phone
     */
    public Phone getPhoneByIdentifier(String identifier) {
        for ( Antenna antenna: getAntennas() ) {
            for ( Phone phone: antenna.getPhones()) {
                if ( phone.getIdentifier().equals(identifier) ) {
                    return phone;
                }
            }
        }
        return null;
    }
    
    /**
     * Add an antenna to list
     * 
     * @param antenna antenna to add
     */
    public void addAntenna(Antenna antenna) {
        getAntennas().add(antenna);
    }
    
    /**
     * Add a message to stack
     * 
     * @param message message to add
     */
    public void addMessage(Message message) {
        getMessages().add(message);
    }
    
    /*
     * Getters and Setters
     */
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
    
    @Override
    public String toString() {
        return "Nome: " + getIdentifier() + " - Quantidade de processadores: " + getProcessorsQuantity() + " - "
                + "Tempo por atendimento dos processadores: " + getProcessorsTimeInterval().toString();
    }
    
}
