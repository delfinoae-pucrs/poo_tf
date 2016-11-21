/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Allan Ederich <delfino.ae@gmail.com>
 */
public class Utils {
    
    /**
     * Method to create a popup window with a message
     * 
     * @param stage stage to create the popup
     * @param message message to show in popup
     */
    public static void alertWithMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION, message, ButtonType.OK);
        alert.show();
    }
    
    /**
     * Method to log a message
     * 
     * @param msg message to log
     */
    public static void debug(String msg) {
        System.out.println("*+*+*+*+* DEBUG *+*+*+*+*");
        System.out.println(msg);
        System.out.println("*+*+*+*+* DEBUG *+*+*+*+*");
    }
    
}
