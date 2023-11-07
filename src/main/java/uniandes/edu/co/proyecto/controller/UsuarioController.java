package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

@Controller
public class UsuarioController{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model){
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("tiposusuario_nombre", tipoUsuarioRepository.darTiposUsuario());
            model.addAttribute("planesconsumo_nombre", planConsumoRepository.darPlanesConsumo());
        return "usuarioNuevo";
    }


    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(
            usuario.getNumero_documento(), usuario.getTipo_Documento(), usuario.getEmail(), usuario.getNombre(), usuario.getFechaEntrada(), usuario.getFechaSalida(), usuario.getTipoUsuario().getNombre(), usuario.getPlanConsumo().getNombre());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{numero_documento}/edit")
    public String usuarioEditarForm(@PathVariable("numero_documento") Integer numero_documento, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(numero_documento);
        if(usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("tipo_documento", usuario.getTipo_Documento());
            model.addAttribute("email", usuario.getEmail());
            model.addAttribute("nombre", usuario.getNombre());
            model.addAttribute("fecha_entrada", usuario.getFechaEntrada());
            model.addAttribute("fecha_salida", usuario.getFechaSalida());
            model.addAttribute("tiposusuario_nombre", tipoUsuarioRepository.darTiposUsuario());
            model.addAttribute("planesconsumo_nombre", planConsumoRepository.darPlanesConsumo());
            return "usuarioEditar";
        
        }
        else {
            return "redirect:/usuarios";
        }

    }


    @PostMapping("/usuarios/{numero_documento}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("numero_documento") Integer numero_documento, @ModelAttribute Usuario usuario){
        usuarioRepository.actualizarUsuario(numero_documento, usuario.getTipo_Documento(), usuario.getEmail(), usuario.getNombre(), usuario.getFechaEntrada(), usuario.getFechaSalida(), usuario.getTipoUsuario().getNombre(), usuario.getPlanConsumo().getNombre());
        return "redirect:/usuarios";
    }


    @GetMapping("/usuarios/{numero_documento}/delete")
    public String usuarioBorrar(@PathVariable("numero_documento") Integer numero_documento) {
        usuarioRepository.eliminarUsuario(numero_documento);
        return "redirect:/usuarios";
    }
    
}
