package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Orientacoes extends Controller {
	
	public static Result cadastrar() {
		
		return ok(views.html.app.orientacoes.render());
		
	}

}
