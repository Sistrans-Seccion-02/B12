package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.TipoHabitacion;
import uniandes.edu.co.proyecto.RepositorioMongo.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/mongo-tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "tipoHabitacion";
    }

    @GetMapping("/mongo-tiposHabitacion/new")
    public String tipoHabitacionForm(Model model) {
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/mongo-tiposHabitacion/new/save")
    public String tipoHabitacionGuardar(Model model, @ModelAttribute TipoHabitacion tipoHabitacion) {
        try {
            tipoHabitacionRepository.save(tipoHabitacion);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el tipo de habitación. No cumple la validación :(");
        }
        return "redirect:/mongo-tiposHabitacion";
    }

    @GetMapping("/mongo-tiposHabitacion/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") String id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(id).orElse(null);
        if (tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        } else {
            return "redirect:/mongo-tiposHabitacion";
        }
    }

    @PostMapping("/mongo-tiposHabitacion/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(Model model, @PathVariable("id") String id,
                                              @ModelAttribute TipoHabitacion tipoHabitacion) {
        try {
            tipoHabitacionRepository.save(tipoHabitacion);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-tiposHabitacion";
    }

    @GetMapping("/mongo-tiposHabitacion/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") String id) {
        tipoHabitacionRepository.deleteById(id);
        return "redirect:/mongo-tiposHabitacion";
    }
}
