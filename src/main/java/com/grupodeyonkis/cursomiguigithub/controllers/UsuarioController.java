package com.grupodeyonkis.cursomiguigithub.controllers;

import com.grupodeyonkis.cursomiguigithub.dao.UsuarioDao;
import com.grupodeyonkis.cursomiguigithub.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuariodao;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id ) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setId(id);
        usuario.setApellido("Gómez");
        usuario.setEmail("gmigui@gmail.com");
        usuario.setTelefono("635749440");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usuariodao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {
        return usuariodao.getUsuarios();
    }

    @RequestMapping(value = "usuario1")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setApellido("Gómez");
        usuario.setEmail("gmigui@gmail.com");
        usuario.setTelefono("635749440");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuariodao.eliminar(id);
    }

    @RequestMapping(value = "usuario123")
    public Usuario buscar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setApellido("Gómez");
        usuario.setEmail("gmigui@gmail.com");
        usuario.setTelefono("635749440");

        return usuario;
    }



}
