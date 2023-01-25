package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;


import pe.todotic.demoSpringBootS3.model.libros;

public interface CursoService {
	public Iterable<libros> findAll();
	public Page<libros> findAll(Pageable pageable);
	public Optional<libros> findById(Integer id);
	public libros save(libros libro);
	public void deleteById(Integer id);
	public libros findById(int id);


	/*Optional<libros> findByLibro(String libro);*/
}
