package controllers;


import models.Usuario;
import play.data.DynamicForm;
import play.data.DynamicForm.Dynamic;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;

public class Login extends Controller {

	private static DynamicForm formLogin = Form.form();
	
	private static Form<Usuario> formRegistro = Form.form(Usuario.class);

	public static Result acessar() {
		return ok(views.html.login.acessar.render(formLogin));
	}

	public static Result registrar() {

		return ok(views.html.login.registrar.render());
	}

	public static Result acessarUsuario() {

		Form<Dynamic> request = formLogin.bindFromRequest();
	
		
		String password = request.data().get("senha");
		String email = request.data().get("email");
		
		User user = new User();

		if (!user.check(email, password)) {
			DynamicForm errorForm = formLogin.fill(request.data());
			errorForm.reject("O usuario ou senha informados nao existem!");
			
			return forbidden(views.html.login.acessar.render(errorForm));
		}
		
		session().clear();
        session("email", email);
        
		return redirect(routes.Application.index());
	}

	public static Result registrarUsuario() {
		
		Form<Usuario> formInsert = formRegistro.bindFromRequest();

		Usuario usuario = formInsert.get();		
		
		Ebean.save(usuario);			

		return ok(views.html.login.confirmaregistro.render());
	}

	public static Result sair() {
		session().clear();			
		return acessar();
	}

	public static Result perfil() {
		
		String email = session().get("email");
				
		Usuario usuario = Ebean.find(Usuario.class).where().eq("email", email).findUnique();
		
		return ok(views.html.login.perfil.render(usuario));

	}

}

class User {

	public Boolean check(String email, String password) {
		
		System.out.println(password);
		
		SqlRow row = Ebean
				.createSqlQuery(
						"select id from usuario where email = :email and senha = :senha")
				.setParameter("email", email).setParameter("senha", password)
				.findUnique();
		
		return  row != null;	
	}
}
