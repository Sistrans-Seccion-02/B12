/* 

package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Lavanderia;
import uniandes.edu.co.proyecto.repositorio.LavanderiaRepository;



@Controller
public class LavanderiaController {

    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    @GetMapping("/lavanderias")
    public String lavanderias(Model model){
        model.addAttribute("lavanderias", lavanderiaRepository.darLavanderias());
        return "lavanderias";
    }

    @GetMapping("/lavanderias/new")
    public String lavanderiaForm(Model model){
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderiaNueva";      
    }

    @PostMapping("/lavanderias/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.insertarLavanderia(lavanderia.getCosto());
        return "redirect:/lavanderias";
    }

    @GetMapping("/lavanderias/{id_servicio}/edit")
    public String lavanderiaEditarForm(@PathVariable("id_servicio") int id_servicio, Model model){
        Lavanderia lavanderia = lavanderiaRepository.darLavanderia(id_servicio);

        if (lavanderia != null){
            model.addAttribute("lavanderia", lavanderia);
            return "lavanderiaEditar";
        } else {
            return "redirect:/lavanderias";
        }
    }

    @PostMapping("/lavanderias/{id_servicio}/edit/save")
    public String lavanderiaEditarGuardar(@PathVariable("id_servicio") int id_servicio, @ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.actualizarLavanderia(id_servicio, lavanderia.getCosto());
        return "redirect:/lavanderias";
    }

    @GetMapping("/lavanderias/{id_servicio}/delete")
    public String lavanderiaEliminar(@PathVariable("id_servicio") int id_servicio){
        lavanderiaRepository.eliminarLavanderia(id_servicio);
        return "redirect:/lavanderias";
    }
    
}


*/