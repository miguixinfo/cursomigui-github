package com.grupodeyonkis.cursomiguigithub.controllers;

import com.grupodeyonkis.cursomiguigithub.dao.UsuarioDao;
import com.grupodeyonkis.cursomiguigithub.model.Usuario;

import com.grupodeyonkis.cursomiguigithub.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public Map login(@RequestBody Usuario usuario) {
        Map respuesta = new HashMap();
        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            respuesta.put("token", tokenJWT);
            respuesta.put("success", "OK");
        } else respuesta.put("sucess", "FAIL");
        return respuesta;
    }
}
