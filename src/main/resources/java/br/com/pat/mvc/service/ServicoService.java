package br.com.pat.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.exeptions.MensagemDeErroExeption;
import br.com.pat.mvc.model.Servico;
import br.com.pat.mvc.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Resource(name = "servicoRepository")
	public ServicoRepository servicoRepository;

	public void salva(Servico servico) {
		validaServico(servico);
		servicoRepository.salva(servico);
	}

	private void validaServico(Servico servico) {
		if (servico.getNome() == null) {
			throw new MensagemDeErroExeption("Nome é Ogrigatório");
		}
	}

	public void atualiza(Servico servico) {
		validaServico(servico);
		servicoRepository.atualiza(servico);
	}

	public List<Servico> getServicos() {
		return servicoRepository.getServicos();
	}

	public void delete(Servico servico) {
		servicoRepository.exclui(servico);
	}

}
