package br.org.filhosdaluz.sistema.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USR_USUARIO")
public class Usuario implements UserDetails{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7275092339436075624L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USR_ID")
	private Long id;
    
    @Column(name = "USR_NOME", unique=true, length = 20, nullable = false)
    private String nome;
    
    @Column(name = "USR_SENHA", length = 50, nullable = false)
    private String senha;

    @ManyToMany
    @JoinTable(name = "USP_USUARIO_PERFIL", 
    	joinColumns = { @JoinColumn(name = "USR_ID") }, 
    	inverseJoinColumns = { @JoinColumn(name = "PER_ID") })
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Perfil> perfis = new ArrayList<Perfil>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
		if(perfis != null) {
			for(Perfil perfil: perfis) {
				autorizacoes.addAll(perfil.getAutorizacoes());
			}
		}
		return autorizacoes;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
        
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
}
