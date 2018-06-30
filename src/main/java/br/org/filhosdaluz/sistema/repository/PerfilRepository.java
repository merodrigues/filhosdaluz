package br.org.filhosdaluz.sistema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.filhosdaluz.sistema.model.Perfil;

public interface PerfilRepository extends CrudRepository<Perfil, Long>{

	/**
	 * Busca perfil com nome especificado
	 * @param nome Nome
	 * @return Perfil
	 */
	public Perfil findByNome(String nome);
	
	/**
	 * Busca perfis com nome similiar ao especificado
	 * @param nome Nome
	 * @return List<Perfil>
	 */
	public List<Perfil> findByNomeContainingIgnoreCase(String nome);	
	
}
