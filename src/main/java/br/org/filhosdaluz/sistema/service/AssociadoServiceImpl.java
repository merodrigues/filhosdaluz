package br.org.filhosdaluz.sistema.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.filhosdaluz.sistema.model.Associado;
import br.org.filhosdaluz.sistema.model.Perfil;
import br.org.filhosdaluz.sistema.repository.AssociadoRepository;


@Service("associadoService")
public class AssociadoServiceImpl implements AssociadoService  {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	public void setAssociadoRepository(AssociadoRepository associadoDao) {
		this.associadoRepository = associadoDao;
	}
	
	@Override
	public Associado salvar(Associado associado) {
    
        return  associadoRepository.save(associado);
	}
	
	@Override
	public void excluir(Long id) {
		associadoRepository.delete(id);
	}
	
	@Override
	public Associado pesquisarPorId(Long id) {
		return associadoRepository.findOne(id);
	}
	
	@Override
	public List<Associado> pesquisarPorNome(String nome) {
		return associadoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	@Override
	public List<Associado> todos() {
		Iterable<Associado> todos = associadoRepository.findAll();
		List<Associado> retorno = new ArrayList<Associado>();
		for(Associado associado: todos) {
			retorno.add(associado);
		}
		return retorno;
	}
	
	
	
}