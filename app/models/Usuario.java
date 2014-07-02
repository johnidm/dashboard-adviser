package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model  {
	
	public static Model.Finder<Long, Usuario> find = new Model.Finder<Long, Usuario>(Long.class,  Usuario.class); 
	
	@Id
	@GeneratedValue	
	public Long id;
	
	public String nome;
	
	public String email;
	
	public String senha;
	
}
