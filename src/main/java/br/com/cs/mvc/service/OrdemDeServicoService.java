package br.com.cs.mvc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.cs.mvc.model.FiltroOrdemDeServico;
import br.com.cs.mvc.model.OrdemDeServico;
import br.com.cs.mvc.repositories.OrdemDeServicoRepository;

@Service
public class OrdemDeServicoService {

	@Resource(name = "ordemDeServicoRepository")
	public OrdemDeServicoRepository osRepository;

	public void salva(OrdemDeServico os) {
		os.setDataDeCadastro(new Date());
		os.setDataDeAlteracao(new Date());
		osRepository.salva(os);
	}

	public void atualiza(OrdemDeServico os) {
		os.setDataDeAlteracao(new Date());
		osRepository.atualiza(os);
	}

	public List<OrdemDeServico> getOrdensDeServico() {
		return osRepository.getOrdensDeServico();
	}

	public void delete(OrdemDeServico os) {
		osRepository.exclui(os);
	}

	public List<OrdemDeServico> getOrdensDeServicoPorFiltro(FiltroOrdemDeServico filtro) {
		return osRepository.getOrdensDeServicoPorFiltro(filtro);
	}

}
