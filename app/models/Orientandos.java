package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

public class Orientandos extends Model  {
	
	public static Model.Finder<Long, Orientandos> pesquisa = 
			new Model.Finder<Long, Orientandos>(Long.class, Orientandos.class);
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	@Column(length=60)
	public String nome;
		
}
