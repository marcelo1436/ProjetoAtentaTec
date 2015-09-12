package br.com.pat.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.exeptions.MensagemDeErroExeption;
import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Resource(name = "produtoRepository")
	public ProdutoRepository produtoRepository;

	public void salva(Produto produto) {
		validaProduto(produto);

		produtoRepository.salva(produto);
	}

	public Produto getProduto() {
		return produtoRepository.getProduto();
	}

	private void validaProduto(Produto produto) {
		if (produto.getNomeProduto() == null) {
			throw new MensagemDeErroExeption("Nome é Obrigatório");
		}

	}
}
