package br.com.pat.mvc.repositories;

import br.com.pat.mvc.model.Produto;

public interface ProdutoRepository {

	public Produto getProduto();

	public Produto salva(Produto produto);

}
