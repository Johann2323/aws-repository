package pe.todotic.demoSpringBootS3.web.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.todotic.demoSpringBootS3.model.Curso;
import pe.todotic.demoSpringBootS3.respository.CursoRepository;
import pe.todotic.demoSpringBootS3.service.S3Service;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CursoController {

	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private S3Service s3Service;
	
	@GetMapping
	List<Curso> getAll(){
		return cursoRepository.findAll()
				.stream()
				.peek(curso -> curso.setImagenURL(s3Service.getObjectUrl(curso.getImagenPhat())))
				.collect(Collectors.toList());
	}
	
	@PostMapping
	Curso create(@RequestBody Curso curso) {
		 cursoRepository.save(curso);
		 curso.setImagenURL(s3Service.getObjectUrl(curso.getImagenPhat()));
		 return curso;
	}
}
