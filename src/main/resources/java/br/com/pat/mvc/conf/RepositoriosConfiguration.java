package br.com.pat.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pat.mvc.repositories.ClienteRepository;
import br.com.pat.mvc.repositories.ClienteRepositoryHibernate;
import br.com.pat.mvc.repositories.CompraRepository;
import br.com.pat.mvc.repositories.CompraRepositoryHibernate;
import br.com.pat.mvc.repositories.FuncionarioRepository;
import br.com.pat.mvc.repositories.FuncionarioRepositoryHibernate;
import br.com.pat.mvc.repositories.OrdemDeServicoRepository;
import br.com.pat.mvc.repositories.OrdemDeServicoRepositoryHibernate;
import br.com.pat.mvc.repositories.ProdutoRepository;
import br.com.pat.mvc.repositories.ProdutoRepositoyHibernate;
import br.com.pat.mvc.repositories.ServicoRepository;
import br.com.pat.mvc.repositories.ServicoRepositoryHibernate;
import br.com.pat.mvc.repositories.UsuarioRepository;
import br.com.pat.mvc.repositories.UsuarioRepositoryHibernate;

@Configuration
public class RepositoriosConfiguration {

	@Bean(name = "usuarioRepository")
	public UsuarioRepository getUsuarioRepository() {
		return new UsuarioRepositoryHibernate();
	}

	@Bean(name = "compraRepository")
	public CompraRepository getCompraRepository() {
		return new CompraRepositoryHibernate();
	}

	@Bean(name = "produtoRepository")
	public ProdutoRepository getProdutoRepository() {
		return new ProdutoRepositoyHibernate();
	}

	@Bean(name = "servicoRepository")
	public ServicoRepository getServicoRepository() {
		return new ServicoRepositoryHibernate();
	}

	@Bean(name = "funcionarioRepository")
	public FuncionarioRepository getFuncionarioRepository() {
		return new FuncionarioRepositoryHibernate();
	}

	@Bean(name = "clienteRepository")
	public ClienteRepository getClienteRepository() {
		return new ClienteRepositoryHibernate();
	}

	@Bean(name = "ordemDeServicoRepository")
	public OrdemDeServicoRepository getOrdemDeServicoRepository() {
		return new OrdemDeServicoRepositoryHibernate();
	}

}
