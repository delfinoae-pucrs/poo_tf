/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author allanederich
 */
public class PhoneMessageSimulation extends Application {
    Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        createScreenElements();
    }
    
    private void createScreenElements() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
//        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label lblWelcome = new Label("Bem vindo ao primeiro simulador de mensagens entre telefones celulares do Brasil :)");
        lblWelcome.setWrapText(true);
        lblWelcome.setAlignment(Pos.CENTER);
        
        Button btnSetup = new Button("Configurar");
        btnSetup.setMaxWidth(Double.MAX_VALUE);
        btnSetup.setOnAction((ActionEvent event) -> {
            System.out.println("Setup tapped !!!");
        });
        
        Button btnRun = new Button("Iniciar Simulação");
        btnRun.setMaxWidth(Double.MAX_VALUE);
        btnRun.setOnAction((ActionEvent event) -> {
            System.out.println("Run tapped !!!");
        });
        
        grid.add(lblWelcome,    0, 0);
        grid.add(btnSetup,      0, 2);
        grid.add(btnRun,        0, 3);
        
        Scene scene = new Scene(grid, 300, 200);
        this.primaryStage.setTitle("Simulador de Mensagens entre Telefone Celulares");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
