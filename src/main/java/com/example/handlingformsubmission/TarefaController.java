package com.example.handlingformsubmission;

import com.example.DAO.tarefas.AddUsuarioDAO;
import com.example.DAO.tarefas.ConcluirUsuarioDAO;
import com.example.DAO.tarefas.DeleteUsuarioDAO;
import com.example.DAO.tarefas.GetUsuarioDAO;
import com.example.DAO.tarefas.ListUsuariosDAO;
import com.example.DAO.tarefas.UpdateUsuarioDAO;
import com.example.Model.usuario;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TarefaController {

    @GetMapping("/list")
    public String listTarefas(Model tarefas, Model tarefa) {

        System.out.println("Listing");
        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listTarefas = list.List();

        tarefas.addAttribute("tarefas", listTarefas);
        tarefas.addAttribute("tarefa", new usuario());

        return "listaUsuarios";
    }

    @GetMapping("/")
    public String usuarioForm(Model usuario) {

        usuario.addAttribute("usuario", new usuario());
        
        return "index";
    }

    @PostMapping("/AddUsuario")
    public String tarefaSubmit(@ModelAttribute usuario tarefa, Model tarefas,
            RedirectAttributes redirectAttrs) {

        AddUsuarioDAO add = new AddUsuarioDAO();

        add.addTarefa(tarefa);

        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listTarefas = list.List();

        //redirectAttrs.addAttribute("tarefas", listTarefas);
        tarefas.addAttribute("result", "Nova tarefa adicionada");
        tarefas.addAttribute("tarefas", listTarefas);

        return "listaUsuarios";
        //return  "redirect:listaUsuarios";
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

        usuarios.addAttribute("result", "Usuario deletada");

        usuarios.addAttribute("usuarios", listTarefas);

        return "listaUsuarios";
    }

 
    @PostMapping("/editUsuario")
    public String editUsuario(@ModelAttribute usuario usuario, Model usuarios) {

        UpdateUsuarioDAO update = new UpdateUsuarioDAO();

        update.updateUsuario(usuario);

        //BUSCAR LISTA ATUALIZADA        
        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listTarefas = list.List();

        usuarios.addAttribute("result", "Usuario atualizado");

        usuarios.addAttribute("usuarios", listTarefas);

        return "listaUsuarios";
    }

    @PostMapping("/concluirTarefa")
    public String concluirTarefa(@ModelAttribute usuario tarefa, Model tarefas) {
        
        ConcluirUsuarioDAO concluir = new ConcluirUsuarioDAO();
        
        concluir.iniciarTarefa(tarefa.getId(), tarefa.getNota());
        
        
        //BUSCAR LISTA ATUALIZADA        
        ListUsuariosDAO list = new ListUsuariosDAO();

        List<usuario> listTarefas = list.List();

        tarefas.addAttribute("result", "Tarefa concluída");

        tarefas.addAttribute("tarefas", listTarefas);

        return "listaUsuarios";
    }

}
