package br.com.pat.mvc.util;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfUtil {
	public static void addErrorMessageExcecao(Exception ex, String defaultMsg) {
		String msg = ex.getLocalizedMessage();

		if ((msg != null) && (msg.length() > 0)) {
			addErrorMessage(null, msg);
		} else {
			addErrorMessage(null, defaultMsg);
		}
	}

	public static void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(null, message);
		}
	}

	public static void addErrorMessage(String idComponente, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext.getCurrentInstance().addMessage(idComponente, facesMsg);
	}

	public static void addSuccessMessage(String idComponente, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext.getCurrentInstance().addMessage("idComponente", facesMsg);
	}

	public static String getRequestParameter(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
	}

	public static void setAttribute(String valorObjeto, Object tipoObjeto) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(valorObjeto, tipoObjeto);
	}

	public static Object getAttribute(String valorObjeto) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(valorObjeto);
	}
}
