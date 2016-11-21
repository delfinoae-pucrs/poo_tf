/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.protocols.IMessage;
import br.com.pootrabalhofinal.utils.Logger;
import br.com.pootrabalhofinal.utils.MessageStatus;
import br.com.pootrabalhofinal.utils.Range;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents an antenna of communication
 * 
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Antenna extends Device implements IMessage {
    private int queueCapacity;
    private Range attendanceTimeInterval;
    
    private Central central;
    private ArrayList<Phone> phones = new ArrayList<>();
    
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
        super(identifier);
        
        this.queueCapacity = queueCapacity;
        this.attendanceTimeInterval = attendanceTimeInterval;
        this.central = central;
    }
    
    @Override
    public void updateMessages(Logger logger) {
        logger.addLog("Atualizar mensagens da antena: " + toString());
        if ( getMessages().size() > 0 ) {
            logger.addLog("Tamanho da fila da antena: " + String.valueOf(getMessages().size()));
            Message message = getMessages().peek();
            logger.addLog("Primeira mensagem da fila: " + message.toString());
            if ( !message.isWaitForNextTime() ) {
                Message messageRemoved = getMessages().remove();
                
                if ( messageRemoved.getStatus() == MessageStatus.ANTENNA_TO_CENTRAL ) {
                    logger.addLog("Status atual da mensagem: " + messageRemoved.getStatus());
                    messageRemoved.setStatus(MessageStatus.CENTRAL_TO_DESTINATION_ANTENNA);
                    logger.addLog("Status alterado para: " + messageRemoved.getStatus());
                    getCentral().addMessage(messageRemoved);
                    logger.addLog("Mensagem adicionada na central.");
                }
                else if ( message.getStatus() == MessageStatus.ANTENNA_TO_PHONE ) {
                    logger.addLog("Status atual da mensagem: " + messageRemoved.getStatus());
                    messageRemoved.setStatus(MessageStatus.SUCCESSFUL);
                    logger.addLog("Status alterado para: " + messageRemoved.getStatus());
                    
                    Phone destinationPhone = messageRemoved.getDestinationPhone();
                    destinationPhone.addMessageToInbox(messageRemoved);
                    logger.addLog("Mensagem adicionada na caixa de entrada do telefone: " + destinationPhone.toString());
                    
                    Phone originPhone = messageRemoved.getOriginPhone();
                    originPhone.addMessageToSentbox(messageRemoved);
                    logger.addLog("Mensagem adicionada na caixa de itens enviados do telefone: " + originPhone.toString());
                }
            }
            else {
                logger.addLog("Mensagem está aguardando próximo estado de tempo.");
            }
        }
        else {
            logger.addLog("Não há mensagens na antena.");
        }
    }
    
    /**
     * Find and return a phone by identifier
     * 
     * @param identifier identifier to find
     * @return Phone
     */
    public Phone getPhoneByIdentifier(String identifier) {
        for ( Phone phone: getPhones()) {
            if ( phone.getIdentifier().equals(identifier) ) {
                return phone;
            }
        }
        return null;
    }
    
    /**
     * Add a phone to list
     * 
     * @param phone phone to add
     */
    public void addPhone(Phone phone) {
        getPhones().add(phone);
    }
    
    /**
     * Add a message to list
     * 
     * @param message message to add
     */
    public void addMessage(Message message) {
        getMessages().add(message);
    }
    
    /**
     * Verify if the queue is exhausted
     * 
     * @return boolean
     */
    public boolean isQueueExhausted() {
        return getQueueCapacity() == getMessages().size();
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
    
    @Override
    public String toString() {
        return "Nome: " + getIdentifier() + " - " + "Capacidade da fila: " + getQueueCapacity() + " - "
                + "Tempo por atendimento: " + getAttendanceTimeInterval().toString() + " - "
                + "Central: " + getCentral().getIdentifier();
    }
    
}
