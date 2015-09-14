package br.com.pat.mvc.repositories;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Mercado;

@Repository
public class MercadoRepositoryHibernate extends RepositoryBase implements
		MercadoRepository {

	@Override
	public Mercado getMercado(Integer id) {
		return getHibernateTemplate().get(Mercado.class, id);
	}

	@Override
	@Transactional
	public Integer salva(Mercado mercado) {
		return (Integer) getHibernateTemplate().save(mercado);
	}

}
