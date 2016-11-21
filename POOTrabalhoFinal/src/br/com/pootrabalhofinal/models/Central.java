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
    public void updateMessages(Logger logger) {
        if (getMessages().size() > 0) {
            logger.addLog("Tamanho da pilha da central: " + String.valueOf(getMessages().size()));
            Message message = getMessages().peek();
            logger.addLog("Mensagem do topo da pilha: " + message.toString());
            if ( message.getStatus() == MessageStatus.CENTRAL_TO_ORIGIN_ANTENNA ) {
                logger.addLog("Esta mensagem deve retornar para a antena de origem");
                Message messageRemoved = getMessages().pop();
                Antenna originAntenna = message.getOriginPhone().getAntenna();
                logger.addLog("Antena de origem: " + originAntenna.toString());
                if ( originAntenna.isQueueExhausted() ) {
                    logger.addLog("Antena de origem lotada. Mensagem foi perdida.");
                    logger.addLog("Status da mensagem alterado para: " + MessageStatus.FAILURE_NOT_DELIVERED);
                    message.setStatus(MessageStatus.FAILURE_NOT_DELIVERED);
                }
                else {
                    logger.addLog("Antena de origem com espaço. Mensagem foi enviada para a antena de origem.");
                    originAntenna.addMessage(messageRemoved);
                }
            }
            else if ( message.getStatus() == MessageStatus.CENTRAL_TO_DESTINATION_ANTENNA ) {
                logger.addLog("Esta mensagem deve ir para a antena de destino");
                Antenna destinationAntenna = message.getDestinationPhone().getAntenna();
                logger.addLog("Antena de destino: " + destinationAntenna.toString());
                if ( destinationAntenna.isQueueExhausted() ) {
                    logger.addLog("Antena de destino lotada. Mensagem deve ser enviada para a antena de origem.");
                    logger.addLog("Status da mensagem alterado para: " + MessageStatus.CENTRAL_TO_ORIGIN_ANTENNA);
                    message.setStatus(MessageStatus.CENTRAL_TO_ORIGIN_ANTENNA);
                }
                else {
                    logger.addLog("Antena de destino com espaço. Mensagem deve ser enviada para a antena de destino.");
                    logger.addLog("Status da mensagem alterado para: " + MessageStatus.ANTENNA_TO_PHONE);
                    message.setStatus(MessageStatus.ANTENNA_TO_PHONE);
                    message.setWaitForNextTime(true);
                    destinationAntenna.addMessage(this.messages.pop());
                }
            }
        }
        else {
            logger.addLog("Não há mensagens na central.");
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
