/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kaueq
 */
public class EntrarController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private Button iniciarjogo;
    @FXML
    private Button classificacao;
    @FXML
    private Button sair;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void abrirmododejogo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModoDeJogo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void abrirclassificacao(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scoreboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void sair(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarjogo.setDisable(true);
        usernameField.textProperty().addListener((observable, oldValue, newValue) -> {
            iniciarjogo.setDisable(newValue.trim().isEmpty());
        });
    }
}
