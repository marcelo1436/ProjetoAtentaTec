package br.com.pat.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.pat.mvc.exeptions.ExcecaoInfraestrutura;
import br.com.pat.mvc.exeptions.ExcecaoUsuarioNaoAutenticado;
import br.com.pat.mvc.exeptions.MensagemDeErroExeption;
import br.com.pat.mvc.util.JsfUtil;

public class ControladorBase {

	@Autowired
	protected HttpServletRequest request;

	@ExceptionHandler(value = { ExcecaoUsuarioNaoAutenticado.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody void capturaExcecaoUsuarioNaoAutenticado(ExcecaoUsuarioNaoAutenticado ex, HttpServletRequest request) {
		ex.printStackTrace();
		JsfUtil.addErrorMessageExcecao(ex, ex.getMessage());
	}

	@ExceptionHandler(value = { ExcecaoInfraestrutura.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody void capturaExcecaoInfraestrutura(ExcecaoInfraestrutura ex, HttpServletRequest request) {
		ex.printStackTrace();
		JsfUtil.addErrorMessageExcecao(ex, ex.getMessage());
	}

	@ExceptionHandler(value = { MensagemDeErroExeption.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody void capturaExcecao(MensagemDeErroExeption ex, HttpServletRequest request) {
		ex.printStackTrace();
		JsfUtil.addErrorMessageExcecao(ex, ex.getMessage());
	}
	
	@ExceptionHandler(value = { RuntimeException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody void capturaExcecaoRunTime(RuntimeException ex, HttpServletRequest request) {
		ex.printStackTrace();
		JsfUtil.addErrorMessageExcecao(ex, ex.getMessage());
	}
	
	protected String getBaseUri() {
		return String.format("%s://%s:%d%s", request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath());
	}

}
