package br.com.pat.mvc.filtro;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

import br.com.pat.mvc.conf.SpringContext;

public class OpenSessionInViewFilterHibernate4 extends OpenSessionInViewFilter {

	@Override
	protected SessionFactory lookupSessionFactory() {
		return SpringContext.getTemplate().getSessionFactory();
	}
}
