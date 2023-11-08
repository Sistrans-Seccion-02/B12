package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.modelo.ConsumoHabitacion;
import uniandes.edu.co.proyecto.repositorio.ConsumoHabitacionRepository;

@Controller
public class ConsumoHabitacionController {

    @Autowired
    private ConsumoHabitacionRepository consumoHabitacionRepository;

    @GetMapping("/consumosHabitaciones")
    public String mostrarConsumosHabitaciones(Model model) {
        List<ConsumoHabitacion> consumos = consumoHabitacionRepository.obtenerConsumosHabitacion();
        model.addAttribute("consumosHabitaciones", consumos);
        return "consumosHabitaciones"; // Nombre de la vista HTML
    }
}