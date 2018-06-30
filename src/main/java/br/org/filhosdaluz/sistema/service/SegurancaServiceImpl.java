package br.org.filhosdaluz.sistema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.filhosdaluz.sistema.model.Usuario;
import br.org.filhosdaluz.sistema.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService  {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void setUsuarioRepository(UsuarioRepository usuarioDao) {
		this.usuarioRepository = usuarioDao;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNome(userName);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return usuario;
	}

}
