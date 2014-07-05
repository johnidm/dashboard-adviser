package controllers;

import play.mvc.Controller;

//http://bootsnipp.com/tags/user-interface
import play.mvc.Result;
import play.mvc.Security;

//
public class Application extends Controller {

	//@Security.Authenticated(Seguranca.class)	
    public static Result index() {
    	return ok(views.html.index.render());
    }
}
