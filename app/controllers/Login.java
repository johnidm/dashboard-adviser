package controllers;

import play.mvc.Controller;
import play.mvc.Result;


public class Login extends Controller {

	public static Result acessar() {		
		return ok(views.html.login.acessar.render());		
	}
	
	public static Result registrar() {
	
		return ok(views.html.login.registrar.render());	
	}
	
	public static Result acessarUsuario() {
				
		return redirect(routes.Application.index());	
	}
	
	public static Result registrarUsuario() {
		
		return ok(views.html.login.confirmaregistro.render());	
	}
	
	public static Result sair() {	
		
		return acessar();				
	}
	
	public static Result perfil() {
		
		return ok(views.html.login.perfil.render());	
		
	}
	
}
