/* 

package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;



@Controller
public class InternetController {

    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internets")
    public String internets(Model model){
        model.addAttribute("serviciosinternet", internetRepository.darInternets());
        return "internets";
    }

    @GetMapping("/internets/new")
    public String gimnasioForm(Model model){
        model.addAttribute("internets", new Internet());
        return "internetNuevo";      
    }

    @PostMapping("/internets/new/save")
    public String internetGuardar(@ModelAttribute Internet internet){
        internetRepository.insertarInternet(internet.getCosto(), internet.getCapacidad());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{id_servicio}/edit")
    public String internetEditarForm(@PathVariable("id_servicio") int id_servicio, Model model){
        Internet internet = internetRepository.darInternet(id_servicio);

        if (internet != null){
            model.addAttribute("internet", internet);
            return "internetEditar";
        } else {
            return "redirect:/internets";
        }
    }

    @PostMapping("/internets/{id_servicio}/edit/save")
    public String internetEditarGuardar(@PathVariable("id_servicio") int id_servicio, @ModelAttribute Internet internet){
        internetRepository.actualizarInternet(id_servicio, internet.getCosto(), internet.getCapacidad());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{id_servicio}/delete")
    public String internetEliminar(@PathVariable("id_servicio") int id_servicio){
        internetRepository.eliminarInternet(id_servicio);
        return "redirect:/internets";
    }






    
}

*/
