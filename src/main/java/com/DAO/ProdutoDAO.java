package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Factory.ConnectionFactory;
import com.Model.Produto;

public class ProdutoDAO {
	
    private Connection connection;
    
    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
        this.createTableProduct();
    }
    
    ///////////////////////////////////////////////////////////////////////
    
    public void createTableProduct() {
        String sql = "CREATE TABLE if not exists produtos (\r\n"
        		+ " Id_produto INT PRIMARY KEY AUTO_INCREMENT,\r\n"
        		+ " nome VARCHAR(100) NOT NULL,\r\n"
        		+ " descricao VARCHAR(100) NOT NULL,\r\n"
        		+ " mercado VARCHAR(100) NOT NULL,\r\n"
        		+ " tecnologia VARCHAR(100) NOT NULL\r\n"
        		+ " );\r\n";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Table Product Create Successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    ///////////////////////////////////////////////////////////////////////
    
    public void saveProducts(Produto p) {
        String sql = "INSERT INTO produtos" +
                " (nome, descricao, mercado, tecnologia) " +
                "VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getMercado());
            stmt.setString(4, p.getTecnologia());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    ///////////////////////////////////////////////////////////////////////
    
    public void listProducts() {
        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet produtos = stmt.executeQuery();

            while (produtos.next()) {
                System.out.println(produtos.getInt("Id_produto"));
                System.out.println(produtos.getString("nome"));
                System.out.println(produtos.getString("descricao"));
                System.out.println(produtos.getString("mercado"));
                System.out.println(produtos.getString("tecnologia"));
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void updateProducts(Produto p) {
        String update = "update produtos set nome =?, descricao =?, mercado =?, tecnologia =? where Id_produto = ?;";
        
        try{
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getDescricao());
            statement.setString(3, p.getMercado());
            statement.setString(4, p.getTecnologia());
            statement.setInt(5, p.getId_produto());
            statement.execute();
            statement.close();
            System.out.println("Register updated sucessful");

        } catch (SQLException exception){
            System.out.println("Error in atualization of dates");
            System.out.println(exception);
            throw  new RuntimeException(exception);
        }
    }

    public void deleteProduct(int id) {
        String delete = "delete from produtos where Id_produto = ?;";

        try{
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            System.out.println("Line deleted sucessful");

        }catch (SQLException exception){
            System.out.println("Error in inclusion of dates");
            System.out.println(exception);
            throw  new RuntimeException(exception);
        }
    }
}
