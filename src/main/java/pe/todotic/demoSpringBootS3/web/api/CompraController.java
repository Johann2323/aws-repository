package pe.todotic.demoSpringBootS3.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.todotic.demoSpringBootS3.model.compra;
import pe.todotic.demoSpringBootS3.model.usuarios;
import pe.todotic.demoSpringBootS3.respository.CompraRepository;
import pe.todotic.demoSpringBootS3.service.CompraService;

@RestController
@RequestMapping("/api/compra")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private CompraService compraService;
	
	@GetMapping("/getcompra")
	List<compra> getAll(){
		return compraRepository.findAll();
	}
	
	@PostMapping("/crearcompra")
	@ResponseStatus(HttpStatus.CREATED)
	compra create(@RequestBody compra compras) {
		compraRepository.save(compras);
		 return compras;
	}
	
	@PutMapping("/editarcompra/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public compra editar(@RequestBody compra compras, @PathVariable int id) {
		compra compraactual = compraService.findById(id);
		compraactual.setFecha_compra(compras.getFecha_compra());
		compraactual.setEstado(compras.getEstado());
		compraactual.setTotal(compras.getTotal());
		compraactual.setMetodo_pago(compras.getMetodo_pago());
		return compraService.save(compraactual);
	}
	
	@GetMapping ("/buscarcompra/{id}")
	public compra show(@PathVariable int id) {
		return compraService.findById(id);
	}
	
	@DeleteMapping("/eliminarcompra/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void eliminar(@PathVariable int id) {
		compraService.deleteById(id);
	}
	
	
	
	
}
