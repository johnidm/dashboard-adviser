package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;


@Entity
public class Orientacoes extends Model {
	
	public static Model.Finder<Long, Orientacoes> pesquisa = 
			new Model.Finder<Long, Orientacoes>(Long.class, Orientacoes.class);	
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	@Column(length=30)
	public String descricao;
	
	@Column(length=1000)
	public String observacao;

}
