package br.com.pat.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.model.Mercado;
import br.com.pat.mvc.repositories.MercadoRepository;
import br.com.pat.mvc.util.UtilMensagens;

@Service
public class MercadoService {

	@Resource(name = "mercadoRepository")
	public MercadoRepository mercadoRepository;;

	public Mercado salva(Mercado mercado) {
		validaMercado(mercado);
		return mercadoRepository.salva(mercado);
	}

	public Mercado getCompra() {
		return mercadoRepository.getMercado();
	}

	private void validaMercado(Mercado mercado) {
		if (mercado.getNomeMercado() == "") {
			UtilMensagens.setMsgError("Nome do Mercado é Obrigatorio");
		}

	}

}
