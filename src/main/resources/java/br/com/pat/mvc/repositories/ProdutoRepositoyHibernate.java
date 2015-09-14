package br.com.pat.mvc.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Produto;

@Repository
public class ProdutoRepositoyHibernate extends RepositoryBase implements ProdutoRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getProdutos(Produto produto) {

		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(Produto.class);
		criteria.add(Restrictions.eq("nome_produto", produto.getNomeProduto()));
		criteria.add(Restrictions.eq("tipo_produto", produto.getTipoProduto()));
		criteria.add(Restrictions.eq("marca_produto", produto.getMarcaProduto()));
		criteria.add(Restrictions.eq("valor_produto", produto.getValorProduto()));
		criteria.add(Restrictions.eq("quantidade_produto", produto.getQuantidadeProduto()));
		criteria.add(Restrictions.eq("dataValidade_produto", produto.getDataValidadeProduto()));

		List<Produto> produtos = criteria.list();
		sessao.close();
		return produtos;

	}

	@Override
	public void salva(Produto produto) {
		getHibernateTemplate().save(produto);

	}

}
