package pe.todotic.demoSpringBootS3.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.todotic.demoSpringBootS3.model.pedido;
import pe.todotic.demoSpringBootS3.model.usuarios;
import pe.todotic.demoSpringBootS3.respository.PedidoRepository;
import pe.todotic.demoSpringBootS3.respository.UsuarioRepository;
import pe.todotic.demoSpringBootS3.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PedidoController {

	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/crearpedido")
	@ResponseStatus(HttpStatus.CREATED)
	pedido create(@RequestBody pedido pedidos) {
		pedidoRepository.save(pedidos);
		return pedidos;
	}
	
	@GetMapping("/getpedido")
	List<pedido> getAll(){
		return pedidoRepository.findAll();
	}
	
	@PutMapping("/editarpedido/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public pedido editar(@RequestBody pedido pedidos, @PathVariable int id) {
		pedido pedidoactual = pedidoService.findById(id);
		pedidoactual.setDireccion_envio(pedidos.getDireccion_envio());
		pedidoactual.setEstado(pedidos.getEstado());
		pedidoactual.setFecha_pedido(pedidos.getFecha_pedido());
		pedidoactual.setTotal(pedidos.getTotal());
		
		return pedidoService.save(pedidoactual);
		
	}
	
	@GetMapping ("/buscarpedido/{id}")
	public pedido show(@PathVariable int id) {
		return pedidoService.findById(id);
		
	}
	
	@DeleteMapping("/eliminarpedido/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void eliminar(@PathVariable int id) {
		pedidoService.deleteById(id);
	}
	
	
}
