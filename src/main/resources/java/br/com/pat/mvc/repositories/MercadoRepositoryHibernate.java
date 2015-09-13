package br.com.pat.mvc.repositories;

import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Mercado;

@Repository
public class MercadoRepositoryHibernate extends RepositoryBase implements MercadoRepository {

	@Override
	public Mercado getMercado() {
		return this.hibernateTemplate.get(Mercado.class, null);
	}

	@Override
	public Mercado salva(Mercado mercado) {
		return (Mercado) hibernateTemplate.save(mercado);

	}

}