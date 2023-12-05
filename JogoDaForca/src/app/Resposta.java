/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author kaueq
 */
import java.util.Scanner;
public class Resposta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavraSecreta = "java";
        int tamanhoPalavra = palavraSecreta.length();
        StringBuilder palavraExibicao = new StringBuilder(tamanhoPalavra);
        for (int i = 0; i < tamanhoPalavra; i++) {
            palavraExibicao.append('_');
        }
        int maxTentativas = 6;
        int tentativas = 0;
        while (tentativas < maxTentativas) {
            System.out.println("Palavra: " + palavraExibicao.toString());
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().charAt(0);
            boolean letraCorreta = false;
            for (int i = 0; i < tamanhoPalavra; i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraExibicao.setCharAt(i, letra);
                    letraCorreta = true;
                }
            }
            if (palavraExibicao.toString().equals(palavraSecreta)) {
                System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                break;
            }
            if (!letraCorreta) {
                tentativas++;
                System.out.println("Letra incorreta! Tentativas restantes: " + (maxTentativas - tentativas));
            }
        }
        if (tentativas == maxTentativas) {
            System.out.println("Você perdeu! A palavra correta era: " + palavraSecreta);
        }
        scanner.close();
    }

    /*
    private String tentativa;

    
    
    public void setTentativa(String tentativa) {
        this.tentativa = tentativa;
    }
    
    
    public boolean verificaTentativa() {
        return this.tentativa.equals("Resposta");
    }
     */
}
