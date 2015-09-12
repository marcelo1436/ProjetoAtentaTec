package br.com.pat.mvc.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Compra;

@Repository
public class CompraRepositoryHibernate extends RepositoryBase implements CompraRepository {

	@Override
	public List<Compra> getCompras() {
		return this.hibernateTemplate.loadAll(Compra.class);
	}

	@Override
	public void salva(Compra compra) {
		this.hibernateTemplate.save(compra);
	}

}
