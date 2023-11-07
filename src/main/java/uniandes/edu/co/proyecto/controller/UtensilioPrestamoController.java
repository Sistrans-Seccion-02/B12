/* 

package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.UtensilioPrestamo;
import uniandes.edu.co.proyecto.repositorio.UtensilioPrestamoRepository;



@Controller
public class UtensilioPrestamoController {

    @Autowired
    private UtensilioPrestamoRepository utensilioPrestamoRepository;

    @GetMapping("/utensiliosprestamo")
    public String utensiliosprestamo(Model model){
        model.addAttribute("utensiliosprestamo", utensilioPrestamoRepository.darUtensiliosPrestamo());
        return "utensiliosprestamo";
    }

    @GetMapping("/utensiliosprestamo/new")
    public String utensilioprestamoForm(Model model){
        model.addAttribute("utensilioprestamo", new UtensilioPrestamo());
        return "utensilioprestamoNuevo";      
    }

    @PostMapping("/utensiliosprestamo/new/save")
    public String utensilioprestamoGuardar(@ModelAttribute UtensilioPrestamo utensilio){
        utensilioPrestamoRepository.insertarUtensilioPrestamo(utensilio.getPrestado(), utensilio.getDevuelto(), utensilio.getMal_estado(), utensilio.getCosto_extra());
        return "redirect:/utensiliosprestamo";
    }

    @GetMapping("/utensiliosprestamo/{id_servicio}/edit")
    public String utensilioprestamoEditarForm(@PathVariable("id_servicio") int id_servicio, Model model){
        UtensilioPrestamo utensilio = utensilioPrestamoRepository.darUtensilioPrestamo(id_servicio);

        if (utensilio != null){
            model.addAttribute("utensilioprestamo", utensilio);
            return "utensilioprestamoEditar";
        } else {
            return "redirect:/utensiliosprestamo";
        }
    }

    @PostMapping("/utensiliosprestamo/{id_servicio}/edit/save")
    public String utensilioprestamoEditarGuardar(@PathVariable("id_servicio") int id_servicio, @ModelAttribute UtensilioPrestamo utensilio){
        utensilioPrestamoRepository.actualizarUtensilioPrestamo(id_servicio, utensilio.getPrestado(), utensilio.getDevuelto(), utensilio.getMal_estado(), utensilio.getCosto_extra());
        return "redirect:/utensiliosprestamo";
    }

    @GetMapping("/utensiliosprestamo/{id_servicio}/delete")
    public String utensilioprestamoEliminar(@PathVariable("id_servicio") int id_servicio){
        utensilioPrestamoRepository.eliminarUtensilioPrestamo(id_servicio);
        return "redirect:/utensiliosprestamo";
    }
    
}

*/
