package controllers;

import play.mvc.Controller;

//http://bootsnipp.com/tags/user-interface
import play.mvc.Result;

//
public class Application extends Controller {

    public static Result index() {
    	return ok(views.html.index.render());
    }
}
