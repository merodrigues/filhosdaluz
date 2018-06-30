package br.org.filhosdaluz.sistema.service;

import java.util.List;

import br.org.filhosdaluz.sistema.model.Perfil;

public interface PerfilService {
	
	public Perfil salvar(Perfil perfil);
	
	public void excluir(Long id);
	
	public Perfil pesquisarPorId(Long id);
	
	public List<Perfil> pesquisarPorNome(String nome);
	
	public List<Perfil> todos();

}
