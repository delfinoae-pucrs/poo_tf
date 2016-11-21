/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.utils;

import java.util.ArrayList;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Logger {
    private ArrayList<String> logs = new ArrayList<>();
    
    /**
     * Add a log to list.
     * 
     * @param log log to add
     */
    public void addLog(String log) {
        getLogs().add(log);
        getLogs().add(" \n ");
    }
    
    /*
     * Getters and Setters
     */
    public ArrayList<String> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<String> logs) {
        this.logs = logs;
    }
    
}
