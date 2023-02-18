package com.grupodeyonkis.cursomiguigithub.controllers;

import com.grupodeyonkis.cursomiguigithub.dao.UsuarioDao;
import com.grupodeyonkis.cursomiguigithub.model.Usuario;
import com.grupodeyonkis.cursomiguigithub.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuariodao;

    @Autowired
    private JWTUtil jwtUtil;

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
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        //(veces que encripta la contraseña, memoria que va a consumir, creación de hilos de proceso para velocidad
        //por último lo que queremos hashear
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuariodao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {

        String usuarioId = jwtUtil.getKey(token);
        if (!validarToken(token)) {
            return new ArrayList<>();
        }
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
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (!validarToken(token)) {
            return;
        }

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

    // función de apoyo
    private boolean validarToken(String token){
        String usuarioid=jwtUtil.getKey(token);
        return usuarioid!=null;
    }

}
