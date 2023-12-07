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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoETabelas {

    public static void main(String[] args) {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/";
        String usuario = "postgres";
        String senha = "99135287wwe";
        String nomeBanco = "Banco_de_Dados";
        String tabelaUsuarios = "CREATE TABLE IF NOT EXISTS tabelaUsuarios (id SERIAL PRIMARY KEY, nome VARCHAR(255))";
        String tabelaJogos = "CREATE TABLE IF NOT EXISTS tabelaJogos (id SERIAL PRIMARY KEY, tentativa VARCHAR(50))";

        try {
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url + nomeBanco, usuario, senha);

            Statement statement = conexao.createStatement();

            // Criação do banco de dados
            String queryBanco = "CREATE DATABASE " + nomeBanco;
            statement.executeUpdate(queryBanco);
            System.out.println("Banco de dados criado com sucesso.");

            // Criação da tabela tabelaUsuarios
            statement.executeUpdate(tabelaUsuarios);
            System.out.println("Tabela tabelaUsuarios criada com sucesso.");

            // Criação da tabela tabelaJogos
            statement.executeUpdate(tabelaJogos);
            System.out.println("Tabela tabelaJogos criada com sucesso.");

            statement.close();
            conexao.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
