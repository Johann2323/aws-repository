package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.todotic.demoSpringBootS3.model.compra;
import pe.todotic.demoSpringBootS3.respository.CompraRepository;


@Service
public class CompraService implements CompraServiceImp{
	@Autowired
	private CompraRepository compraRe;

	@Override
	@Transactional(readOnly = true)
	public Iterable<compra> finAll() {
		// TODO Auto-generated method stub
		return compraRe.findAll();
	}

	@Override
	public Page<compra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<compra>) compraRe.findAll((Sort) pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<compra> findById(Integer id) {
		// TODO Auto-generated method stub
		return compraRe.findById(id);
	}

	@Override
	public compra findById(int id) {
		// TODO Auto-generated method stub
		return compraRe.findById(id).orElse(null);
	}

	@Override
	public compra save(compra compra) {
		// TODO Auto-generated method stub
		return compraRe.save(compra);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		compraRe.deleteById(id);
	}


	
}
