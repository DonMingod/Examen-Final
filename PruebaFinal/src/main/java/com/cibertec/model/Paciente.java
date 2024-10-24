package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;



@Entity
@Table(name="Paciente")

public class Paciente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id; 
	private String nombre ; 
	private String apellido;
	private String direccion;
	private String numero;
	
	
	  @Override
	    public String toString() {
	        return "Paciente [id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", numero=" + numero + "]";
	    }
	  public int getId() {
			return Id;
		}
	
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	
	
	
	
	

}
