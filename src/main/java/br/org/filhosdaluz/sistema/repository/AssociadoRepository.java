package br.org.filhosdaluz.sistema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.filhosdaluz.sistema.model.Associado;
import br.org.filhosdaluz.sistema.model.Usuario;


public interface  AssociadoRepository extends CrudRepository<Associado, Long>{

	
	/**
	 * Busca associado com nome especificado
	 * @param nome Nome
	 * @return Associado
	 */
	public Associado findByNome(String nome);
	
	/**
	 * Busca usuarios com nome similiar ao especificado
	 * @param nome Nome
	 * @return List<Associado>
	 */
	public List<Associado> findByNomeContainingIgnoreCase(String nome);	
	
}

