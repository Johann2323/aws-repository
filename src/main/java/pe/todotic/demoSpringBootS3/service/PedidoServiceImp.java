package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import pe.todotic.demoSpringBootS3.model.pedido;

public interface PedidoServiceImp {

	public Iterable<pedido> finAll();
	public Page<pedido> findAll(Pageable pageable);
	public Optional<pedido> findById(Integer id);
	public pedido save(pedido pedido);
	public void deleteById(Integer id);
	public pedido findById(int id);
}
