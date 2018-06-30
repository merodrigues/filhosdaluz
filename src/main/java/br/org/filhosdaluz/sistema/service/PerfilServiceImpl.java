package br.org.filhosdaluz.sistema.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.filhosdaluz.sistema.model.Perfil;
import br.org.filhosdaluz.sistema.repository.PerfilRepository;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public void setPerfilRepository(PerfilRepository perfilDao) {
		this.perfilRepository = perfilDao;
	}

	@Override
	public Perfil salvar(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	@Override
	public void excluir(Long id) {
		perfilRepository.delete(id);
	}

	@Override
	public Perfil pesquisarPorId(Long id) {
		return perfilRepository.findOne(id);
	}
	
	@Override
	public List<Perfil> pesquisarPorNome(String nome) {
		return perfilRepository.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public List<Perfil> todos() {
		Iterable<Perfil> todos = perfilRepository.findAll();
		List<Perfil> retorno = new ArrayList<Perfil>();
		for(Perfil perfil: todos) {
			retorno.add(perfil);
		}
		return retorno;
	}

}
