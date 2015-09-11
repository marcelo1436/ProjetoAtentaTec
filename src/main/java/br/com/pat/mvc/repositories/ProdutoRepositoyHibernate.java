package br.com.pat.mvc.repositories;

import java.util.List;

import br.com.pat.mvc.model.Produto;

public class ProdutoRepositoyHibernate extends RepositoryBase implements ProdutoRepository {

	@Override
	public List<Produto> getProdutos() {
		return this.hibernateTemplate.loadAll(Produto.class);
	}

	@Override
	public void salva(Produto produto) {
		this.hibernateTemplate.save(produto);

	}

}
