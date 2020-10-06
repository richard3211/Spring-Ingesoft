/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labguis.gfour.interfaceService;

import com.labguis.gfour.modelo.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * DAO
 */
public interface IUsuarioService {
    public List<Usuario>listar();
    public Optional<Usuario>listarId(int id);
    public int save(Usuario u);
    public void delete(int id);
}
