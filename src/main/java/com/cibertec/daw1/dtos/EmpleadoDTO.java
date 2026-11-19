package com.cibertec.daw1.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmpleadoDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100, message = "El apellido no debe exceder los 100 caracteres")
    private String apellido;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    @Size(max = 150, message = "El email no debe exceder los 150 caracteres")
    private String email;

    @Size(max = 100, message = "La especialidad no debe exceder los 100 caracteres")
    private String especialidad;

    public EmpleadoDTO() {
    }

    private EmpleadoDTO(Builder builder) {
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

        public EmpleadoDTO build() {
            return new EmpleadoDTO(this);
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