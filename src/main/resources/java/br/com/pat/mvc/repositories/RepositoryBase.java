package br.com.pat.mvc.repositories;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class RepositoryBase {

	protected Session getSession() {
		return hibernateTemplate.getSessionFactory().openSession();
	}

	protected HibernateTemplate getHibernateTemplate() {
		hibernateTemplate.getSessionFactory().getCurrentSession()
				.setFlushMode(FlushMode.AUTO);
		return hibernateTemplate;
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;

}
