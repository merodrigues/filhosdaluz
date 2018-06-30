package br.org.filhosdaluz.sistema.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.org.filhosdaluz.sistema.model.Autorizacao;
import br.org.filhosdaluz.sistema.model.Perfil;
import br.org.filhosdaluz.sistema.service.AutorizacaoService;
import br.org.filhosdaluz.sistema.service.PerfilService;
import br.org.filhosdaluz.sistema.web.WebUtils;

@ManagedBean(name="perfilController")
@SessionScoped
public class PerfilController {
	
	private Boolean editar = false;
	private Perfil pesquisa;
	private Perfil edicao;
	private Long autorizacao;
	private Collection<Perfil> resultado;
	
	@ManagedProperty(value="#{perfilService}")
	private PerfilService perfilService;

	@ManagedProperty(value="#{autorizacaoService}")
	private AutorizacaoService autorizacaoService;
	
	/**
	 * @param perfilService the perfilService to set
	 */
	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}
	
	/**
	 * @param autorizacaoService the autorizacaoService to set
	 */
	public void setAutorizacaoService(AutorizacaoService autorizacaoService) {
		this.autorizacaoService = autorizacaoService;
	}
	
	public void inicializar() {
		if(getPesquisa() == null) {
			setPesquisa(new Perfil());
			getPesquisa().setNome("");
			setEdicao(new Perfil());
			setResultado(new ArrayList<Perfil>());
			setEditar(false);
		}
	}
	
	public void novo() {
		setEdicao(new Perfil());
		setEditar(true);
	}
	
	public void pesquisar() {
		setResultado(perfilService.pesquisarPorNome(getPesquisa().getNome()));
	}
	
	public void cancelar() {
		setEditar(false);
	}
	
	public void salvar() {
		try{
			perfilService.salvar(getEdicao());
			pesquisar();
			setEditar(false);
			WebUtils.incluirMensagemInfo("Perfil gravado com sucesso!");
		}
		catch(Throwable t) {
			WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
		}
	}
	
	public void remover(Long id) {
		perfilService.excluir(id);
		pesquisar();
	}
	
	public void editar(Long id) {
		setEdicao(perfilService.pesquisarPorId(id));
		setEditar(true);
	}
	
	public void incluirAutorizacao() {
		if(autorizacao == null) {
			WebUtils.incluirMensagemErro("É necessário informar uma autorização!");
		}
		else {
			getEdicao().getAutorizacoes().add(autorizacaoService.pesquisarPorId(autorizacao));
			setAutorizacao(null);
		}
	}
	
	public void removerAutorizacao(Autorizacao autorizacao) {
		getEdicao().getAutorizacoes().remove(autorizacao);
	}

	/**
	 * @return the editar
	 */
	public Boolean getEditar() {
		return editar;
	}

	/**
	 * @param editar the editar to set
	 */
	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	/**
	 * @return the pesquisa
	 */
	public Perfil getPesquisa() {
		return pesquisa;
	}

	/**
	 * @param pesquisa the pesquisa to set
	 */
	public void setPesquisa(Perfil pesquisa) {
		this.pesquisa = pesquisa;
	}

	/**
	 * @return the edicao
	 */
	public Perfil getEdicao() {
		return edicao;
	}

	/**
	 * @param edicao the edicao to set
	 */
	public void setEdicao(Perfil edicao) {
		this.edicao = edicao;
	}

	/**
	 * @return the autorizacao
	 */
	public Long getAutorizacao() {
		return autorizacao;
	}

	/**
	 * @param autorizacao the autorizacao to set
	 */
	public void setAutorizacao(Long autorizacao) {
		this.autorizacao = autorizacao;
	}
	
	/**
	 * @return the resultado
	 */
	public Collection<Perfil> getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Collection<Perfil> resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * Lista todos as autorizacoes cadastradas
	 * @return List<Autorizacao>
	 */
	public List<Autorizacao> getAutorizacoes() {
		return autorizacaoService.todos();
	}
	
}
