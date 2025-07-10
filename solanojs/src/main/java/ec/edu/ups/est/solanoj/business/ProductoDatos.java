package ec.edu.ups.est.solanoj.business;
//
import ec.edu.ups.est.solanojs.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Singleton
@Startup
public class ProductoDatos {

	
	@PersistenceContext
    private EntityManager em;
	
	@PostConstruct
	@Transactional
	public void init() {
		if(em.find(Producto.class, "tv")==null) {
			Producto p1 = new Producto();
			p1.setCodigo("1");
			p1.setNombre("tv");
			p1.setCategoria("electronico");
			p1.setStock(10);
			em.persist(p1);
		}
		
		if(em.find(Producto.class, "celular")==null) {
			Producto p2 = new Producto();
			p2.setCodigo("2");
			p2.setNombre("celular");
			p2.setCategoria("electronico");
			p2.setStock(5);
			em.persist(p2);
		}
		
		if(em.find(Producto.class, "camisa")==null) {
			Producto p3 = new Producto();
			p3.setCodigo("3");
			p3.setNombre("camisa");
			p3.setCategoria("ropa");
			p3.setStock(15);
			em.persist(p3);
		}
		
		if(em.find(Producto.class, "zapatos")==null) {
			Producto p4 = new Producto();
			p4.setCodigo("4");
			p4.setNombre("zapatos");
			p4.setCategoria("ropa");
			p4.setStock(3);
			em.persist(p4);
		}
	}
}
