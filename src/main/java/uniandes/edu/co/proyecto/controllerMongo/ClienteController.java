package uniandes.edu.co.proyecto.controllerMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modeloMongo.Cliente;
import uniandes.edu.co.proyecto.RepositorioMongo.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/mongo-clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "cliente";
    }

    @GetMapping("/mongo-clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "clienteNuevo";
    }

    @PostMapping("/mongo-clientes/new/save")
    public String clienteGuardar(Model model, @ModelAttribute Cliente cliente) {
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo guardar el cliente. No cumple la validación :(");
        }
        return "redirect:/mongo-clientes";
    }

    @GetMapping("/mongo-clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteRepository.buscarPorId(id).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("habitaciones", habitacionRepository.findAll());
            return "clienteEditar";
        } else {
            return "redirect:/mongo-clientes";
        }
    }

    @PostMapping("/mongo-clientes/{id}/edit/save")
    public String clienteEditarGuardar(Model model, @PathVariable("id") Integer id,
                                       @ModelAttribute Cliente cliente) {
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            model.addAttribute("error", "No se pudo actualizar. No cumple la validación :(");
        }
        return "redirect:/mongo-clientes";
    }

    @GetMapping("/mongo-clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") Integer id) {
        clienteRepository.deleteById(id);
        return "redirect:/mongo-clientes";
    }
}
