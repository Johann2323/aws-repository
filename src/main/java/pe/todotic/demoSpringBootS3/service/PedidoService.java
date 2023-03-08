package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.todotic.demoSpringBootS3.model.pedido;
import pe.todotic.demoSpringBootS3.model.usuarios;
import pe.todotic.demoSpringBootS3.respository.PedidoRepository;

@Service
public class PedidoService implements PedidoServiceImp{

	@Autowired
	private PedidoRepository pedidoR;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<pedido> finAll() {
		// TODO Auto-generated method stub
		return pedidoR.findAll();
	}

	@Override
	public Page<pedido> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<pedido>) pedidoR.findAll((Sort) pageable);
	}

	@Override
		public Optional<pedido> findById(Integer id) {
		// TODO Auto-generated method stub
		return pedidoR.findById(id);
	}

	@Override
	public pedido save(pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoR.save(pedido);
	}

	@Override
	public void deleteById(Integer id) {
		pedidoR.deleteById(id);
		
	}

	@Override
	public pedido findById(int id) {
		// TODO Auto-generated method stub
		return pedidoR.findById(id).orElse(null);
	}

	

}
