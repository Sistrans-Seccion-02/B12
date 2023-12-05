package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/mongo-servicios")
    public String servicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicio";
    }

    @GetMapping("/mongo-servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/mongo-servicios/new/save")
    public String servicioGuardar(Model model, @ModelAttribute Servicio servicio) {
        try {
            servicioRepository.save(servicio);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el servicio. No cumple la validación :(");
        }
        return "redirect:/mongo-servicios";
    }

    @GetMapping("/mongo-servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.findById(id).orElse(null);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "redirect:/mongo-servicios";
        }
    }

    @PostMapping("/mongo-servicios/{id}/edit/save")
    public String servicioEditarGuardar(Model model, @PathVariable("id") Integer id,
                                        @ModelAttribute Servicio servicio) {
        try {
            servicioRepository.save(servicio);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-servicios";
    }

    @GetMapping("/mongo-servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") Integer id) {
        servicioRepository.deleteById(id);
        return "redirect:/mongo-servicios";
    }
}
