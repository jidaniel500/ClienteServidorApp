package org.clienteservidor.codigo;

import java.time.LocalDate;

public class Mensaje {

	private LocalDate fecha;
	private String contenido;

	public Mensaje(String contenido) {
		this.fecha = LocalDate.now();
		this.contenido = contenido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

}
