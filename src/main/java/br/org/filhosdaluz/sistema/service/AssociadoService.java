package br.org.filhosdaluz.sistema.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.filhosdaluz.sistema.model.Associado;
import br.org.filhosdaluz.sistema.model.Perfil;
import br.org.filhosdaluz.sistema.model.Usuario;
import br.org.filhosdaluz.sistema.repository.AssociadoRepository;



public interface AssociadoService {

	public Associado salvar(Associado associado);
	
	public void excluir(Long id);
	
	public Associado pesquisarPorId(Long id);
	
	public List<Associado> pesquisarPorNome(String nome);
	
	public List<Associado> todos();

}
	
