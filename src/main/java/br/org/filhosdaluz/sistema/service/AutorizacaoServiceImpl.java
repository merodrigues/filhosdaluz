package br.org.filhosdaluz.sistema.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.filhosdaluz.sistema.model.Autorizacao;
import br.org.filhosdaluz.sistema.repository.AutorizacaoRepository;

@Service("autorizacaoService")
@Transactional
public class AutorizacaoServiceImpl implements AutorizacaoService {
	
	@Autowired
	private AutorizacaoRepository autorizacaoRepository;
	
	public void setAutorizacaoRepository(AutorizacaoRepository autorizacaoDao) {
		this.autorizacaoRepository = autorizacaoDao;
	}

	@Override
	public Autorizacao salvar(Autorizacao autorizacao) {
		return autorizacaoRepository.save(autorizacao);
	}

	@Override
	public void excluir(Long id) {
		autorizacaoRepository.delete(id);
	}

	@Override
	public Autorizacao pesquisarPorId(Long id) {
		return autorizacaoRepository.findOne(id);
	}
	
	@Override
	public List<Autorizacao> pesquisarPorNome(String nome) {
		return autorizacaoRepository.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public List<Autorizacao> todos() {
		Iterable<Autorizacao> todos = autorizacaoRepository.findAll();
		List<Autorizacao> retorno = new ArrayList<Autorizacao>();
		for(Autorizacao autorizacao: todos) {
			retorno.add(autorizacao);
		}
		return retorno;
	}

}
