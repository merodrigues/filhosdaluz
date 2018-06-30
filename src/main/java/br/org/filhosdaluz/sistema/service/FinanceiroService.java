package br.org.filhosdaluz.sistema.service;

import java.util.Date;
import java.util.List;


import br.org.filhosdaluz.sistema.model.Financeiro;




public interface FinanceiroService {
	
public Financeiro salvar(Financeiro financeiro);
	
	public void excluir(Long id);
	
	public Financeiro pesquisarPorId(Long id);
	
	public List<Financeiro> pesquisarPorDescricao(String descricao);
	
	public List<Financeiro> todos();
	
	public List<Financeiro> pesquisarPorDatas(Date dataInicial, Date dataFinal);






	
}
