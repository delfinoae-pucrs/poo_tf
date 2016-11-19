/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.utils;

import br.com.pootrabalhofinal.model.Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class SimulationSetup {
    private Simulation simulation;
    private String simulationParametersFilePath;
    private String eventsFilePath;
    
    /**
     * This method create objects of simulation and events of simulation by files path
     * 
     * @return return simulation object
     * @throws IOException 
     */
    public Simulation load() throws IOException {
        loadSimulationParametersFromFilePath();
        loadEventsFromFilePath();
        
        return getSimulation();
    }
    
    /**
     * This method create objects of simulation by file path
     * @throws IOException 
     */
    private void loadSimulationParametersFromFilePath() throws IOException {
        Path path = Paths.get(getSimulationParametersFilePath());
        try ( BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()) ) {
            String linha = null;
            while ((linha = br.readLine()) != null) {   
               
            }
        } 
        catch (IOException e) {
            throw new IOException();
        }
    }
    
    /**
     * This method create event objects of simulation by file path
     * @throws IOException 
     */
    private void loadEventsFromFilePath() throws IOException {
        Path path = Paths.get(getEventsFilePath());
        try ( BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()) ) {
            String linha = null;
            while ((linha = br.readLine()) != null) {   
               
            }
        } 
        catch (IOException e) {
            throw new IOException();
        }
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
    
}
