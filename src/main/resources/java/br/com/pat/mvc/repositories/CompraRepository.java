package br.com.pat.mvc.repositories;

import br.com.pat.mvc.model.Compra;

public interface CompraRepository {
	
	public Compra getCompra();

	public Compra salva(Compra compra);

}
