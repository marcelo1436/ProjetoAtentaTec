package br.com.pat.mvc.repositories;

import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Produto;

@Repository
public class ProdutoRepositoyHibernate extends RepositoryBase implements
		ProdutoRepository {

	@Override
	public Produto getProduto() {
		return getHibernateTemplate().get(Produto.class, null);
	}

	@Override
	public Produto salva(Produto produto) {
		return (Produto) getHibernateTemplate().save(produto);

	}

}
