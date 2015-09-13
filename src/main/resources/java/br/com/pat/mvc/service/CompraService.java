package br.com.pat.mvc.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.repositories.CompraRepository;
import br.com.pat.mvc.repositories.ProdutoRepository;
import br.com.pat.mvc.util.UtilMensagens;

@Service
public class CompraService {

	@Resource(name = "compraRepository")
	public CompraRepository compraRepository;

	@Autowired
	public ProdutoRepository produtoRepository;

	public Compra salva(Compra compra) {
		validaCompra(compra);
		compra.setDataCompra(new Date());
		compra.setProduto(produtoRepository.getProduto());
		return compraRepository.salva(compra);
	}

	public Compra getCompra() {
		return compraRepository.getCompra();
	}

	private void validaCompra(Compra compra) {
		if (compra.getDataCompra() == null) {
			UtilMensagens.setMsgError("Data da Compra é Obrigatorio");
		}

	}
}
