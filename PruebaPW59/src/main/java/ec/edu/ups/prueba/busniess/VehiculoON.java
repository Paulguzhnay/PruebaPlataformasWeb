package ec.edu.ups.prueba.busniess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.prueba.DAO.vehiculoDAO;
import ec.edu.ups.prueba.model.Vehiculo;
import ec.edu.ups.prueba.*;

@Stateless
public class VehiculoON implements VehiculoONRemote {

	@Inject
	private vehiculoDAO daoVehiculo;
	
	public void insertar(Vehiculo  p) throws Exception  {
		daoVehiculo.insert(p);
	}
	
	public List <Vehiculo> getVehiculos(){
		return daoVehiculo.getList();
	}
	
	public Vehiculo obtenerDatosCliente(String placa) {
		return daoVehiculo.read(placa);
	}
	
}
