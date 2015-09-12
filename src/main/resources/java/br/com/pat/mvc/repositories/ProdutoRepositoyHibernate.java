package br.com.pat.mvc.repositories;

import br.com.pat.mvc.model.Produto;

public class ProdutoRepositoyHibernate extends RepositoryBase implements ProdutoRepository {

	@Override
	public Produto getProduto() {
		return this.hibernateTemplate.get(Produto.class, null);
	}

	@Override
	public void salva(Produto produto) {
		this.hibernateTemplate.save(produto);

	}

}
