/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Scanner;

/**
 *
 * @author kaueq
 */
public class TesteMain {
    
    public void teste(){
        Processador jogo1 = new Processador(1, "rabisco".toUpperCase());
        Scanner scanner = new Scanner(System.in);
        do{
        System.out.println(jogo1.visor());
        jogo1.tentativa(scanner.nextLine().toUpperCase());
        }while(!jogo1.win);
        scanner.close();
        System.out.println(jogo1.visor());
    }
}
