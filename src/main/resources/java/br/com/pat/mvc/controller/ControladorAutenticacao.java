package br.com.pat.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.pat.mvc.infra.Autenticador;
import br.com.pat.mvc.model.Usuario;
import br.com.pat.mvc.service.UsuarioService;
import br.com.pat.mvc.util.UtilMensagens;

@Controller
@Scope("session")
public class ControladorAutenticacao {

	private Usuario usuario;

	@Autowired
	private UsuarioService usuarioService;

	public ControladorAutenticacao() {
		usuario = new Usuario();
	}

	public String logar() {
		usuario = usuarioService.autenticaUsuario(usuario);
		if (usuario.getId() == null) {
			UtilMensagens.setMsgInfo("Usuário ou senha inválido");
			usuario = new Usuario();
			return "login.xhtml";
		} else {
			return "cadastroProduto.xhtml";
		}
	}

	public String logout() {
		Autenticador.removeUsuarioNaSessao();
		return "login.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
