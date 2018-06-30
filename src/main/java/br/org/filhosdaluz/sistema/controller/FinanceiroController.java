package br.org.filhosdaluz.sistema.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.org.filhosdaluz.sistema.model.Associado;
import br.org.filhosdaluz.sistema.model.Financeiro;
import br.org.filhosdaluz.sistema.model.Perfil;
import br.org.filhosdaluz.sistema.model.TipoOperacao;
import br.org.filhosdaluz.sistema.model.Usuario;
import br.org.filhosdaluz.sistema.service.AssociadoService;
import br.org.filhosdaluz.sistema.service.FinanceiroService;
import br.org.filhosdaluz.sistema.service.PerfilService;
import br.org.filhosdaluz.sistema.service.UsuarioService;
import br.org.filhosdaluz.sistema.web.WebUtils;

@ManagedBean(name = "financeiroController")
@SessionScoped
public class FinanceiroController {

	private Boolean editar = false;
	private Financeiro pesquisa;
	private Financeiro edicao;
	private Long associado;
	private Collection<Financeiro> resultado;
	private Collection<Financeiro> listaTodos;
	private Collection<Associado> listaTodosAssociados;
	private Date dataInicial;
	private Date dataFinal;
	private Double somaEntrada;
	private Double somaSaida;
	private Double totalGeral;
	private List<Associado> listaAssociados;

	@ManagedProperty(value = "#{financeiroService}")
	private FinanceiroService financeiroService;

	@ManagedProperty(value = "#{associadoService}")
	private AssociadoService associadoService;
	

	/**
	 * @param usuarioService
	 *            the usuarioService to set
	 */
	public void setFinanceiroService(FinanceiroService financeiroService) {
		this.financeiroService = financeiroService;
	}

	/**
	 * @param associadoService
	 *            the associadoService to set
	 */
	
	public void setAssociadoService(AssociadoService associadoService) {
		this.associadoService = associadoService;
	}
	

	public void inicializar() {
		if (getPesquisa() == null) {
			setPesquisa(new Financeiro());
			getPesquisa().setDescricao("");
			getPesquisa().setDataInicial(new Date());
			getPesquisa().setDataFinal(new Date());
			setEdicao(new Financeiro());
			setResultado(new ArrayList<Financeiro>());
			setEditar(false);
			//getAssociados();
		}

	}

	public void novo() {
		
		setEdicao(new Financeiro());
		setEditar(true);
	
	}

	public void pesquisar() {
		setResultado(financeiroService.todos());

	}

	public void pesquisarDatas() {
		setResultado(financeiroService.pesquisarPorDatas(getPesquisa().getDataInicial(), getPesquisa().getDataFinal()));
		retornaEntrada();
	}

	public void cancelar() {
		setEditar(false);
	}

	public void salvar() {
		try {
			
			financeiroService.salvar(getEdicao());
			pesquisar();
			setEditar(false);
			WebUtils.incluirMensagemInfo("Financeiro gravado com sucesso!");
		} catch (Throwable t) {
			WebUtils.incluirMensagemErro(WebUtils.recuperarCausa(t));
		}
	}

	public void remover(Long id) {
		financeiroService.excluir(id);
		pesquisar();
	}

	public void editar(Long id) {

		setEdicao(financeiroService.pesquisarPorId(id));
		setEditar(true);
	}




	/**
	 * @return the editar
	 */
	public Boolean getEditar() {
		return editar;
	}

	/**
	 * @param editar
	 *            the editar to set
	 */
	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	/**
	 * @return the pesquisa
	 */
	public Financeiro getPesquisa() {
		return pesquisa;
	}

	/**
	 * @param pesquisa
	 *            the pesquisa to set
	 */
	public void setPesquisa(Financeiro pesquisa) {
		this.pesquisa = pesquisa;
	}

	/**
	 * @return the edicao
	 */
	public Financeiro getEdicao() {
		
		return edicao;
	}

