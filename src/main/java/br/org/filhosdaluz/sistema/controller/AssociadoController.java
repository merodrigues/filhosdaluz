package br.org.filhosdaluz.sistema.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.org.filhosdaluz.sistema.model.Associado;
import br.org.filhosdaluz.sistema.service.AssociadoService;

import br.org.filhosdaluz.sistema.web.WebUtils;

@ManagedBean(name="associadoController")
@SessionScoped
public class AssociadoController {
	
	
	private Boolean editar = false;
	private Associado pesquisa;
	private Associado edicao;
	private Collection<Associado> resultado;
	
	@ManagedProperty(value="#{associadoService}")
	private AssociadoService associadoService;

	
	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setAssociadoService(AssociadoService associadoService) {
		this.associadoService = associadoService;
	}
	
	
	
	public void inicializar() {
		if(getPesquisa() == null) {
			setPesquisa(new Associado());
			getPesquisa().setNome("");
			setEdicao(new Associado());
			setResultado(new ArrayList<Associado>());
			setEditar(false);
			
		}
	}
	
	public void novo() {
		setEdicao(new Associado());
		setEditar(true);
		
	}
	
	public void pesquisar() {
		setResultado(associadoService.pesquisarPorNome(getPesquisa().getNome()));
	}
	
	public void cancelar() {
		setEditar(false);
	}
	
	public void salvar() {
		try{
			
			associadoService.salvar(getEdicao());
			pesquisar();
			setEditar(false);
			WebUtils.incluirMensagemInfo("Usuário gravado com sucesso!");
		}
		catch(Throwable t) {
			WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
		}
	}
	
	public void remover(Long id) {
		associadoService.excluir(id);
		pesquisar();
	}
	
	public void editar(Long id) {
		setEdicao(associadoService.pesquisarPorId(id));
		setEditar(true);
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
	public Associado getPesquisa() {
		return pesquisa;
	}

	/**
	 * @param pesquisa the pesquisa to set
	 */
	public void setPesquisa(Associado pesquisa) {
		this.pesquisa = pesquisa;
	}

	/**
	 * @return the edicao
	 */
	public Associado getEdicao() {
		return edicao;
	}

	/**
	 * @param edicao the edicao to set
	 */
	public void setEdicao(Associado edicao) {
		this.edicao = edicao;
	}

	
	/**
	 * @return the resultado
	 */
	public Collection<Associado> getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Collection<Associado> resultado) {
		this.resultado = resultado;
	}
	


	
}
