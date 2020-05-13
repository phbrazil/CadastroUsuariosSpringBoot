package com.example.Controller;

import com.example.DAO.AddUsuarioDAO;
import com.example.DAO.DeleteUsuarioDAO;
import com.example.DAO.GetUsuarioDAO;
import com.example.DAO.ListUsuariosDAO;
import com.example.DAO.UpdateUsuarioDAO;
import com.example.Model.usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    //  @Autowired
//    private usuario dao;
    @GetMapping("/list")
    public String listUsuarios(Model usuarios, Model usuario, 
            @ModelAttribute("result") String result,
            @ModelAttribute("user") String user) {
        
        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listUsuarios = list.List();

        usuarios.addAttribute("usuarios", listUsuarios);
        usuarios.addAttribute("usuario", new usuario());
        return "listaUsuarios";
    }

    @GetMapping("/")
    public String usuarioForm(Model usuario) {

        usuario.addAttribute("usuario", new usuario());

        return "index";
    }

    @PostMapping("/AddUsuario")
    public String usuarioSubmit(@ModelAttribute usuario usuario, Model usuarios,
            RedirectAttributes redirectAttrs) {

        AddUsuarioDAO add = new AddUsuarioDAO();

        String dataCadastro = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        usuario.setDataCadastro(dataCadastro);

        int id = add.addUsuario(usuario);

        if (id > 0) {
            redirectAttrs.addAttribute("result", "userAdded");
            redirectAttrs.addAttribute("user", usuario.getUsername());

        } else {
            redirectAttrs.addAttribute("result", "failedAdded");
            redirectAttrs.addAttribute("user", usuario.getUsername());

        }

        //return "listaUsuarios";
        return "redirect:list";
    }

    @PostMapping("/deleteUsuario")
    public String deleteUsuario(@ModelAttribute usuario usuario, Model usuarios) {

        GetUsuarioDAO get = new GetUsuarioDAO();

        usuario = get.getUsuario(usuario.getId());

        DeleteUsuarioDAO delete = new DeleteUsuarioDAO();

        delete.deleteUsuario(usuario);

        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listUsuarios = list.List();

        usuarios.addAttribute("result", "userDeleted");

        usuarios.addAttribute("usuarios", listUsuarios);

        return "listaUsuarios";
    }

    @PostMapping("/editUsuario")
    public String editUsuario(@ModelAttribute usuario usuario, Model usuarios) {

        UpdateUsuarioDAO update = new UpdateUsuarioDAO();

        update.updateUsuario(usuario);

        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listUsuarios = list.List();

        usuarios.addAttribute("result", "userUpdated");

        usuarios.addAttribute("usuarios", listUsuarios);

        return "listaUsuarios";
    }

}
