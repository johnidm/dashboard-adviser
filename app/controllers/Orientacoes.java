package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Orientacoes extends Controller {

    private static final Form<models.Orientacoes> formulario = Form.form(models.Orientacoes.class);
	
	public static Result index() {
        List<models.Orientacoes> orientacoes = models.Orientacoes.pesquisa.where()
                .orderBy("descricao").findList();

		return ok(views.html.app.orientacoes.render(formulario, orientacoes));
		
	}

    public static Result excluir(Long id) {

        models.Orientacoes.pesquisa.ref(id).delete();

        return redirect(routes.Orientacoes.index());
    }

    public static Result salvar() {
        Form<models.Orientacoes> form = formulario.bindFromRequest();

        if (form.hasErrors()) {
            return badRequest(views.html.app.orientacoes.render(formulario, null));
        }

        return redirect(routes.Orientacoes.index());
    }

}
