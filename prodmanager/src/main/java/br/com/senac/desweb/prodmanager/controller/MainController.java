package br.com.senac.desweb.prodmanager.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.senac.desweb.prodmanager.dao.ProdutoDAO;
import br.com.senac.desweb.prodmanager.model.Produto;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/listarProduto")
	public ModelAndView listarProdutos(){
		ProdutoDAO produtoDao = new ProdutoDAO();
		List<Produto> produtos = new ArrayList<>();
		try {
			produtos = produtoDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("listar").addObject("produtos", produtos);
	}
}
