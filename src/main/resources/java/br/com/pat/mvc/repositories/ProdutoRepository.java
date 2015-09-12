package br.com.pat.mvc.repositories;

import java.util.List;

import br.com.pat.mvc.model.Produto;

public interface ProdutoRepository {

	public List<Produto> getProdutos();

	public void salva(Produto produto);

}
