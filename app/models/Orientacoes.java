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
	
	@Required(message="É necessário informar a descrição")
	@Column(length=80)
	public String descricao;
	
	@Required(message="É necessário informar uma observação")
	// valdiar quantidade minima de caractres
	@Column(length=1000)
	public String observacao;

}
