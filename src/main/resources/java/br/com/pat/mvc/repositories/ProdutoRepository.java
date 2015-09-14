package br.com.pat.mvc.repositories;

import java.util.List;

import br.com.pat.mvc.model.Produto;

public interface ProdutoRepository {

	public Integer salva(Produto produto);
	
	public Produto getProduto(Integer id);

	public List<Produto> getProdutos(Produto produto);

	public void alterar(Produto produto);
}
