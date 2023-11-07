package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller
public class PlanConsumoController{

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planesconsumo")
    public String planesconsumo(Model model){
        model.addAttribute("planesconsumo", planConsumoRepository.darPlanesConsumo());
        return "planesconsumo";
    }

    @GetMapping("/planesconsumo/new")
    public String planConsumoForm(Model model){
        model.addAttribute("planconsumo", new PlanConsumo());
        return "planconsumoNuevo";
    }

    @PostMapping("/planesconsumo/new/save")
    public String planConsumoGuardar(@ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.insertarPlanConsumo(
            planConsumo.getNombre(), planConsumo.getDescripcion());
        return "redirect:/planesconsumo";
    }

    @GetMapping("/planesconsumo/{nombre}/edit")
    public String planConsumoEditarForm(@PathVariable("nombre") String nombre, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo(nombre);
        if(planConsumo != null) {
            model.addAttribute("planconsumo", planConsumo);
            return "planconsumoEditar";
        
        }
        else {
            return "redirect:/planesconsumo";
        }

    }

    @PostMapping("/planesconsumo/{nombre}/edit/save")
    public String planConsumoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute PlanConsumo planConsumo){
        planConsumoRepository.actualizarPlanConsumo(nombre, planConsumo.getDescripcion());
        return "redirect:/planesconsumo";
    }

    @GetMapping("/planesconsumo/{nombre}/delete")
    public String planConsumoBorrar(@PathVariable("nombre") String nombre) {
        planConsumoRepository.eliminarPlanConsumo(nombre);
        return "redirect:/planesconsumo";
    }


}
