package com.example.Empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista= new LinkedList<String>();
        lista.add("Ingeniero en sistemas");
        lista.add("Auxiliar de contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");
        model.addAttribute("empleos",lista);

        return "listado";

    }
}
