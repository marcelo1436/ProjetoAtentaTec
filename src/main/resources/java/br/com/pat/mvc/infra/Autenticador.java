package br.com.pat.mvc.infra;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import br.com.pat.mvc.model.Usuario;

@Component
public class Autenticador {

	private static final String USUARIO_LOGADO = "UsuarioLogado";

	public static void autenticaUsuarioNaSessao(Usuario usuario) {
		FacesContext fc = FacesContext.getCurrentInstance();  
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
		session.setAttribute(USUARIO_LOGADO, usuario);
	}

	public static Usuario getUsuarioNaSessao() {
		FacesContext fc = FacesContext.getCurrentInstance();  
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
		return (Usuario) session.getAttribute(USUARIO_LOGADO);
	}

	public static void removeUsuarioNaSessao() {
		FacesContext fc = FacesContext.getCurrentInstance();  
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
		session.removeAttribute(USUARIO_LOGADO);
	}

}
