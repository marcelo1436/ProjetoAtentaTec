package br.com.pat.mvc.repositories;

import java.util.List;

import br.com.pat.mvc.model.Compra;

public interface CompraRepository {

	public Compra getCompra();

	public void salva(Compra compra);

	public List<Compra> getCompras();

}
