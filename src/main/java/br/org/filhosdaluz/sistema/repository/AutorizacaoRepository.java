package br.org.filhosdaluz.sistema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.filhosdaluz.sistema.model.Autorizacao;

public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long>{

	/**
	 * Busca autorizacao com nome especificado
	 * @param nome Nome
	 * @return Autorizacao
	 */
	public Autorizacao findByNome(String nome);
	
	/**
	 * Busca autorizacoes com nome similiar ao especificado
	 * @param nome Nome
	 * @return List<Autorizacao>
	 */
	public List<Autorizacao> findByNomeContainingIgnoreCase(String nome);	
	
}
