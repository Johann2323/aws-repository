package pe.todotic.demoSpringBootS3.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.todotic.demoSpringBootS3.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
