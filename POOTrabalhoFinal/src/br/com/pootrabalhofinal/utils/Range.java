/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.utils;

import java.util.Random;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Range {
    private final int min;
    private final int max;
    
    /**
     * Constructor
     * 
     * @param min min value of range
     * @param max max value of range
     */
    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    /**
     * Get random value of interval
     * @return random value
     */
    public int randomValue() {
        Random r = new Random();
	return r.nextInt((this.max - this.min) + 1) + this.min;
    }
    
    /**
     * Check if range contains the number
     * 
     * @param number number to check
     * @return boolean
     */
    public boolean contains(int number){
        return (number >= this.min && number <= this.max);
    }
    
    @Override
    public String toString() {
        return "Mínimo: " + this.min + " - " + "Máximo: " + this.max;
    }
}
