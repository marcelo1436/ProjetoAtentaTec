package br.com.pat.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.model.Mercado;
import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.repositories.CompraRepository;
import br.com.pat.mvc.repositories.MercadoRepository;
import br.com.pat.mvc.repositories.ProdutoRepository;
import br.com.pat.mvc.util.UtilMensagens;

@Service
public class ProdutoService {

	@Resource(name = "produtoRepository")
	public ProdutoRepository produtoRepository;

	@Resource(name = "mercadoRepository")
	public MercadoRepository mercadoRepository;

	@Resource(name = "compraRepository")
	public CompraRepository compraRepository;

	public boolean salva(Compra compra) {
		Produto produto = compra.getProduto();
		Mercado mercado = compra.getMercado();
		if (validaProduto(produto)) {
			Integer idProduto = produtoRepository.salva(produto);
			produto = produtoRepository.getProduto(idProduto);
		} else {
			return false;
		}

		if (validaMercado(mercado)) {
			Integer idMercado = mercadoRepository.salva(mercado);
			mercado = mercadoRepository.getMercado(idMercado);
		} else {
			return false;
		}

		compra.setProduto(produto);
		compra.setMercado(mercado);

		if (validaCompra(compra)) {
			compraRepository.salva(compra);
			return true;
		} else {
			return false;
		}
	}

	public List<Produto> getProdutos(Produto produto) {
		return produtoRepository.getProdutos(produto);
	}

	private boolean validaProduto(Produto produto) {
		boolean valido = true;

		if (produto == null) {
			UtilMensagens.setMsgError("Produto é Obrigatório");
			valido = false;
			return valido;
		}

		if (produto.getNomeProduto() == "") {
			UtilMensagens.setMsgError("Nome do produto é Obrigatorio");
			valido = false;
		}
		if (produto.getMarcaProduto() == "") {
			UtilMensagens.setMsgError("Marca do produto é Obrigatorio");
			valido = false;
		}
		if (produto.getTipoProduto() == "") {
			UtilMensagens.setMsgError("Tipo do produto é Obrigatorio");
			valido = false;
		}
		if (produto.getValorProduto() == null) {
			UtilMensagens.setMsgError("Valor do produto é Obrigatorio");
			valido = false;
		}
		if (produto.getQuantidadeProduto() == null) {
			UtilMensagens.setMsgError("Quantidade do produto é Obrigatorio");
			valido = false;
		}

		return valido;

	}

	private boolean validaCompra(Compra compra) {
		boolean valido = true;

		if (compra == null) {
			UtilMensagens.setMsgError("Compra inválida");
			valido = false;
			return valido;
		}
		// TODO validar o resto
		if (compra.getDataCompra() == null) {
			UtilMensagens.setMsgError("Data da compra é obrigatório");
			valido = false;
		}
		return valido;
	}

	private boolean validaMercado(Mercado mercado) {
		boolean valido = true;

		if (mercado == null) {
			UtilMensagens.setMsgError("Mercado é Obrigatório");
			valido = false;
			return valido;
		}

		if (mercado.getNomeMercado() == "") {
			UtilMensagens.setMsgError("Nome do mercado é Obrigatorio");
			valido = false;
		}
		return valido;
	}
}
