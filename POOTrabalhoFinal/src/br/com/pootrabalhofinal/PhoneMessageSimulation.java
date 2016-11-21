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
import javafx.stage.Stage;

/**
 *
 * @author allanederich
 */
public class PhoneMessageSimulation extends Application {
    Stage primaryStage;
    Button startSimulation;
    Simulation simulation;
    TextField eventsTextField;
    Button loadEventsButton;
    TextArea traceTextArea;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
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
        
        Button btnSetup = new Button("Configurar");
        btnSetup.setMaxWidth(Double.MAX_VALUE);
        btnSetup.setOnAction((ActionEvent event) -> {
            createSetupWindow();
        });
        
        this.startSimulation = new Button("Iniciar Simulação");
        this.startSimulation.setMaxWidth(Double.MAX_VALUE);
        this.startSimulation.setDisable(true);
        this.startSimulation.setOnAction((ActionEvent event) -> {
            createRunWindow();
        });
        
        grid.add(lblWelcome,            0, 0);
        grid.add(btnSetup,              0, 2);
        grid.add(this.startSimulation,  0, 3);
        
        Scene scene = new Scene(grid, 400, 200);
        this.primaryStage.setTitle("Simulador de Mensagens entre Telefone Celulares");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
    
    private void createSetupWindow() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
//        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        
        SimulationSetup simulationSetup = new SimulationSetup();
        
        createSetupParametersBlock(grid, simulationSetup);
        createSetupEventsBlock(grid, simulationSetup);
        createSetupTraceBlock(grid);
        createSetupSaveBlock(grid);
        
        Scene scene = new Scene(grid, 1000, 600);
        
        Stage stage = new Stage();
        stage.setX(this.primaryStage.getX() - 350);
        stage.setY(this.primaryStage.getY() - 100);
        stage.setTitle("Configurar simulação");
        stage.setScene(scene);
        stage.show();
    }
    
    private void createSetupParametersBlock(GridPane grid, SimulationSetup simulationSetup) {
        Label label = new Label("Nome do arquivo de instanciação: ");
        label.setPrefWidth(230.0);
        label.setAlignment(Pos.CENTER_RIGHT);
        grid.add(label, 0, 0);
        
        TextField fileTextField = new TextField();
        fileTextField.setPrefWidth(400.0);
        grid.add(fileTextField, 1, 0);
        
        Button btn = new Button("Carregar");
        btn.setPrefWidth(100.0);
        grid.add(btn, 2, 0);
        
        btn.setOnAction(((event) -> {
            if ( fileTextField.getText().length() > 0 ) {
                simulationSetup.setSimulationParametersFilePath(fileTextField.getText());
                try {
                    simulationSetup.setTraceTextArea(this.traceTextArea);
                    simulationSetup.loadSimulationParameters();
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
    
    private void createSetupEventsBlock(GridPane grid, SimulationSetup simulationSetup) {
        Label label = new Label("Nome do arquivo de eventos: ");
        label.setPrefWidth(230.0);
        label.setAlignment(Pos.CENTER_RIGHT);
        grid.add(label, 0, 1);
        
        this.eventsTextField = new TextField();
        this.eventsTextField.setPrefWidth(400.0);
        this.eventsTextField.setDisable(true);
        grid.add(this.eventsTextField, 1, 1);
        
        this.loadEventsButton = new Button("Carregar");
        this.loadEventsButton.setPrefWidth(100.0);
        this.loadEventsButton.setDisable(true);
        grid.add(this.loadEventsButton, 2, 1);
        
        this.loadEventsButton.setOnAction(((event) -> {
            if ( this.eventsTextField.getText().length() > 0 ) {
                simulationSetup.setEventsFilePath(this.eventsTextField.getText());
                try {
                    simulationSetup.loadEvents();
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
        
        grid.add(this.traceTextArea, 1, 3, 1, 2);
    }
    
    private void createSetupSaveBlock(GridPane grid) {
        this.startSimulation.setDisable(false);
    }
    
    private void createRunWindow() {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
