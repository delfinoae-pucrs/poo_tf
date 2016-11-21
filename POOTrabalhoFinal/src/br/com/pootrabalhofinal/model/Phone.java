/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.MessageStatus;
import java.util.ArrayList;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Phone {
    private String identifier;
    private Antenna antenna;
    
    private ArrayList<Message> messagesOutbox = new ArrayList<>();
    private ArrayList<Message> messagesSentbox = new ArrayList<>();
    private ArrayList<Message> messagesInbox = new ArrayList<>();
    
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
    
    /**
     * Add message to list of out box messages
     * and update the status of message
     * 
     * @param message message to add
     */
    public void addMessageToOutbox(Message message) {
        getMessagesOutbox().add(message);
        message.setStatus(MessageStatus.SEND_TO_ANTENNA);
    }
    
    /**
     * Remove message of out box messages list 
     * and add message to list of sent box messages
     * and update the status of message
     * 
     * @param message message to remove and add
     */
    public void addMessageToSentbox(Message message) {
        getMessagesOutbox().remove(message);
        getMessagesSentbox().add(message);
        message.setStatus(MessageStatus.SUCCESSFUL);
    }
    
    /**
     * Add message to list of in box messages
     * and update the status of message
     * 
     * @param message message to add
     */
    public void addMessageToInbox(Message message) {
        getMessagesInbox().add(message);
        message.setStatus(MessageStatus.SUCCESSFUL);
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
    
    public ArrayList<Message> getMessagesOutbox() {
        return messagesOutbox;
    }

    public void setMessagesOutbox(ArrayList<Message> messagesOutbox) {
        this.messagesOutbox = messagesOutbox;
    }

    public ArrayList<Message> getMessagesSentbox() {
        return messagesSentbox;
    }

    public void setMessagesSentbox(ArrayList<Message> messagesSentbox) {
        this.messagesSentbox = messagesSentbox;
    }

    public ArrayList<Message> getMessagesInbox() {
        return messagesInbox;
    }

    public void setMessagesInbox(ArrayList<Message> messagesInbox) {
        this.messagesInbox = messagesInbox;
    }
    
    @Override
    public String toString() {
        return "Nome: " + getIdentifier() + " - " + "Antena: " + getAntenna().getIdentifier();
    }

}