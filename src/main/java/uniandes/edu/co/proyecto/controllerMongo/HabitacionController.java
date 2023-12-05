package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.Habitacion;
import uniandes.edu.co.proyecto.RepositorioMongo.HabitacionRepository;
import uniandes.edu.co.proyecto.RepositorioMongo.TipoHabitacionRepository;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/mongo-habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "habitacion";
    }

    @GetMapping("/mongo-habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "habitacionNuevo";
    }

    @GetMapping("/mongo-habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.buscarPorId(id).orElse(null);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
            return "habitacionEditar";
        } else {
            return "redirect:/mongo-habitaciones";
        }
    }

    @GetMapping("/mongo-habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") String id) {
        habitacionRepository.eliminarHabitacion(id);;
        return "redirect:/mongo-habitaciones";
    }
}
