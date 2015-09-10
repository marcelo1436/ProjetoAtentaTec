package br.com.cs.mvc.repositories;

import java.util.List;

import br.com.cs.mvc.model.FiltroOrdemDeServico;
import br.com.cs.mvc.model.OrdemDeServico;

public interface OrdemDeServicoRepository extends Repositorio {

	public List<OrdemDeServico> getOrdensDeServico();

	public void salva(OrdemDeServico os);

	public void atualiza(OrdemDeServico os);

	public void exclui(OrdemDeServico os);

	public OrdemDeServico get(int os);

	public List<OrdemDeServico> getOrdensDeServicoPorFiltro(FiltroOrdemDeServico filtro);
}
