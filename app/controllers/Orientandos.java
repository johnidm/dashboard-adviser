package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Orientandos extends Controller {
	
	
	public static Result cadastrar() {				
		return ok(views.html.orientandos.render());
	}

}
