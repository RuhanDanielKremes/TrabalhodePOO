/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField checkbox;
    @FXML
    private TextField chutar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO    
        Processador jogo1 = new Processador(1, "rabisco".toUpperCase());
        checkbox.setText(jogo1.visor());
        tentar.setOnAction(e -> {
            jogo1.tentativa(chutar.getText());
        });
        
        

    }

    
        //scanner.close();
        //System.out.println(jogo1.visor());
    } 
    /*
    @FXML
    private void enviar(ActionEvent event) {
        Resposta resposta1 = new Resposta();
        resposta1.setTentativa(palavra.getText());
        System.out.println(resposta1.verificaTentativa());   
    }
        */

//    @FXML
//    private void verificarPalavra(ActionEvent event) {
//        jogo1.tentativa(scanner.nextLine().toUpperCase());
//    }
    
//    public void mudarTexto(ActionEvent event) {
//        checkbox.setText("Novo Texto");
//    }
    
//}