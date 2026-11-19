package com.cibertec.daw1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "especialidad", nullable = true, length = 100)
    private String especialidad;

    public Empleados() {
    }

    private Empleados(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.email = builder.email;
        this.especialidad = builder.especialidad;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String nombre;
        private String apellido;
        private String email;
        private String especialidad;

        public Builder id(Integer id) { this.id = id; return this; }
        public Builder nombre(String nombre) { this.nombre = nombre; return this; }
        public Builder apellido(String apellido) { this.apellido = apellido; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder especialidad(String especialidad) { this.especialidad = especialidad; return this; }

        public Empleados build() {
            return new Empleados(this);
        }
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}