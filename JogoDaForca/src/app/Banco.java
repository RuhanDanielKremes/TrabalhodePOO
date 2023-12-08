/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author kaueq
 */
import java.sql.*;

public class Banco {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String senha = "99135287wwe";
        String database = "jogodaforca";

        Connection con = null;
        Statement stat = null;

        try {
            con = DriverManager.getConnection(url + database, user, senha);
            stat = con.createStatement();
        } catch (SQLException SQLe) {
            try {
                con = DriverManager.getConnection(url, user, senha);
                stat = con.createStatement();
                stat.executeUpdate("CREATE DATABASE " + database);
                con = DriverManager.getConnection(url + database, user, senha);
                stat = con.createStatement();
            } catch (SQLException SQLe2) {
                System.out.println(SQLe2);
            }
        }

        try {
            stat.executeUpdate("CREATE TABLE Usuario (idUsuario SERIAL PRIMARY KEY NOT NULL, nome VARCHAR(50), pontuacao integer)");
            
            stat.executeUpdate("CREATE TABLE Jogos (idJogos SERIAL PRIMARY KEY NOT NULL, tentativa VARCHAR(50))");

            System.out.println("Banco criado com sucesso!");

        } catch (SQLException SQLe3) {
            System.out.println(SQLe3);
        }

    }
}
