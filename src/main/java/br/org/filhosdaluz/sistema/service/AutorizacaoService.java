package br.org.filhosdaluz.sistema.service;

import java.util.List;

import br.org.filhosdaluz.sistema.model.Autorizacao;

public interface AutorizacaoService {
	
	public Autorizacao salvar(Autorizacao autorizacao);
	
	public void excluir(Long id);
	
	public Autorizacao pesquisarPorId(Long id);
	
	public List<Autorizacao> pesquisarPorNome(String nome);
	
	public List<Autorizacao> todos();

}
