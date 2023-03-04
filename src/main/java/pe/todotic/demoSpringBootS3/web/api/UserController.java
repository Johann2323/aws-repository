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
import pe.todotic.demoSpringBootS3.model.usuarios;
import pe.todotic.demoSpringBootS3.respository.CursoRepository;
import pe.todotic.demoSpringBootS3.respository.UsuarioRepository;
import pe.todotic.demoSpringBootS3.service.S3Service;
import pe.todotic.demoSpringBootS3.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

	
	@Autowired
	private UsuarioRepository cursoRepository;
	
	@Autowired
	private UserService s3Service;
	
	@GetMapping("/getusuarios")
	List<usuarios> getAll(){
		return cursoRepository.findAll();
				
	}
	
	@PostMapping("/crearusuario")
	@ResponseStatus(HttpStatus.CREATED)
	usuarios create(@RequestBody usuarios usuario) {
		 cursoRepository.save(usuario);
		 return usuario;
	}
	
	
	@PutMapping("/editarusuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public usuarios editar(@RequestBody usuarios usuario, @PathVariable int id) {
		usuarios usuarioactual = s3Service.findById(id);
		usuarioactual.setCedula(usuario.getCedula());
		usuarioactual.setNombre(usuario.getNombre());
		usuarioactual.setDireccion(usuario.getDireccion());
		usuarioactual.setCorreo(usuario.getCorreo());
		usuarioactual.setClave(usuario.getClave());
		usuarioactual.setRol(usuario.getRol());
		usuarioactual.setEstado(usuario.isEstado());
		System.out.println("Aquí"+usuarioactual.getId()+" "+ usuarioactual.getCorreo());
		return s3Service.save(usuarioactual);
		
	}
	
	@GetMapping ("/buscarusuario/{id}")
	public usuarios show(@PathVariable int id) {
		return s3Service.findById(id);
		
	}
	
	@DeleteMapping("/eliminarusuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void eliminar(@PathVariable int id) {
		s3Service.deleteById(id);
	}

	
	
}
