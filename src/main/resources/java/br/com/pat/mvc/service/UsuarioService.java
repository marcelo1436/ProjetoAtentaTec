package br.com.pat.mvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.infra.Autenticador;
import br.com.pat.mvc.model.Usuario;
import br.com.pat.mvc.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Resource(name = "usuarioRepository")
	public UsuarioRepository usuarioRepository;
	
	public Usuario autenticaUsuario(Usuario usuario) {
		Usuario usuarioAutenticado = usuarioRepository.getUsuarioPeloLoginESenha(usuario);
		if (usuarioAutenticado == null) {
			return usuario;
		} else {
			Autenticador.autenticaUsuarioNaSessao(usuarioAutenticado);
			return usuarioAutenticado;
		}
	}

	public void logout() {
		Autenticador.removeUsuarioNaSessao();
	}
}
