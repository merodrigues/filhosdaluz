package br.org.filhosdaluz.sistema.repository;

import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.filhosdaluz.sistema.model.Financeiro;


public interface FinanceiroRepository  extends CrudRepository<Financeiro, Long>{
	

	/**
	 * Busca autorizacao com nome especificado
	 * @param descricao DescricaofindByDescricaoContainingIgnoreCase
	 * @return Financeiro
	 */
	public Financeiro findByDescricao(String descricao);
	
	/**
	 * Busca autorizacoes com nome similiar ao especificado
	 * @param descricao Descricao
	 * @return List<Financeiro>
	 */
	public List<Financeiro> findByDescricaoContainingIgnoreCase(String decricao);


	//public List<Financeiro> findByStartDateBetween(Date dataInicial, Date dataFinal);

	
	

}
