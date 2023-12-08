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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kaueq
 */
public class JogoController implements Initializable {

    private Processador jogo1;
    
    @FXML
    private Button tentar;
    @FXML
    private TextField checkbox;
    @FXML
    private TextField chutar;
    @FXML
    private ImageView midia;
    @FXML
    private TextField letras;
    @FXML
    private Label erros;
    @FXML
    private Label vitoria;
    
    Image img0 = new Image(getClass().getResourceAsStream("0.jpeg"));
    Image img1 = new Image(getClass().getResourceAsStream("1.jpeg"));
    Image img2 = new Image(getClass().getResourceAsStream("2.jpeg"));
    Image img3 = new Image(getClass().getResourceAsStream("3.jpeg"));
    Image img4 = new Image(getClass().getResourceAsStream("4.jpeg"));
    Image img5 = new Image(getClass().getResourceAsStream("5.jpeg"));
    
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO    
        jogo1 = new Processador(1, "rabisco".toUpperCase());
        checkbox.setDisable(true);
        letras.setDisable(true);
        checkbox.setText(jogo1.visor());
        midia.setImage(img0);
        erros.setText("ERROS: " + jogo1.erros);
    }

    @FXML
    public void verificarPalavra(ActionEvent event) {
        jogo1.verificarSePalavraOuLetra(chutar.getText().toUpperCase());
        checkbox.setText(jogo1.visor());
        letras.setText(jogo1.visorLetrasUsadas());
        erros.setText("ERROS: " + jogo1.erros);
        if (jogo1.win) {
            vitoria.setText("VITÓRIA");
            chutar.setDisable(true);
            tentar.setDisable(true);
        }
        switch (jogo1.erros) {
            case 0: midia.setImage(img0);
                break;
            case 1: midia.setImage(img1);
                break;
            case 2: midia.setImage(img2);
                break;
            case 3: midia.setImage(img3);
                break;
            case 4: midia.setImage(img4);
                break;
            case 5: midia.setImage(img5);
            default:
                throw new AssertionError();
        }
    }    
}