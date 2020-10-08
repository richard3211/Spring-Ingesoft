/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labguis.gfour.controlador;

import com.labguis.gfour.interfaceService.IUsuarioService;
import com.labguis.gfour.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class LoginController {
    
    @Autowired
    private IUsuarioService service;
    
    @PostMapping("/login")
    public String login(@Validated Usuario user, Model model) {
        if(!checkName(user.getNombre())) {
            model.addAttribute("error", "Longitud del nombre incorrecta");
        }
        else if(!checkPass(user.getPassword())) {
            model.addAttribute("error", "Longitud de la contraseña incorrecta");
        }
        else {
            Usuario user_to_check = service.findByNombre(user.getNombre());
            if(user_to_check == null) model.addAttribute("error", "No se encontro el usuario");
            else {
                if(user_to_check.getPassword().equals(user.getPassword())) {
                    model.addAttribute("info", "Datos correctos. Bienvenido!");
                }
                else model.addAttribute("error", "Datos incorrectos");
            }
        }
        return "login";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    public boolean checkName(String nombre) {
        return (nombre.length() > 1 && nombre.length() <= 8);
    }
    
    public boolean checkPass(String pass) {
        return (pass.length() > 3 && pass.length() < 6);
    }
}
