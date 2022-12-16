package com.example.Empleos.controller;

import com.example.Empleos.model.Vacante;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        //List<Vacante> lista= getVacante();
        List<Vacante> lista = restTemplate.getForEntity("http://localhost:9000/vacante/get/all", List.class).getBody();

        model.addAttribute("vacantes",lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model  model){
        Vacante vacante=new Vacante();
        vacante.setNombre("Ingeniero en comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);

        model.addAttribute("vacante",vacante);
        return "detalle";
    }
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

    private List<Vacante> getVacante(){
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista=new LinkedList<Vacante> ();
        try {
            Vacante vacante1= new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero civil");
            vacante1.setDescripcion("Solicitamos ingeniero civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-10-2020"));
            vacante1.setSalario(8500.0);
            vacante1.setDestacada(1);

            Vacante vacante2= new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador");
            vacante2.setDescripcion("Solicitamos Contador con 5 años de experiencia");
            vacante2.setFecha(sdf.parse("09-10-2021"));
            vacante2.setSalario(12000.0);
            vacante2.setDestacada(1);

            Vacante vacante3= new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Empresa internacional solicita Ingeniero Electrico para mantenimiento electrico");
            vacante3.setFecha(sdf.parse("08-10-2022"));
            vacante3.setSalario(10500.0);
            vacante3.setDestacada(0);

            Vacante vacante4= new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico");
            vacante4.setDescripcion("Solicitamos Diseñador Gráfico titulado para diseñar publicidad empresarial");
            vacante4.setFecha(sdf.parse("10-09-2022"));
            vacante4.setSalario(7500.0);
            vacante4.setDestacada(0);

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
