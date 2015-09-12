package br.com.pat.mvc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pat.mvc.exeptions.MensagemDeErroExeption;
import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.repositories.CompraRepository;
import br.com.pat.mvc.repositories.ProdutoRepository;

@Service
public class CompraService {

	@Resource(name = "compraRepository")
	public CompraRepository compraRepository;

	@Autowired
	public ProdutoRepository produtoRepository;

	public void salva(Compra compra) {
		validaCompra(compra);
		compra.setDataCompra(new Date());
		compra.setProduto(produtoRepository.getProduto());
		compraRepository.salva(compra);
	}

	public List<Compra> getCompras() {
		return compraRepository.getCompras();
	}

	private void validaCompra(Compra compra) {
		if (compra.getDataCompra() == null) {
			throw new MensagemDeErroExeption("Nome é Obrigatório");
		}

	}
}
