package ec.esu.ups.est.solanoj.dao;


import java.util.List;

import ec.edu.ups.est.solanojs.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductoDAO {
	
	@PersistenceContext
    private EntityManager em;
	
	public List<Producto> getAll(){
		return em.createQuery("SELECT p FROM Producto p", Producto.class)
				.getResultList();
	}
	
	
	public List<Producto> buscar(String filtro, String valor){
		String sql= "SELECT p FROM Producto p WHERE";
		
		switch(filtro) {
			case "codigo" :
				sql += "LOWER(p.codigo) LIKE :val";
				break;
			case "nombre" :
				sql += "LOWER(p.nombre) LIKE :val";
				break;
			case "categoria" :
				sql += "LOWER(p.categoria) LIKE :val";
				break;
			default:
				sql = "SELECT p FROM Producto p WHERE" + "LOWER(p.codigo) LIKE :val OR" 
						+ "LOWER(p.nombre) LIKE :val OR" + "LOWER(p.categoria) LIKE :val";
				break;
			}
		return em.createQuery(sql, Producto.class).setParameter("val","%" + valor.toLowerCase() + "%" ).getResultList();
			
			
		
	}
	
	public List<Producto> buscarPorNombre(String nombre){
		String sql= "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:nombre";
		
		return em.createQuery(sql, Producto.class).setParameter("nombre","%" + nombre + "%" ).getResultList();
			
			
		
	}
	
	
	
}
