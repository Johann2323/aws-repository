package pe.todotic.demoSpringBootS3.web.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.todotic.demoSpringBootS3.model.libros;
import pe.todotic.demoSpringBootS3.respository.CursoRepository;
import pe.todotic.demoSpringBootS3.service.S3Service;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CursoController {

	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private S3Service s3Service;
	
	@GetMapping("/getlibros")
	List<libros> getAll(){
		return cursoRepository.findAll()
				.stream()
				.peek(curso -> curso.setImagenURL(s3Service.getObjectUrl(curso.getImagenPhat())))
				.peek(curso -> curso.setImagenget(s3Service.getObjectUrl(curso.getImagenpost())))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/crearlibro")
	@ResponseStatus(HttpStatus.CREATED)
	libros create(@RequestBody libros curso) {
		 cursoRepository.save(curso);
		 curso.setImagenURL(s3Service.getObjectUrl(curso.getImagenPhat()));
		 return curso;
	}
	
	
	@PutMapping("/editarLibro/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public libros editar(@RequestBody libros libro, @PathVariable int id) {
		libros libroactual = s3Service.findById(id);
		libroactual.setTitulo(libro.getTitulo());
		libroactual.setAutor(libro.getAutor());
		libroactual.setEditorial(libro.getEditorial());
		libroactual.setPrecio(libro.getPrecio());
		libroactual.setStock(libro.getStock());
		libroactual.setCategoria(libro.getCategoria());
		libroactual.setDescripcion(libro.getDescripcion());
		libroactual.setImagenPhat(libro.getImagenPhat());
		libroactual.setImagenURL(libro.getImagenURL());
		libroactual.setFechacreacion(libro.getFechacreacion());
		
		System.out.println("Aquí"+libroactual.getId()+" "+ libroactual.getAutor());
		return s3Service.save(libroactual);
		
	}
	
	@GetMapping ("/buscarid/{id}")
	public libros show(@PathVariable int id) {
		return s3Service.findById(id);
		
	}
	
	@GetMapping ("/buscarxnombre/{titulo}")
	public List<libros> show(@PathVariable String titulo) {
		return s3Service.findByTituloContains(titulo)
				.stream()
				.peek(curso -> curso.setImagenURL(s3Service.getObjectUrl(curso.getImagenPhat())))
				.peek(curso -> curso.setImagenget(s3Service.getObjectUrl(curso.getImagenpost())))
				.collect(Collectors.toList());
		
	}
	
	@DeleteMapping("/eliminarLibro/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void eliminar(@PathVariable int id) {
		s3Service.deleteById(id);
	}

	
	
}
