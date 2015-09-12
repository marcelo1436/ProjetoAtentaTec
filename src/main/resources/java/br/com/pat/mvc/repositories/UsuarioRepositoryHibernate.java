package br.com.pat.mvc.repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Usuario;

@Repository
public class UsuarioRepositoryHibernate extends RepositoryBase implements UsuarioRepository {

	@Override
	public Usuario getUsuarioPeloLoginESenha(Usuario usuario) {
		Session sessao = getSession();

		Criteria criteria = sessao.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", usuario.getLogin()));
		criteria.add(Restrictions.eq("senha", usuario.getSenha()));

		Usuario usuarioAutenticado = (Usuario) criteria.uniqueResult();
		sessao.close();

		return usuarioAutenticado;
	}
}
