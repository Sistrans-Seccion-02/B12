package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;



@Controller
public class PiscinaController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscinas(Model model){
        model.addAttribute("piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }

    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model){
        model.addAttribute("piscina", new Piscina());
        return "piscinaNuevo";      
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina){
        piscinaRepository.insertarPiscina(piscina.getHorario(), piscina.getCapacidad(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id_servicio}/edit")
    public String piscinaEditarForm(@PathVariable("id_servicio") int id_servicio, Model model){
        Piscina piscina = piscinaRepository.darPiscina(id_servicio);

        if (piscina != null){
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscinas/{id_servicio}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id_servicio") int id_servicio, @ModelAttribute Piscina piscina){
        piscinaRepository.actulizarPiscina(id_servicio, piscina.getHorario(), piscina.getCapacidad(), piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id_servicio}/delete")
    public String piscinaEliminar(@PathVariable("id_servicio") int id_servicio){
        piscinaRepository.eliminarPiscina(id_servicio);
        return "redirect:/piscinas";
    }
    
}
