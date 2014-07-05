package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import com.avaje.ebean.Ebean;

public class Orientacoes extends Controller {

    private static final Form<models.Orientacoes> formulario = Form.form(models.Orientacoes.class);
    
    public static List<models.Orientacoes> listaOrientacoes() {
    	 return models.Orientacoes.pesquisa.where().orderBy("descricao").findList();
    }
	
	public static Result index() {			
		return ok(views.html.app.orientacoes.render(formulario, listaOrientacoes()));		
	}

    public static Result excluir(Long id) {

        models.Orientacoes.pesquisa.ref(id).delete();

        flash("excluiu","Orientação excluída com sucesso.");
        
        return redirect(routes.Orientacoes.index());
    }

    public static Result salvar() {
           	    	
    	Form<models.Orientacoes> form = formulario.bindFromRequest();
   	    	
        if (form.hasErrors()) {        
        	return badRequest(views.html.app.orientacoes.render(form, listaOrientacoes()));
        }
                       
        form.get().save();
        
        flash("gravou","Orientação gravada com sucesso.");
        
        return redirect(routes.Orientacoes.index());
    }

}
