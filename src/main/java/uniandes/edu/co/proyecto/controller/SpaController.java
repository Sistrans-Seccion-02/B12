/* 

package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.repositorio.SpaRepository;



@Controller
public class SpaController {

    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spas(Model model){
        model.addAttribute("spas", spaRepository.darServiciosSpa());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaForm(Model model){
        model.addAttribute("spa", new Spa());
        return "spaNuevo";      
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute Spa spa){
        spaRepository.insertarServicioSpa(spa.getCosto());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id_servicio}/edit")
    public String spaEditarForm(@PathVariable("id_servicio") int id_servicio, Model model){
        Spa spa = spaRepository.darServicioSpa(id_servicio);

        if (spa != null){
            model.addAttribute("spa", spa);
            return "spaEditar";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{id_servicio}/edit/save")
    public String spaEditarGuardar(@PathVariable("id_servicio") int id_servicio, @ModelAttribute Spa spa){
        spaRepository.actualizarServicioSpa(id_servicio, spa.getCosto());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id_servicio}/delete")
    public String spaEliminar(@PathVariable("id_servicio") int id_servicio){
        spaRepository.eliminarServicioSpa(id_servicio);
        return "redirect:/spas";
    }

    
}

*/