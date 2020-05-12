/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DAO.tarefas;

import com.example.Model.usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author paulo.bezerra
 */
public class GetUsuarioDAO {
    
    public usuario getUsuario(int id){
        
                //indica as configuracoes do banco
        Configuration con = new Configuration().configure().addAnnotatedClass(usuario.class);
        SessionFactory sf = con.buildSessionFactory();

        //abre sessao com o banco
        Session session = sf.openSession();
        usuario usuarios;
        try {

            Transaction tx = session.beginTransaction();

            usuarios = (usuario) session.get(usuario.class, id);

            //comita as informacoes
            tx.commit();

        } finally {
            if (session != null) {
                session.close();
                sf.close();
            }

        }

        return usuarios;
    }
    
}
