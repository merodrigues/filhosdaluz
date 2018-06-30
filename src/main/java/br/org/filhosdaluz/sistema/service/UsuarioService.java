package br.org.filhosdaluz.sistema.service;

import java.util.List;

import br.org.filhosdaluz.sistema.model.Usuario;

public interface UsuarioService {
	
	public Usuario salvar(Usuario usuario);
	
	public void excluir(Long id);
	
	public Usuario pesquisarPorId(Long id);
	
	public List<Usuario> pesquisarPorNome(String nome);

}
