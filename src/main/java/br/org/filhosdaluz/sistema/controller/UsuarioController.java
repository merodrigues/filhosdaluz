package br.org.filhosdaluz.sistema.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.org.filhosdaluz.sistema.model.Perfil;
import br.org.filhosdaluz.sistema.model.Usuario;
import br.org.filhosdaluz.sistema.service.PerfilService;
import br.org.filhosdaluz.sistema.service.UsuarioService;
import br.org.filhosdaluz.sistema.web.WebUtils;

@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController {
	
	private Boolean editar = false;
	private Usuario pesquisa;
	private Usuario edicao;
	private Long perfil;
	private Collection<Usuario> resultado;
	
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;
	
	@ManagedProperty(value="#{perfilService}")
	private PerfilService perfilService;

	/**
	 * @param usuarioService the usuarioService to set
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	/**
	 * @param perfilService the perfilService to set
	 */
	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	public void inicializar() {
		if(getPesquisa() == null) {
			setPesquisa(new Usuario());
			getPesquisa().setNome("");
			setEdicao(new Usuario());
			setResultado(new ArrayList<Usuario>());
			setEditar(false);
		}
	}
	
	public void novo() {
		setEdicao(new Usuario());
		setEditar(true);
	}
	
	public void pesquisar() {
		setResultado(usuarioService.pesquisarPorNome(getPesquisa().getNome()));
	}
	
	public void cancelar() {
		setEditar(false);
	}
	
	public void salvar() {
		try{
			usuarioService.salvar(getEdicao());
			pesquisar();
			setEditar(false);
			WebUtils.incluirMensagemInfo("Usuário gravado com sucesso!");
		}
		catch(Throwable t) {
			WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
		}
	}
	
	public void remover(Long id) {
		usuarioService.excluir(id);
		pesquisar();
	}
	
	public void editar(Long id) {
		setEdicao(usuarioService.pesquisarPorId(id));
		setEditar(true);
	}
	
	public void incluirPerfil() {
		if(perfil == null) {
			WebUtils.incluirMensagemErro("É necessário informar um perfil!");
		}
		else {
			getEdicao().getPerfis().add(perfilService.pesquisarPorId(perfil));
			setPerfil(null);
		}
	}
	
	public void removerPerfil(Perfil perfil) {
		getEdicao().getPerfis().remove(perfil);
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
	public Usuario getPesquisa() {
		return pesquisa;
	}

	/**
	 * @param pesquisa the pesquisa to set
	 */
	public void setPesquisa(Usuario pesquisa) {
		this.pesquisa = pesquisa;
	}

	/**
	 * @return the edicao
	 */
	public Usuario getEdicao() {
		return edicao;
	}

	/**
	 * @param edicao the edicao to set
	 */
	public void setEdicao(Usuario edicao) {
		this.edicao = edicao;
	}

	/**
	 * @return the perfil
	 */
	public Long getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Long perfil) {
		this.perfil = perfil;
	}
	
	/**
	 * @return the resultado
	 */
	public Collection<Usuario> getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Collection<Usuario> resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * Lista todos os perfis cadastrados
	 * @return List<Perfil>
	 */
	public List<Perfil> getPerfis() {
		return perfilService.todos();
	}
	
}
