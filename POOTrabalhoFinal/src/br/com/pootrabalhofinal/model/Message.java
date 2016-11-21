/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.model;

import br.com.pootrabalhofinal.utils.MessageStatus;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Message {
    private Phone originPhone;
    private Phone destinationPhone;
    private MessageStatus status;
    
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
    
}
