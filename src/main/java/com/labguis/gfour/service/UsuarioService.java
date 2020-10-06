/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labguis.gfour.service;

import com.labguis.gfour.interfaceService.IUsuarioService;
import com.labguis.gfour.interfaces.IUsuario;
import com.labguis.gfour.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Makot
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuario data;
    
    @Override
    public List<Usuario> listar() {
        return (List<Usuario>)data.findAll();
    }

    @Override
    public Optional<Usuario> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Usuario u) {
        int res = 0;
        Usuario usuario = data.save(u);
        if(!usuario.equals(null)) res = 1;
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
    
}
