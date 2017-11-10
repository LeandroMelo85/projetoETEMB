package br.com.etemb.projeto.meusclientes;

/**
 *
 * @author Leandro Melo
 */

public class Clientes {
	
	private int id;
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	
	
	public Clientes(int id, String nome, String telefone, String celular, String email) {
		this.setId(id);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCelular(celular);
		this.setEmail(email);
	}
	
	public Clientes() {
		
	}
	
	public Clientes(String nome, String telefone, String celular, String email) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCelular(celular);
		this.setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}