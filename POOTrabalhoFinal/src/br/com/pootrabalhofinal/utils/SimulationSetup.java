/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.utils;

import br.com.pootrabalhofinal.model.Antenna;
import br.com.pootrabalhofinal.model.Central;
import br.com.pootrabalhofinal.model.Event;
import br.com.pootrabalhofinal.model.Phone;
import br.com.pootrabalhofinal.model.Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.control.TextArea;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class SimulationSetup {
    private Simulation simulation;
    private String simulationParametersFilePath;
    private String eventsFilePath;
    private TextArea traceTextArea;
    
    /**
     * This method create objects of simulation and events of simulation by files path
     * 
     * @return return simulation object
     * @throws IOException 
     */
    public Simulation load() throws IOException {
        loadSimulationParameters();
        loadEvents();
        
        return getSimulation();
    }
    
    /**
     * This method create objects of simulation by simulationParametersFilePath attribute
     * 
     * @throws IOException 
     */
    public void loadSimulationParameters() throws IOException {
        traceWithMessage("--------- LEITURA DO ARQUIVO DE INSTANCIAÇÃO ---------");
        traceWithMessage("\n");
        
        this.simulation = new Simulation();
        
        Central central = new Central();
        
        Path path = Paths.get(getSimulationParametersFilePath());
        try ( BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()) ) {
            String linha = null;
            int linha_index = 0;
            int antenna_index = -1;
            int phone_index = -1;
            while ((linha = br.readLine()) != null) {  
                
                if ( linha_index == 0 ) {                   // Nome do experimento
                    String[] names = linha.split(":");
                    String name = names[1].trim();
                    this.simulation.setName(name);
                    
                    traceWithMessage("Experimento: " + this.simulation.getName());
                }
                else if ( linha_index == 1 ) {              // Tempo de simulação
                    String[] durations = linha.split(":");
                    int duration = Integer.valueOf(durations[1].trim());
                    this.simulation.setDuration(duration);
                    
                    traceWithMessage("Tempo de simulação: " + this.simulation.getDuration());
                }
                else if ( linha_index == 2 ) {              // Criação da Central
                    String[] centrals = linha.split(":");
                    String[] centralParameters = centrals[1].split(";");

                    String centralIdentifier = centralParameters[0].trim();
                    int centralProcessorsQuantity = Integer.valueOf(centralParameters[1].trim());

                    String[] centralIntervals = centralParameters[2].split("-");
                    int min = Integer.valueOf(centralIntervals[0].trim());
                    int max = Integer.valueOf(centralIntervals[1].trim());
                    Range centralProcessorsTimeInterval = new Range(min, max);
                    
                    central.setIdentifier(centralIdentifier);
                    central.setProcessorsQuantity(centralProcessorsQuantity);
                    central.setProcessorsTimeInterval(centralProcessorsTimeInterval);
                    
                    traceWithMessage("Central:");
                    traceWithMessage("\t" + central.toString());
                }
                else if ( linha_index == 3 ) {              // Quantidade de antenas
                    String[] antennaQtdString = linha.split(":");
                    antenna_index = linha_index + Integer.valueOf(antennaQtdString[1].trim());
                    
                    traceWithMessage("Quantidade de antenas: " + antennaQtdString[1].trim());
                }
                else if ( linha_index <= antenna_index ) {   // Criação das antenas
                    String[] antennasParameters = linha.split(";");
                    String antennaIdentifier = antennasParameters[0].trim();
                    int queueCapacity = Integer.valueOf(antennasParameters[1].trim());
                    
                    String[] antennaIntervals = antennasParameters[2].split("-");
                    int min = Integer.valueOf(antennaIntervals[0].trim());
                    int max = Integer.valueOf(antennaIntervals[1].trim());
                    Range attendanceTimeInterval = new Range(min, max);
                    
                    Antenna antenna = new Antenna(antennaIdentifier, queueCapacity, attendanceTimeInterval, central);
                    central.addAntenna(antenna);
                    
                    traceWithMessage("Antenas: \t" + antenna.toString());
                }
                else if ( (linha_index-1) == (antenna_index) ) {  // Quantidade de telefones e quantidade de mensagens
                    String[] phoneParameters = linha.split(":");
                    String[] phoneQtdString = phoneParameters[1].trim().split(";");
                    
                    phone_index = linha_index + Integer.valueOf(phoneQtdString[0].trim());
                    
                    String[] messageQtdIntervals = phoneQtdString[1].trim().split("-");
                    int min = Integer.valueOf(messageQtdIntervals[0].trim());
                    int max = Integer.valueOf(messageQtdIntervals[1].trim());
                    Range messageQuantityInterval = new Range(min, max);
                    
                    traceWithMessage("Quantidade de telefones: " + phoneQtdString[0].trim());
                    
                    this.simulation.setMessageQuantityInterval(messageQuantityInterval);
                    traceWithMessage("Quantidade de mensagens: " + this.simulation.getMessageQuantityInterval().toString());
                }
                else if ( linha_index <= phone_index ) {
                    String[] phoneParameters = linha.split(";");
                    String phoneIdentifier = phoneParameters[0].trim();
                    String antennaIdentifier = phoneParameters[1].trim();
                    
                    Antenna antenna = central.getAntennaByIdentifier(antennaIdentifier);
                    
                    Phone phone = new Phone(phoneIdentifier, antenna);
                    antenna.addPhone(phone);
                    
                    traceWithMessage("Telefone: \t" + phone.toString());
                }
                
                linha_index++;
            }
        } 
        catch (IOException e) {
            throw new IOException();
        }
        
        this.simulation.setCentral(central);
    }
    
    /**
     * This method create event objects of simulation by eventsFilePath attribute
     * 
     * @throws IOException 
     */
    public void loadEvents() throws IOException {
        traceWithMessage("\n");
        traceWithMessage("\n");
        traceWithMessage("--------- LEITURA DO ARQUIVO DE EVENTOS ---------");
        traceWithMessage("\n");
        
        Path path = Paths.get(getEventsFilePath());
        try ( BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()) ) {
            String linha = null;
            int linha_index = 0;
            while ((linha = br.readLine()) != null) {
                switch (linha_index) {
                    case 0:                 // Nome do experimento
                        String[] names = linha.split(":");
                        String name = names[1].trim();
                        
                        traceWithMessage("Experimento: " + name);
                        
                        if ( !this.simulation.getName().equals(name) ) {
                            throw new IOException();
                        }
                        
                        break;
                    case 1:
                        String[] eventsQtd = linha.split(":");
                        String qtd = eventsQtd[1].trim();
                        
                        traceWithMessage("Quantidade de eventos: " + qtd);
                        break;
                    default:
                        String[] events = linha.split(";");
                        String phoneOriginIdentifier = events[0];
                        String phoneDestinationIdentifier = events[1];
                        
                        Phone phoneOrigin = this.simulation.getCentral().getPhoneByIdentifier(phoneOriginIdentifier);
                        Phone phoneDestination = this.simulation.getCentral().getPhoneByIdentifier(phoneDestinationIdentifier);
                        if ( phoneOrigin == null || phoneDestination == null ) {
                            throw new IOException();
                        }
                        
                        Event event = new Event(phoneOrigin, phoneDestination);
                        this.simulation.addEvent(event);
                        
                        traceWithMessage("Evento: \t" + event.toString());
                        break;
                }
                linha_index++;
            }
        }
        catch (IOException e) {
            throw new IOException();
        }
    }
    
    /**
     * 
     * @return 
     */
    private void traceWithMessage(String msg) {
        this.traceTextArea.appendText(msg);
        this.traceTextArea.appendText("\n");
    }
    
    /*
     * Getters and setters
     */
    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public String getSimulationParametersFilePath() {
        return simulationParametersFilePath;
    }

    public void setSimulationParametersFilePath(String simulationParametersFilePath) {
        this.simulationParametersFilePath = simulationParametersFilePath;
    }

    public String getEventsFilePath() {
        return eventsFilePath;
    }

    public void setEventsFilePath(String eventsFilePath) {
        this.eventsFilePath = eventsFilePath;
    }

    public TextArea getTraceTextArea() {
        return traceTextArea;
    }

    public void setTraceTextArea(TextArea traceTextArea) {
        this.traceTextArea = traceTextArea;
    }
    
}
