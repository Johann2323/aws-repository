package pe.todotic.demoSpringBootS3.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.todotic.demoSpringBootS3.model.libros;

@Repository
public interface CursoRepository extends JpaRepository<libros, Integer> {
	List<libros> findByTituloContains(String titulo);
	
}
