package com.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.ProdutoDAO;
import com.Model.Produto;

@SpringBootApplication
@SuppressWarnings("unused")
public class BackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
		ProdutoDAO pdao = new ProdutoDAO();
		
        Produto p2 = new Produto(2, "Bruno", "Ferramenta para gestão e calculo de fretes","Ecommerce","NodeJS");
        
        pdao.updateProducts(p2);
	}

}
