package br.com.pat.mvc.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Produto;

@Repository
public class ProdutoRepositoyHibernate extends RepositoryBase implements
		ProdutoRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getProdutos(Produto produto) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(Produto.class);
		List<Produto> produtos = criteria.list();
		sessao.close();
		return produtos;
	}

	@Override
	@Transactional
	public Integer salva(Produto produto) {
		Integer id = (Integer) getHibernateTemplate().save(produto);
		return id;
	}
	
	@Override
	@Transactional
	public void alterar(Produto produto) {
		getHibernateTemplate().update(produto);
	}

	@Override
	public Produto getProduto(Integer id) {
		return (Produto) getHibernateTemplate().get(Produto.class, id);
	}

}
