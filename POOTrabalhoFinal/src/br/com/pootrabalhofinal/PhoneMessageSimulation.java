/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pootrabalhofinal;

import br.com.pootrabalhofinal.model.Simulation;
import br.com.pootrabalhofinal.utils.SimulationSetup;
import br.com.pootrabalhofinal.utils.Utils;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 *
 * @author allanederich
 */
public class PhoneMessageSimulation extends Application {
    Stage welcomeStage;
    Stage setupStage;
    
    SimulationSetup simulationSetup;
    Simulation simulation;
    
    Button startSimulation;
    Button loadSimulationParametersButton;
    Button loadEventsButton;
    Button closeSetupButton;
    Button resetSetupButton;
    
    TextField eventsTextField;
    TextField simulationParametersTextField;
    TextArea traceTextArea;
    
    @Override
    public void start(Stage primaryStage) {
        this.welcomeStage = primaryStage;
        
        createWelcomeWindow();
    }
    
    private void createWelcomeWindow() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
//        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label lblWelcome = new Label("Bem vindo ao primeiro simulador de mensagens entre telefones celulares do Brasil :)");
        lblWelcome.setWrapText(true);
        lblWelcome.setAlignment(Pos.CENTER);
        
        Button btnSetup = new Button("Configurações");
        btnSetup.setMaxWidth(Double.MAX_VALUE);
        btnSetup.setOnAction((ActionEvent event) -> {
            createSetupWindow();
        });
        
        Label lblRunning = new Label("Executando simulação...");
        lblRunning.setVisible(false);
        lblRunning.setMaxWidth(Double.MAX_VALUE);
        lblRunning.setAlignment(Pos.CENTER);
        lblRunning.setFont(Font.font("Arial", FontPosture.ITALIC, 12));
        
        this.startSimulation = new Button("Iniciar Simulação");
        this.startSimulation.setMaxWidth(Double.MAX_VALUE);
        this.startSimulation.setDisable(true);
        this.startSimulation.setOnAction((ActionEvent event) -> {
            this.startSimulation.setDisable(true);
            lblRunning.setVisible(true);
            this.simulation.run();
        });
        
        grid.add(lblWelcome,            0, 0);
        grid.add(btnSetup,              0, 2);
        grid.add(this.startSimulation,  0, 3);
        grid.add(lblRunning,            0, 4);
        
