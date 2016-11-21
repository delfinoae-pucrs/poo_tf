/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.utils;

/**
 * 
 * 
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public enum MessageStatus {
    
    /**
     * Message to send to antenna
     */
    SEND_TO_ANTENNA,
    /**
     * Message to send to central
     */
    SEND_TO_CENTRAL,
    /**
     * Message to send to phone
     */
    SEND_TO_PHONE,
    /**
     * Message delivered successful
     */
    SUCCESSFUL,
    /**
     * Message not delivered to destination phone, but was delivered with error to origin phone
     */
    FAILURE_DELIVERED,
    /**
     * Message not delivered to destination phone and was not delivered with error to origin phone too
     */
    FAILURE_NOT_DELIVERED
}
