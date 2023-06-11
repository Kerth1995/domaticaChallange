package com.dimatica.HackerDetectorApi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column()
    private Integer id;

    @Column()
    private String ip;

    @Column()
    private String accion;

    @Column()
    private String username;

    @Column()
    private String token;

    @Column()
    private String fechaCreacion;

    public Login() {
    }

    public Login(String ip, String accion, String username, String token, String fechaCreacion) {
        this.ip = ip;
        this.accion = accion;
        this.username = username;
        this.token = token;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", accion='" + accion + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }
}
