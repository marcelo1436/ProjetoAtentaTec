package br.com.pat.mvc.repositories;

import br.com.pat.mvc.model.Usuario;

public interface UsuarioRepository extends Repositorio {

	public Usuario getUsuarioPeloLoginESenha(Usuario usuario);
}
