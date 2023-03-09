package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import pe.todotic.demoSpringBootS3.model.compra;

public interface CompraServiceImp {

	public Iterable<compra> finAll();
	public Page<compra> findAll(Pageable pageable);
	public Optional<compra> findById(Integer id);
	public compra save(compra compra);
	public void deleteById(Integer id);
	public compra findById(int id);
}
