package ec.edu.ups.prueba.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.prueba.model.Vehiculo;
@Stateless
public class vehiculoDAO {

	@PersistenceContext
	private EntityManager em;
	public void insert(Vehiculo op) {
		System.out.println(op);
		em.persist(op);
	}
	
	public void update (Vehiculo op) {
		em.merge(op);
	}
	
	public Vehiculo read(String id) {
		System.out.println(id);
		Vehiculo op=em.find(Vehiculo.class,id);
		System.out.println(op);
		return op;
	}

	public void delete (String id) {
		Vehiculo op = em.find(Vehiculo.class, id);
		em.remove(op);
	}
	
	public List <Vehiculo> getList(){
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		
		String jpql ="SELECT op FROM Vehiculo op ";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		//JPQL -> SQL 
		
		
		return listado;
	}
}

