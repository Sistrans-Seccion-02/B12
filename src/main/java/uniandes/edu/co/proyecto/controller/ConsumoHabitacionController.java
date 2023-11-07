package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uniandes.edu.co.proyecto.repositorio.ConsumoHabitacionRepository;

@Controller
public class ConsumoHabitacionController {

    @Autowired
    private ConsumoHabitacionRepository consumoServicioRepository;
    
    @GetMapping("/consumohabitacion")
    public String mostrarConsumosServicios(Model model) {
        model.addAttribute("consumohabitacion", consumoServicioRepository.obtenerConsumosServicios());
        return "consumohabitacion";
    }
}