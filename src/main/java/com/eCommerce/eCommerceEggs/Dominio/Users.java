package com.eCommerce.eCommerceEggs.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long idUsuario;

    private String username;

    private String password;

    private String email;

    private String tel;

    private String type;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Roles> roles;

    public Users() {
    }


    public Users(Long idUsuario, String username, String password, String email, String tel, String type, List<Roles> roles) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.type = type;
        this.roles = roles;
    }


    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Roles> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
    
}
