package com.unbosque.sistemainventario.service.serviceImpl;

import com.unbosque.sistemainventario.service.serviceApi.UsuarioService;

import com.unbosque.sistemainventario.model.Usuario;
import com.unbosque.sistemainventario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuario = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario::add);
        return usuario;
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE usuario=:usuario AND contrasena=:contrasena";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("usuario", usuario.getUsuario())
                .setParameter("contrasena", usuario.getContrasena())
                .getResultList();
        return !lista.isEmpty();
    }

}
