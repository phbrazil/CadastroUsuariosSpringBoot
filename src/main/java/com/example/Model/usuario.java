/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String nome;
    private String password;
    private boolean status;
    private boolean admin;
    private boolean papel1;
    private boolean papel2;
    private boolean papel3;
    private String dataCadastro;

    public usuario() {

    }

    public usuario(Integer id, String username, String nome, String password,
            boolean status, boolean admin, boolean papel1, boolean papel2, boolean papel3,
            String dataCadastro) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.password = password;
        this.status = status;
        this.admin = admin;
        this.papel1 = papel1;
        this.papel2 = papel2;
        this.papel3 = papel3;
        this.dataCadastro = dataCadastro;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isPapel1() {
        return papel1;
    }

    public void setPapel1(boolean papel1) {
        this.papel1 = papel1;
    }

    public boolean isPapel2() {
        return papel2;
    }

    public void setPapel2(boolean papel2) {
        this.papel2 = papel2;
    }

    public boolean isPapel3() {
        return papel3;
    }

    public void setPapel3(boolean papel3) {
        this.papel3 = papel3;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof usuario)) {
            return false;
        }
        usuario other = (usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.usuario[ id=" + id + " ]";
    }

}
