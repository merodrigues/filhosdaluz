package br.org.filhosdaluz.sistema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.filhosdaluz.sistema.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	/**
	 * Busca usuario com nome especificado
	 * @param nome Nome
	 * @return Usuario
	 */
	public Usuario findByNome(String nome);
	
	/**
	 * Busca usuarios com nome similiar ao especificado
	 * @param nome Nome
	 * @return List<Usuario>
	 */
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);	
	
}
