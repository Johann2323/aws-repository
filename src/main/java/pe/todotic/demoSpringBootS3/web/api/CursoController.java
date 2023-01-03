package pe.todotic.demoSpringBootS3.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.todotic.demoSpringBootS3.model.Curso;
import pe.todotic.demoSpringBootS3.respository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	List<Curso> getAll(){
		return cursoRepository.findAll();
	}
	
	@PostMapping
	Curso create(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
}
