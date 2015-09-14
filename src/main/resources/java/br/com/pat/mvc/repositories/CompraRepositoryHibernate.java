package br.com.pat.mvc.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Compra;

@Repository
public class CompraRepositoryHibernate extends RepositoryBase implements
		CompraRepository {

	@Override
	public Compra getCompra() {
		return getHibernateTemplate().get(Compra.class, null);
	}

	@Override
	@Transactional
	public void salva(Compra compra) {
		getHibernateTemplate().save(compra);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> getDataCompra(Compra compra) {
		Session sessao = getSession();
		Criteria criteria = sessao.createCriteria(Compra.class);
		criteria.add(Restrictions.eq("data_compra", compra.getDataCompra()));

		List<Compra> dataCompras = criteria.list();
		sessao.close();

		return dataCompras;

	}
}
