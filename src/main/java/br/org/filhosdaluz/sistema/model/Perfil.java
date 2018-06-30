package br.org.filhosdaluz.sistema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "PER_PERFIL")
public class Perfil implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4187201805156095411L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PER_ID")
	private Long id;
    
    @Column(name = "PER_NOME", unique=true, length = 20, nullable = false)
    private String nome;
    
    @ManyToMany
    @JoinTable(name = "PEA_PERFIL_AUTORIZACAO", 
    	joinColumns = { @JoinColumn(name = "PER_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "AUT_ID") })
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the autorizacoes
	 */
	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
	
}
