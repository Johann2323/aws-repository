package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;


import pe.todotic.demoSpringBootS3.model.usuarios;

public interface UserServiceImp {
	public Iterable<usuarios> findAll();
	public Page<usuarios> findAll(Pageable pageable);
	public Optional<usuarios> findById(Integer id);
	public usuarios save(usuarios usuario);
	public void deleteById(Integer id);
	public usuarios findById(int id);


	/*Optional<libros> findByLibro(String libro);*/
}
