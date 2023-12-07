/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author kaueq
 */
public class Processador {

    int idjogo, tamanho;
    char[] espacos;
    char[] espacosStatus;
    int count;
    String resposta;
    boolean win;

    public Processador(int idjogo, String jogo) {
        this.idjogo = idjogo;
        this.resposta = jogo;
        this.tamanho = jogo.length();
        this.count = 0;
        this.win = false;
        constructorEspacos(jogo);
    }

    private void constructorEspacos(String jogo) {
        this.espacos = new char[this.tamanho];
        this.espacosStatus = new char[(this.tamanho) * 2];
        this.espacos = jogo.toCharArray();
        reset();
    }

    private void reset() {
        for (int i = 0; i < this.tamanho * 2; i++) {
            if ((i % 2) == 0) {
                this.espacosStatus[i] = '_';
            } else {
                this.espacosStatus[i] = ' ';
            }
        }
    }

    public String visor() {
        return new String(this.espacosStatus);
    }

    public void tentativa(String tentativa) {
        if (tentativa.matches("[a-zA-Z]+")) {
            if (tentativa.length() > 1) {
                if (tentativa == this.resposta) {
                    this.win = true;
                    resposta('0', 0);
                }
            } else {
                resposta(tentativa.charAt(0), 1);
            }
        } else {
            System.out.println("CARACTER INVALIDO");
        }
    }

    private void resposta(char tentativa, int op) {
        if (op == 1) {
            count = 0;
            for (int i = 0; i < this.tamanho; i++) {
                if (tentativa == this.espacos[i]) {
                    this.espacosStatus[i * 2] = this.espacos[i];
                    if (this.espacosStatus[i * 2] == this.espacos[i]) {
                        count++;
                    }
                }
            }
            if (count == this.tamanho) {
                this.win = true;
            }
        } else {
            for (int i = 1; i <= this.tamanho; i++) {
                this.espacosStatus[i * 2] = this.espacos[i];
            }
        }
    }
}
