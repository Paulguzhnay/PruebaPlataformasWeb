package ec.edu.ups.prueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Vehiculo")
public class Vehiculo {
	@Id
	@Column(name = "veh_placa")
	private String placa;
	@Column(name = "veh_marca")
	private String marca;
	@Column(name = "veh_modelo")
	private String modelo;
	@Column(name = "veh_numPuertas")
	private int numeroPuertas;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNumeroPuertas() {
		return numeroPuertas;
	}
	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	
	
	
	
}
