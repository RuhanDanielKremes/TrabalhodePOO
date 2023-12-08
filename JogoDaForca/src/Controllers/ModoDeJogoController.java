/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kaueq
 */
public class ModoDeJogoController implements Initializable {

    @FXML
    private Button classificacao;
    @FXML
    private Button abrejogo;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    
    Image midia1 = new Image(getClass().getClassLoader().getResourceAsStream("./Imagemjogo/0.jpeg"));
    Image midia2 = new Image(getClass().getClassLoader().getResourceAsStream("./Imagemjogo/abcdario.jpg"));

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void abrirclassificacao(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("./telas/Scoreboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void abrejogo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("./telas/Jogo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        img1.setImage(midia1);
        img2.setImage(midia2);
    }    

    
    
}
