package br.com.pat.mvc.exeptions;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import br.com.pat.mvc.util.JsfUtil;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	final FacesContext facesContext = FacesContext.getCurrentInstance();

	final Map requestMap = facesContext.getExternalContext().getRequestMap();

	final NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();

	CustomExceptionHandler(ExceptionHandler exception) {
		this.wrapped = exception;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void handle() throws FacesException {

		final Iterator iterator = getUnhandledExceptionQueuedEvents().iterator();
		
		while (iterator.hasNext()) {
			ExceptionQueuedEvent event = (ExceptionQueuedEvent) iterator.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			Throwable exception = context.getException();

			try {
//				 exception.printStackTrace();

				// Coloca uma mensagem de exceção no mapa da request
				requestMap.put("exceptionMessage", exception.getMessage());

				// Tranquiliza o usuário para que ele continue usando o sistema
				JsfUtil.addErrorMessage("O sistema se recuperou de um erro inesperado");

				// Seta a navegação para uma página padrão.
//				navigationHandler.handleNavigation(facesContext, null,"/restrict/home.faces");

				// Renderiza a pagina de erro e exibe as mensagens
				facesContext.renderResponse();
			} finally {
				iterator.remove();
			}
		}
		getWrapped().handle();
	}
}