	/**
	 * @param edicao
	 *            the edicao to set
	 */
	public void setEdicao(Financeiro edicao) {
	
		this.edicao = edicao;
	}

	/**
	 * @return the associado
	 */




	/**
	 * @param perfil
	 *            the associado to set
	 */



	public Collection<Financeiro> getListaTodos() {
		return listaTodos;
	}

	public List<Associado> getListaAssociados() {
		return listaAssociados;
	}

	public void setListaAssociados(List<Associado> listaAssociados) {
		this.listaAssociados = listaAssociados;
	}

	

	public void setListaTodos(Collection<Financeiro> listaTodos) {
		this.listaTodos = listaTodos;
	}

	public Collection<Associado> getListaTodosAssociados() {
		return listaTodosAssociados;
	}

	public void setListaTodosAssociados(Collection<Associado> listaTodosAssociados) {
		this.listaTodosAssociados = listaTodosAssociados;
	}
	
	public void incluirAssociado() {
		if(associado == null) {
			WebUtils.incluirMensagemErro("informa um!");
		}
		else {
			getEdicao().setAssociado(associadoService.pesquisarPorId(associado));
			setAssociado(null);
		}
	}

	

	

	public Long getAssociado() {
		if (edicao.getAssociado() != null){
			associado = edicao.getAssociado().getId();
		}
		return associado;
	}

	public void setAssociado(Long associado) {
		this.associado = associado;
	}

	public AssociadoService getAssociadoService() {
		return associadoService;
	}

	/**
	 * @return the resultado
	 */
	public Collection<Financeiro> getResultado() {
  		return resultado;
	}

	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(Collection<Financeiro> resultado) {
		this.resultado = resultado;
	}

	/**
	 * Lista todos os associados cadastrados
	 * 
	 * @return List<Associado>
	 */

	public List<Associado> getAssociados() {
		return associadoService.todos();
	}

	/**
	 * Lista todos os financeiros cadastrados
	 * 
	 * @return List<Financeiro>
	 */
	public List<Financeiro> getFinanceiros() {
		return financeiroService.pesquisarPorDatas(dataInicial, dataFinal);
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Double getSomaEntrada() {
		return somaEntrada;
	}

	public void setSomaEntrada(Double somaEntrada) {
		this.somaEntrada = somaEntrada;
	}

	public Double getSomaSaida() {
		return somaSaida;
	}

	public void setSomaSaida(Double somaSaida) {
		this.somaSaida = somaSaida;
	}

	public Double getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(Double totalGeral) {
		this.totalGeral = totalGeral;
	}

	public Double retornaEntrada() {
		setSomaEntrada((double) 0);
		setSomaSaida((double) 0);
		setTotalGeral((double) 0);
		for (Financeiro tipoFinanceiro : resultado) {

			if (tipoFinanceiro.isTipoOperacao() == true && tipoFinanceiro.getValor() != null) {
				somaEntrada += tipoFinanceiro.getValor().doubleValue();

			}

			if (tipoFinanceiro.isTipoOperacao() == false && tipoFinanceiro.getValor() != null) {
				somaSaida += tipoFinanceiro.getValor().doubleValue();

			}

		}

		totalGeral = somaEntrada - somaSaida;

		return somaEntrada;

	}
	
	
	/*
	public List<Associado> getAssociadoSelect(){
		if (associadoSelect == null){
			associadoSelect = new ArrayList<Associado>();
			Associado associado = new Associado();
			List<Associado> listaAssociados = associado.listar();
			
			if(listaAssociado !=null && !listaAssociados.isEmpty()){
				SelectAssociado associado;
				for (Associado asociadolista: listaAssociados){
					associado  = new SelectAssociado(associadoLista, associadoLista.getNome);
					associadoSelect.add(associado);
			}
		}
		return associadoSelect;
	}
	}
	
		
		*/

}
