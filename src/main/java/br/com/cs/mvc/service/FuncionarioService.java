package br.com.cs.mvc.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.cs.mvc.exeptions.MensagemDeErroExeption;
import br.com.cs.mvc.model.Funcionario;
import br.com.cs.mvc.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Resource(name = "funcionarioRepository")
	public FuncionarioRepository funcionarioRepository;

	public void salva(Funcionario funcionario) {
		validaFuncionario(funcionario);
		funcionario.setDataDeCadastro(new Date());
		funcionario.setDataDeAlteracao(new Date());
		funcionarioRepository.salva(funcionario);
	}

	private void validaFuncionario(Funcionario funcionario) {
		if (funcionario.getNome() == null) {
			throw new MensagemDeErroExeption("Nome é Obrigatório");
		}
		if (funcionario.getCpf() == null) {
			throw new MensagemDeErroExeption("CPF é Obrigatório");
		}
	}

	public void atualiza(Funcionario funcionario) {
		validaFuncionario(funcionario);
		funcionario.setDataDeAlteracao(new Date());
		funcionarioRepository.atualiza(funcionario);
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarioRepository.getFuncionarios();
	}

	public void delete(Funcionario funcionario) {
		funcionarioRepository.exclui(funcionario);
	}

}
