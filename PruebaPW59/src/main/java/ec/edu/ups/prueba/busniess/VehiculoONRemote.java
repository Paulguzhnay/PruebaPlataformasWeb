package ec.edu.ups.prueba.busniess;

import java.util.List;

import ec.edu.ups.prueba.model.Vehiculo;

public interface VehiculoONRemote {
	
	public void insertar(Vehiculo  p) throws Exception  ;
	
	public List <Vehiculo> getVehiculos();
	
	public Vehiculo obtenerDatosCliente(String placa) ;
	
}
