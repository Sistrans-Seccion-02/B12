package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.Cliente;
import uniandes.edu.co.proyecto.modeloMongo.Consumo;
import uniandes.edu.co.proyecto.modeloMongo.Habitacion;
import uniandes.edu.co.proyecto.modeloMongo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/mongo-reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reserva";
    }

    @GetMapping("/mongo-reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "reservaNuevo";
    }

    @PostMapping("/mongo-reservas/new/save")
    public String reservaGuardar(Model model, @ModelAttribute Reserva reserva) {
        try {
            reservaRepository.save(reserva);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar la reserva. No cumple la validación :(");
        }
        return "redirect:/mongo-reservas";
    }

    @GetMapping("/mongo-reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") String id, Model model) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("clientes", clienteRepository.findAll());
            model.addAttribute("habitaciones", habitacionRepository.findAll());
            return "reservaEditar";
        } else {
            return "redirect:/mongo-reservas";
        }
    }

    @PostMapping("/mongo-reservas/{id}/edit/save")
    public String reservaEditarGuardar(Model model, @PathVariable("id") String id,
                                       @ModelAttribute Reserva reserva) {
        try {
            reservaRepository.save(reserva);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-reservas";
    }

    @GetMapping("/mongo-reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") String id) {
        reservaRepository.deleteById(id);
        return "redirect:/mongo-reservas";
    }
}
