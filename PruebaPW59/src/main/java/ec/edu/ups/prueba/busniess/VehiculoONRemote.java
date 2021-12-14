package ec.edu.ups.prueba.busniess;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.prueba.model.Vehiculo;

@Remote
public interface VehiculoONRemote {
	
	public void insertar(Vehiculo  p) throws Exception  ;
	
	public List <Vehiculo> getVehiculos();
	
	public Vehiculo obtenerDatosCliente(String placa) ;
	public void update (Vehiculo p);
	
}
