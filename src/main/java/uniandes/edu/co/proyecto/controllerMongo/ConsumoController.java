package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

import java.util.List;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/mongo-consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.findAll());
        return "consumo";
    }

    @GetMapping("/mongo-consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        model.addAttribute("servicios", servicioRepository.findAll());
        return "consumoNuevo";
    }

    @PostMapping("/mongo-consumos/new/save")
    public String consumoGuardar(Model model, @ModelAttribute Consumo consumo) {
        try {
            consumoRepository.save(consumo);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el consumo. No cumple la validación :(");
        }
        return "redirect:/mongo-consumos";
    }

    @GetMapping("/mongo-consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable("id") Integer id, Model model) {
        Consumo consumo = consumoRepository.findById(id).orElse(null);
        if (consumo != null) {
            model.addAttribute("consumo", consumo);
            model.addAttribute("habitaciones", habitacionRepository.findAll());
            model.addAttribute("servicios", servicioRepository.findAll());
            return "consumoEditar";
        } else {
            return "redirect:/mongo-consumos";
        }
    }

    @PostMapping("/mongo-consumos/{id}/edit/save")
    public String consumoEditarGuardar(Model model, @PathVariable("id") Integer id,
                                       @ModelAttribute Consumo consumo) {
        try {
            consumoRepository.save(consumo);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-consumos";
    }

    @GetMapping("/mongo-consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") Integer id) {
        consumoRepository.deleteById(id);
        return "redirect:/mongo-consumos";
    }
}
