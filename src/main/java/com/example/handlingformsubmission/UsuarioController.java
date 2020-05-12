package com.example.handlingformsubmission;

import com.example.DAO.tarefas.AddUsuarioDAO;
import com.example.DAO.tarefas.ConcluirUsuarioDAO;
import com.example.DAO.tarefas.DeleteUsuarioDAO;
import com.example.DAO.tarefas.GetUsuarioDAO;
import com.example.DAO.tarefas.ListUsuariosDAO;
import com.example.DAO.tarefas.UpdateUsuarioDAO;
import com.example.Model.usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
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
    public String listTarefas(Model usuarios, Model usuario) {

        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listTarefas = list.List();

        usuarios.addAttribute("usuarios", listTarefas);
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

        String dataCadastro = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());

        usuario.setDataCadastro(dataCadastro);

        int id = add.addUsuario(usuario);

        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listUsuarios = list.List();

        if (id > 0) {
            usuarios.addAttribute("result", "userAdded");
            usuarios.addAttribute("usuarios", listUsuarios);

        } else {
            usuarios.addAttribute("result", "failedAdded");
            usuarios.addAttribute("usuarios", listUsuarios);

        }

        //return "listaUsuarios";
        return "redirect:list";
    }

    @PostMapping("/deleteUsuario")
    public String deleteUsuario(@ModelAttribute usuario usuario, Model usuarios) {

        //PEGAR A TAREFA NO BANCO PELO ID
        GetUsuarioDAO get = new GetUsuarioDAO();

        usuario = get.getUsuario(usuario.getId());

        // DELETAR A TAREFA
        DeleteUsuarioDAO delete = new DeleteUsuarioDAO();

        delete.deleteUsuario(usuario);

        //BUSCAR LISTA ATUALIZADA        
        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listTarefas = list.List();

        usuarios.addAttribute("result", "userDeleted");

        usuarios.addAttribute("usuarios", listTarefas);

        return "listaUsuarios";
    }

    @PostMapping("/editUsuario")
    public String editUsuario(@ModelAttribute usuario usuario, Model usuarios) {

        UpdateUsuarioDAO update = new UpdateUsuarioDAO();

        update.updateUsuario(usuario);

        //BUSCAR LISTA ATUALIZADA        
        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listUsuarios = list.List();

        usuarios.addAttribute("result", "userUpdated");

        usuarios.addAttribute("usuarios", listUsuarios);

        return "listaUsuarios";
    }

}
