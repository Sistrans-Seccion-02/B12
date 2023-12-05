package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.LLegadaSalida;
import uniandes.edu.co.proyecto.modeloMongo.Reserva;
import java.util.List;

@Controller
public class EntradaSalidaController {

    @Autowired
    private LLegadaSalidaRepository llegadaSalidaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/mongo-llegada-salidas")
    public String llegadaSalidas(Model model) {
        model.addAttribute("llegadaSalidas", llegadaSalidaRepository.findAll());
        return "llegadaSalida";
    }

    @GetMapping("/mongo-llegada-salidas/new")
    public String llegadaSalidaForm(Model model) {
        model.addAttribute("llegadaSalida", new LLegadaSalida());
        model.addAttribute("reservas", reservaRepository.findAll());
        return "llegadaSalidaNuevo";
    }

    @PostMapping("/mongo-llegada-salidas/new/save")
    public String llegadaSalidaGuardar(Model model, @ModelAttribute LLegadaSalida llegadaSalida) {
        try {
            llegadaSalidaRepository.save(llegadaSalida);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar la llegada/salida. No cumple la validación :(");
        }
        return "redirect:/mongo-llegada-salidas";
    }

    @GetMapping("/mongo-llegada-salidas/{id}/edit")
    public String llegadaSalidaEditarForm(@PathVariable("id") Integer id, Model model) {
        LLegadaSalida llegadaSalida = llegadaSalidaRepository.findById(id).orElse(null);
        if (llegadaSalida != null) {
            model.addAttribute("llegadaSalida", llegadaSalida);
            model.addAttribute("reservas", reservaRepository.findAll());
            return "llegadaSalidaEditar";
        } else {
            return "redirect:/mongo-llegada-salidas";
        }
    }

    @PostMapping("/mongo-llegada-salidas/{id}/edit/save")
    public String llegadaSalidaEditarGuardar(Model model, @PathVariable("id") Integer id,
                                             @ModelAttribute LLegadaSalida llegadaSalida) {
        try {
            llegadaSalidaRepository.save(llegadaSalida);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-llegada-salidas";
    }

    @GetMapping("/mongo-llegada-salidas/{id}/delete")
    public String llegadaSalidaEliminar(@PathVariable("id") Integer id) {
        llegadaSalidaRepository.deleteById(id);
        return "redirect:/mongo-llegada-salidas";
    }
}
