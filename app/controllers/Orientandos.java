package controllers;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Orientandos extends Controller {

    private static final Form<models.Orientandos> formulario = Form.form(models.Orientandos.class);

	public static Result index() {
		
        List<models.Orientandos> orientandos = models.Orientandos.pesquisa.where()
                .orderBy("nome").findList();

        return ok(views.html.app.orientandos.render(formulario, orientandos));
	}

    public static Result excluir(Long id) {

        models.Orientandos.pesquisa.ref(id).delete();

        return redirect(routes.Orientandos.index() );
    }

    public static Result salvar() {
        Form<models.Orientandos> form = formulario.bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(views.html.app.orientandos.render(formulario, null));
        }

        form.get().save();

        return redirect(routes.Orientandos.index() );
    }

}
