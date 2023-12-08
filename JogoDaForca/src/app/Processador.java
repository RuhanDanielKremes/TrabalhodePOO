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
    boolean[] alfabetoaux;
    int count, aux;
    String resposta, alfabeto, letrasusadas;
    int erros, acerto;
    boolean win;

    public Processador(int idjogo, String jogo) {
        this.idjogo = idjogo;
        this.resposta = jogo;
        this.tamanho = jogo.length();
        this.count = 0;
        constructorEspacos(jogo);
    }

    private void constructorEspacos(String jogo) {
        this.espacos = new char[this.tamanho];
        this.espacosStatus = new char[(this.tamanho) * 2];
        this.espacos = jogo.toCharArray();
        this.alfabetoaux = new boolean[26];
        this.alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
        erros = 0;
        acerto = 0;
        win = false;
        for (int i = 0; i< 26; i++){
            this.alfabetoaux[i] = false;
        }
    }

//atualiza o visor a partir das respostas dadas e a atualização do vetor espacos Status
    
    public String visor() {
        return new String(this.espacosStatus);
    }

    public String visorLetrasUsadas(){
        letrasusadas = "";
        for (int i = 0; i < 26; i++) {
            
            if (this.alfabetoaux[i]) {
                letrasusadas += alfabeto.charAt(i);
                letrasusadas += " - ";
            }
        }
        return letrasusadas;
    }
    //verificarSePalavraOuLetra procura identificar se a tentativa do
    //usuario é uma palavra ou uma letra e encaminha para checarRespostas
    //como op 0 caso seja uma palavra e op 1 caso seja letra
    
    public void verificarSePalavraOuLetra(String tentativa) {
        if (tentativa.matches("[a-zA-Z]+")) {
            if (tentativa.length() > 1) {
                if (tentativa.equals(this.resposta)) {
                    this.win = true;
                    System.out.println("WIN");
                    checarRespostas('0', 0);
                }else{
                    erros++;
                }
            } else {
                if (!tentativa.isEmpty()) {
                    if (!verificaSeJaExisteLetra(tentativa.charAt(0))){
                        checarRespostas(tentativa.charAt(0), 1);                    
                    }
                }             
            }
        } else {
            System.out.println("CARACTER INVALIDO");
        }
    }

    //checarRespostas recebe a letra(se for palavra ele passa um caracter
    //inutil) e verifica se ele está presente na palavra oculda(resposta)
    
    private void checarRespostas(char tentativa, int op) {
        if (op == 1) {
            count = 0;
            for (int i = 0; i < this.tamanho; i++) {
                //System.out.println(tentativa);
                if (tentativa == this.espacos[i]) {
                    this.espacosStatus[i * 2] = this.espacos[i];
                    if (this.espacosStatus[i * 2] == this.espacos[i]) {
                        count++;
                    }
                    acerto++;
                }
            }
//----------------contador de erros e verificador de vitória----------------
            if(acerto == 0){
                erros++;
                System.out.println("ERROS:" + erros);
            }
            if (count == this.tamanho) {
                this.win = true;
                System.out.println("WIN");
            }
        acerto = 0;    
//seta o espaço status com a palavra resposta para aparecer no visor-------
        } else {
            for (int i = 0; i < this.tamanho; i++) {
                this.espacosStatus[i * 2] = this.espacos[i];
            }
        }
    System.out.println(visor());
    }
    
    private boolean verificaSeJaExisteLetra(char tentativa){
        aux = Character.getNumericValue(tentativa)-9;
        System.out.println(aux);
        if (!this.alfabetoaux[aux-1]){
            this.alfabetoaux[aux-1]=true;
            return false;
        }else{ 
            return true;
        }    
    }
}
