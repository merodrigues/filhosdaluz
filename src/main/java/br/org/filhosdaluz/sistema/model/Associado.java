package br.org.filhosdaluz.sistema.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;



@Entity
@Table(name = "ASSOCIADO")
public class Associado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1288998726856830064L;

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="associado_seq")
	@SequenceGenerator(name="associado_seq",sequenceName="seq_associado_id", allocationSize=1)
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	private Long id;
    
    @Column(name = "CODIGO")
	private Long codigo;
	
    @Column(name = "NOME")
   	private String nome;
    
 
    @Column(name = "pessoa")
   	private String pessoa;


    @Column(name = "numDocumento")
   	private String numDocumento;
   
    
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
   	private Date dataCadastro;
    
    @Column(name = "ENDERECO")
   	private String endereco;
    
    @Column(name = "BAIRRO")
   	private String bairro;
    
    @Column(name = "CEP")
   	private String cep;
    
    @Column(name = "CIDADE")
   	private String cidade;
    
    @Column(name = "UF")
   	private String uf;
    
    @Column(name = "TELEFONE")
   	private String telefone;
    
    @Column(name = "RECADO")
   	private String recado;
    
    
    @Column(name = "EMAIL")
   	private String email;
	
    @Column(name = "VENCIMENTO")
   	private String vencimento;
    
    @Column(name = "FORMACONTRIBUICAO")
   	private String formaContribuicao;
    
    @Column(name = "OBSERVACAO")
   	private String observacao;
    
    @Column(name = "DESTINO")
   	private String destino;
    
    @Column(name = "DATARENOVACAO")
    @Temporal(TemporalType.DATE)
   	private Date dataRenovacao;
    
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.DATE)
   	private Date dataNascimento;
      
    

	public Associado() {

	}	
	

	public Associado(Long id) {
		this.id = id;
	}
	
	

	




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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getPessoa() {
		return pessoa;
	}


	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}


	public String getNumDocumento() {
		return numDocumento;
	}


	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRecado() {
		return recado;
	}

	public void setRecado(String recado) {
		this.recado = recado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public String getFormaContribuicao() {
		return formaContribuicao;
	}

	public void setFormaContribuicao(String formaContribuicao) {
		this.formaContribuicao = formaContribuicao;
	}

	

	public String getObservacao() {
		return observacao;
	}




	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}




	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	

	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}
	
	

	
	

/*
	@Override
	public String toString() {
		return "Associado [nome=" + nome + "]";
	}
	
	*/
	

	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Date getDataRenovacao() {
		return dataRenovacao;
	}


	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associado other = (Associado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
    
    
    
}
