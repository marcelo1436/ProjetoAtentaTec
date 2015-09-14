package br.com.pat.mvc.repositories;

import java.util.List;

import br.com.pat.mvc.model.Produto;

public interface ProdutoRepository {

	public void salva(Produto produto);

	public List<Produto> getProdutos(Produto produto);

}
