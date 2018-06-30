package br.org.filhosdaluz.sistema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Null;




@Entity
@Table(name="FINANCEIRO")
public class Financeiro   implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6232111822534212199L;
	
	
	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="financeiro_seq")
	@SequenceGenerator(name="financeiro_seq",sequenceName="seq_financeiro_id", allocationSize=1)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Long id;
	
	 @Column(name = "CODIGO")
		private Long codigo;
	 
	 @Column(name = "DESCRICAO")
	   	private String descricao;
	 
	 @Column(name = "TIPOPERACAO")
	 private boolean tipoOperacao;
	 

	 @Column(name = "DATACADASTRO")
	    @Temporal(TemporalType.DATE)
	   	private Date dataCadastro;
	 
	 @Column(name = "DATAVENCIMENTO")
	    @Temporal(TemporalType.DATE)
	   	private Date dataVencimento;
	 
	 @Column(name = "Valor")
	  private Double valor;
	 
	 @Column(name = "QUANTIDADE")
	   	private String quantidade;
	 
	 @Column(name = "UNIDADE")
	   	private String unidade;
	 
	
	 @Temporal(TemporalType.DATE)
	 private Date dataInicial;
	 
	
	 @Temporal(TemporalType.DATE)
	 private Date dataFinal;
	 
	
	 @Temporal(TemporalType.DATE)
	 private Date dataPagamento;
	
	 @ManyToOne(cascade=CascadeType.REMOVE)
    private Associado associado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public boolean isTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(boolean tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
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

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}


	

}
