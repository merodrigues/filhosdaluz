package br.org.filhosdaluz.sistema.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.filhosdaluz.sistema.model.Usuario;
import br.org.filhosdaluz.sistema.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void setUsuarioRepository(UsuarioRepository usuarioDao) {
		this.usuarioRepository = usuarioDao;
	}

	@Override
	public Usuario salvar(Usuario usuario) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(usuario.getSenha().getBytes()));
            usuario.setSenha(String.format("%32x", hash));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return usuarioRepository.save(usuario);
	}

	@Override
	public void excluir(Long id) {
		usuarioRepository.delete(id);
	}

	@Override
	public Usuario pesquisarPorId(Long id) {
		return usuarioRepository.findOne(id);
	}
	
	@Override
	public List<Usuario> pesquisarPorNome(String nome) {
		return usuarioRepository.findByNomeContainingIgnoreCase(nome);
	}

}
