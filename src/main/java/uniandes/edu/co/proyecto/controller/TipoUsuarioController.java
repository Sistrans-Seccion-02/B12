package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController{

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposusuario")
    public String tiposUsuario(Model model){
        model.addAttribute("tiposusuario", tipoUsuarioRepository.darTiposUsuario());
        return "tiposusuario";
    }

    @GetMapping("/tiposusuario/new")
    public String tipoUsuarioForm(Model model){
        model.addAttribute("tipousuario", new TipoUsuario());
        return "tipousuarioNuevo";
    }

    @PostMapping("/tiposusuario/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario){
        tipoUsuarioRepository.insertarTipoUsuario(
            tipoUsuario.getNombre(), tipoUsuario.getDescripcion());
        return "redirect:/tiposusuario";
    }

    @GetMapping("/tiposusuario/{nombre}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("nombre") String nombre, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(nombre);
        if(tipoUsuario != null) {
            model.addAttribute("tipousuario", tipoUsuario);
            return "tipousuarioEditar";
        
        }
        else {
            return "redirect:/tiposusuario";
        }

    }

        @PostMapping("/tiposusuario/{nombre}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute TipoUsuario tipousuario){
        tipoUsuarioRepository.actualizarTipoUsuario(nombre, tipousuario.getDescripcion());
        return "redirect:/tiposusuario";
    }

    @GetMapping("/tiposusuario/{nombre}/delete")
    public String tipoUsuarioBorrar(@PathVariable("nombre") String nombre) {
        tipoUsuarioRepository.eliminarTipoUsuario(nombre);
        return "redirect:/tiposusuario";
    }
}
