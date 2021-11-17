package com.unbosque.sistemainventario.service.serviceApi;

import com.unbosque.sistemainventario.model.Producto;
import com.unbosque.sistemainventario.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();
    Usuario insertUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    boolean verificarCredenciales(Usuario usuario);

}
