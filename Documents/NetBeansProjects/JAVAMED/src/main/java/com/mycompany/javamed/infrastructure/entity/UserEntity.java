package com.mycompany.javamed.infrastructure.entity;

import com.mycompany.javamed.domain.model.User;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;

    private Integer tipoId; // Nuevo atributo para diferenciar roles en la BD

    public UserEntity() {}

    public UserEntity(Integer id, String nombre, String apellido1, String apellido2, String dni, String email, String telefono, LocalDate fechaRegistro, Integer tipoId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.tipoId = tipoId;
    }

    public String getNombreCompleto() {
        return String.format("%s %s %s", nombre, apellido1, apellido2).trim();
    }

    // Método para convertir la entidad en el modelo de dominio
    public User toDomain() {
        return new User(id, getNombreCompleto(), dni, email, telefono, fechaRegistro, tipoId);
    }

    // Método para convertir el modelo de dominio en entidad
    public static UserEntity fromDomain(User usuario) {
        return new UserEntity(usuario.getId(), usuario.getNombre(), "", "", usuario.getDni(),
                                 usuario.getEmail(), usuario.getTelefono(), usuario.getFechaRegistro(),
                                 usuario.getTipoId());
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Integer getTipoId() { return tipoId; }
    public void setTipoId(Integer tipoId) { this.tipoId = tipoId; }
}
