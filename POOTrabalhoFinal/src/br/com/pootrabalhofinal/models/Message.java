/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.models;

import br.com.pootrabalhofinal.utils.MessageStatus;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Message {
    private Phone originPhone;
    private Phone destinationPhone;
    private MessageStatus status;
    private boolean waitForNextTime;
    private boolean sendAgain;
    private int sendQuantity;
    
    /**
     * Constructor
     * 
     * @param originPhone origin phone that sent the message
     * @param destinationPhone destination phone to send the message
     * @param status status of message
     */
    public Message(Phone originPhone, Phone destinationPhone, MessageStatus status) {
        this.originPhone = originPhone;
        this.destinationPhone = destinationPhone;
        this.status = status;
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

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public boolean isSendAgain() {
        return sendAgain;
    }

    public void setSendAgain(boolean sendAgain) {
        this.sendAgain = sendAgain;
    }

    public int getSendQuantity() {
        return sendQuantity;
    }

    public void setSendQuantity(int sendQuantity) {
        this.sendQuantity = sendQuantity;
    }
    
    public boolean isWaitForNextTime() {
        return waitForNextTime;
    }

    public void setWaitForNextTime(boolean waitForNextTime) {
        this.waitForNextTime = waitForNextTime;
    }
    
    public boolean equals(Message otherMessage) {
        boolean sameOriginPhone = getOriginPhone().getIdentifier().equals(otherMessage.getOriginPhone().getIdentifier());
        boolean sameDestinationPhone = getDestinationPhone().getIdentifier().equals(otherMessage.getDestinationPhone().getIdentifier());
        boolean sameStatus = getStatus().equals(otherMessage.getStatus());
        
        return sameOriginPhone && sameDestinationPhone && sameStatus;
    }
}
