package com.mycompany.javamed.domain.model;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String nombre;
    private String dni;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;
    private Integer tipoId; // Nuevo campo para diferenciar tipos de usuario
    private String iban;
    private String swift;
    private String numeroCuenta;

    public User() {}

    public User(Integer id, String nombre, String dni, String email, String telefono, LocalDate fechaRegistro, Integer tipoId) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.tipoId = tipoId;
    }

    // Métodos para identificar roles
    public boolean esPaciente() {
        return tipoId == 1; // Ejemplo: Paciente es tipoId = 1
    }

    public boolean esAdministrativo() {
        return tipoId == 2; // Ejemplo: Administrativo es tipoId = 2
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

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

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public String getSwift() { return swift; }
    public void setSwift(String swift) { this.swift = swift; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
}
