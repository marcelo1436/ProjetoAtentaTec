package br.com.pat.mvc.infra;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pat.mvc.model.Usuario;

@Component
public class Autenticador {

	@Autowired
	protected static HttpServletRequest request;

	private static final String USUARIO_LOGADO = "UsuarioLogado";

	public static void autenticaUsuarioNaSessao(Usuario usuario) {
		request.getSession().setAttribute(USUARIO_LOGADO, usuario);
	}

	public static Usuario getUsuarioNaSessao() {
		return (Usuario) request.getSession().getAttribute(USUARIO_LOGADO);
	}

	public static void removeUsuarioNaSessao() {
		request.getSession().removeAttribute(USUARIO_LOGADO);
	}

}
