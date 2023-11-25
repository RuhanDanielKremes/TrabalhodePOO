/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import app.*;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author kaueq
 */
public class JogoController implements Initializable {

    @FXML
    private Button tentar;
    @FXML
    private TextField letra;
    @FXML
    private TextField palavra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO
    } 
    
    @FXML
    private void enviar(ActionEvent event) {
        Resposta resposta1 = new Resposta();
        resposta1.setTentativa(palavra.getText());
        System.out.println(resposta1.verificaTentativa());   
    }
        
}
