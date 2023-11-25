/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author kaueq
 */
public class Resposta {
    
    private String tentativa;

    
    
    public void setTentativa(String tentativa) {
        this.tentativa = tentativa;
    }
    
    
    public boolean verificaTentativa() {
        return this.tentativa.equals("Resposta");
    }

    
    
}
