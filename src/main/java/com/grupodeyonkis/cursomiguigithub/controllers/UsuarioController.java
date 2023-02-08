package com.grupodeyonkis.cursomiguigithub.controllers;

import com.grupodeyonkis.migui.cursomigui.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id ) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setId(id);
        usuario.setApellido("Gómez");
        usuario.setEmail("gmigui@gmail.com");
        usuario.setTelefono("635749440");

        return usuario;
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

    @RequestMapping(value = "usuario12")
    public Usuario eliminar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setApellido("Gómez");
        usuario.setEmail("gmigui@gmail.com");
        usuario.setTelefono("635749440");

        return usuario;
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

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setId(23L);
        usuario.setApellido("Gómez");
        usuario.setEmail("gmigui@gmail.com");
        usuario.setTelefono("635749440");


        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Marcos");
        usuario2.setId(564L);
        usuario2.setApellido("Polo");
        usuario2.setEmail("marco@gmail.com");
        usuario2.setTelefono("5432345654");

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Javi");
        usuario3.setId(12L);
        usuario3.setApellido("Lopez");
        usuario3.setEmail("javi@gmail.com");
        usuario3.setTelefono("6354321234");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }

}