        Scene scene = new Scene(grid, 400, 200);
        this.welcomeStage.setTitle("Simulador de Mensagens entre Telefone Celulares");
        this.welcomeStage.setScene(scene);
        this.welcomeStage.show();
    }
    
    private void createSetupWindow() {
        if ( this.simulationSetup == null ) {
            this.simulationSetup = new SimulationSetup();
        }
        
        if ( this.setupStage != null ) {
            this.setupStage.show();
            return;
        }
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
//        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        createSetupParametersBlock(grid);
        createSetupEventsBlock(grid);
        createSetupTraceBlock(grid);
        createSetupSaveBlock(grid);
        
        Scene scene = new Scene(grid, 1000, 400);
        
        this.setupStage = new Stage();
        this.setupStage.setX(this.welcomeStage.getX() - 350);
        this.setupStage.setY(this.welcomeStage.getY() - 100);
        this.setupStage.setTitle("Configurar simulação");
        this.setupStage.setScene(scene);
        this.setupStage.show();
    }
    
    private void createSetupParametersBlock(GridPane grid) {
        Label label = new Label("Nome do arquivo de instanciação: ");
        label.setPrefWidth(230.0);
        label.setAlignment(Pos.CENTER_RIGHT);
        grid.add(label, 0, 0);
        
        this.simulationParametersTextField = new TextField();
        this.simulationParametersTextField.setPrefWidth(400.0);
        this.simulationParametersTextField.setText("/Users/allanederich/Desktop/INSTANCIACAO1.txt");
        grid.add(this.simulationParametersTextField, 1, 0, 3, 1);
        
        this.loadSimulationParametersButton = new Button("Carregar");
        this.loadSimulationParametersButton.setPrefWidth(100.0);
        grid.add(this.loadSimulationParametersButton, 5, 0);
        
        this.loadSimulationParametersButton.setOnAction(((event) -> {
            if ( this.simulationParametersTextField.getText().length() > 0 ) {
                this.simulationSetup.setSimulationParametersFilePath(this.simulationParametersTextField.getText());
                try {
                    this.simulationSetup.setTraceTextArea(this.traceTextArea);
                    this.simulationSetup.loadSimulationParameters();
                    this.eventsTextField.setDisable(false);
                    this.loadEventsButton.setDisable(false);
                } catch (IOException ex) {
                    Utils.alertWithMessage("Falha na leitura do arquivo!");
                }
            }
            else {
                Utils.alertWithMessage("Por favor, informe o nome do arquivo de instanciação!");
            }
        }));
    }
    
    private void createSetupEventsBlock(GridPane grid) {
        Label label = new Label("Nome do arquivo de eventos: ");
        label.setPrefWidth(230.0);
        label.setAlignment(Pos.CENTER_RIGHT);
        grid.add(label, 0, 1);
        
        this.eventsTextField = new TextField();
        this.eventsTextField.setPrefWidth(400.0);
        this.eventsTextField.setDisable(true);
        this.eventsTextField.setText("/Users/allanederich/Desktop/EVENTOS1.txt");
        grid.add(this.eventsTextField, 1, 1, 3, 1);
        
        this.loadEventsButton = new Button("Carregar");
        this.loadEventsButton.setPrefWidth(100.0);
        this.loadEventsButton.setDisable(true);
        grid.add(this.loadEventsButton, 5, 1);
        
        this.loadEventsButton.setOnAction(((event) -> {
            if ( this.eventsTextField.getText().length() > 0 ) {
                this.simulationSetup.setEventsFilePath(this.eventsTextField.getText());
                try {
                    this.simulationSetup.loadEvents();
                    this.simulation = this.simulationSetup.getSimulation();
                    this.closeSetupButton.setDisable(false);
                    this.resetSetupButton.setDisable(false);
                    
                    this.simulationParametersTextField.setDisable(true);
                    this.loadSimulationParametersButton.setDisable(true);
                    
                    this.eventsTextField.setDisable(true);
                    this.loadEventsButton.setDisable(true);
                } catch (IOException ex) {
                    Utils.alertWithMessage("Falha na leitura do arquivo!");
                }
            }
            else {
                Utils.alertWithMessage("Por favor, informe o nome do arquivo de eventos!");
            }
        }));
    }
    
    private void createSetupTraceBlock(GridPane grid) {
        this.traceTextArea = new TextArea();
        this.traceTextArea.setEditable(false);
        
        grid.add(this.traceTextArea, 1, 3, 3, 2);
    }
    
    private void createSetupSaveBlock(GridPane grid) {
        Button btn_space = new Button("Space button");
        btn_space.setPrefWidth(250.0);
        btn_space.setVisible(false);
        grid.add(btn_space, 1, 5);
        
        this.resetSetupButton = new Button("Resetar");
        this.resetSetupButton.setPrefWidth(150.0);
        this.resetSetupButton.setDisable(true);
        grid.add(this.resetSetupButton, 2, 5);
        
        this.resetSetupButton.setOnAction(((event) -> {
            this.simulationParametersTextField.setText("");
            this.simulationParametersTextField.setDisable(false);
            this.loadSimulationParametersButton.setDisable(false);
            
            this.eventsTextField.setText("");
            this.eventsTextField.setDisable(true);
            this.loadEventsButton.setDisable(true);
            
            this.traceTextArea.setText("");
            
            this.simulationSetup = new SimulationSetup();
            this.simulation = null;
            this.startSimulation.setDisable(true);
            
            this.closeSetupButton.setDisable(true);
            this.resetSetupButton.setDisable(true);
        }));
        
        this.closeSetupButton = new Button("Fechar");
        this.closeSetupButton.setPrefWidth(150.0);
        this.closeSetupButton.setDisable(true);
        grid.add(this.closeSetupButton, 3, 5);
        
        this.closeSetupButton.setOnAction(((event) -> {
            this.startSimulation.setDisable(false);
            this.setupStage.hide();
        }));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
