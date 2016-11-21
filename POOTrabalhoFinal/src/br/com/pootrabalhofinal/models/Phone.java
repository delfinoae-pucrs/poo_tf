/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.protocols.IMessage;
import br.com.pootrabalhofinal.utils.Logger;
import br.com.pootrabalhofinal.utils.MessageStatus;
import java.util.ArrayList;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Phone extends Device implements IMessage {
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
        super(identifier);
        this.antenna = antenna;
    }
    
    @Override
    public void updateMessages(Logger logger) {
        logger.addLog("Atualizar mensagens do telefone: " + toString());
        if ( getMessagesOutbox().size() > 0 ) {
            logger.addLog("Quantidade de mensagens para enviar do telefone: " + String.valueOf(getMessagesOutbox().size()));
            for(int i = 0; i < getMessagesOutbox().size(); i++) {
                Message message = getMessagesOutbox().get(i);
                logger.addLog("Mensagem para enviar: " + message.toString());
                Message messageCopy = message;
                messageCopy.setStatus(MessageStatus.ANTENNA_TO_CENTRAL);
                logger.addLog("Status alterado para: " + message.getStatus());
                getAntenna().addMessage(messageCopy);
                logger.addLog("Mensagem adicionada na antena: " + getAntenna().toString());
                
                if ( message.getSendQuantity() > 1 ) {
                    message.setSendQuantity(message.getSendQuantity() - 1);
                    if ( !message.isSendAgain() ) {
                        message.setSendAgain(true);
                        break;
                    }
                }
                else {
                    getMessagesOutbox().remove(message);
                    if ( !message.isSendAgain() ) {
                        break;
                    }
                }
            }
        }
        else {
            logger.addLog("Não há mensagens para o telefone.");
        }
    }
    
    /**
     * Add message to list of out box messages
     * and update the status of message
     * 
     * @param message message to add
     */
    public void addMessageToOutbox(Message message) {
        getMessagesOutbox().add(message);
        message.setStatus(MessageStatus.PHONE_TO_ANTENNA);
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