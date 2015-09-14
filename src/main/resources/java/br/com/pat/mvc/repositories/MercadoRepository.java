package br.com.pat.mvc.repositories;

import br.com.pat.mvc.model.Mercado;

public interface MercadoRepository {

	public Mercado getMercado(Integer id);

	public Integer salva(Mercado mercado);

}
