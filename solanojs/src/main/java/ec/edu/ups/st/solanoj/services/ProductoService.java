package ec.edu.ups.st.solanoj.services;

import java.util.List;

import ec.edu.ups.est.solanojs.Producto;

import ec.esu.ups.est.solanoj.dao.ProductoDAO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/productos")
@Produces(MediaType.APPLICATION_JSON) // Todas las respuestas son en formato JSON
@Consumes(MediaType.APPLICATION_JSON) 
public class ProductoService {
	
	@Inject
	private ProductoDAO productoDAO;
	
    @GET 
    public Response listar() {
        List<Producto> lista = productoDAO.getAll();
        return Response.ok(lista).build();                                                                
    }

    @GET 
    @Path("/buscar")
    public Response buscar(@QueryParam("filtro") String filtro, @QueryParam("valor") String valor) {
    	
        //if (valor==null) 
        	//return listar;
        
        List<Producto> resultado = productoDAO.buscar(filtro, valor);
        return Response.ok(resultado).build();
        	
    }

}
