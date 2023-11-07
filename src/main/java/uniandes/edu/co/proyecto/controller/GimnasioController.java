/* 

package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;



@Controller
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimnasios(Model model){
        model.addAttribute("gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/gimnasios/new")
    public String gimnasioForm(Model model){
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";      
    }

    @PostMapping("/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio){
        gimnasioRepository.insertarGimnasio(gimnasio.getHorario(), gimnasio.getCapacidad());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id_servicio}/edit")
    public String gimnasioEditarForm(@PathVariable("id_servicio") int id_servicio, Model model){
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id_servicio);

        if (gimnasio != null){
            model.addAttribute("piscina", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/gimnasios";
        }
    }

    @PostMapping("/gimnasios/{id_servicio}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id_servicio") int id_servicio, @ModelAttribute Gimnasio gimnasio){
        gimnasioRepository.actualizarGimnasio(id_servicio, gimnasio.getHorario(), gimnasio.getCapacidad());
        return "redirect:/gimnasios";
    }

    @GetMapping("/gimnasios/{id_servicio}/delete")
    public String gimnasioEliminar(@PathVariable("id_servicio") int id_servicio){
        gimnasioRepository.eliminarGimnasio(id_servicio);
        return "redirect:/gimnasios";
    }






    
}

*/
