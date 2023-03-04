package pe.todotic.demoSpringBootS3.service;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;



import pe.todotic.demoSpringBootS3.model.usuarios;

import pe.todotic.demoSpringBootS3.model.vm.Asset;
import pe.todotic.demoSpringBootS3.respository.CursoRepository;
import pe.todotic.demoSpringBootS3.respository.UsuarioRepository;

@Service
public class UserService implements UserServiceImp {
	private final static String Bucket = "renatos3bucket";
	
	
	@Autowired
	private AmazonS3Client s3Client;
	
	@Autowired
	private UsuarioRepository usuarioC;
	
	@Autowired
	private UsuarioRepository usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<usuarios> findAll() {
		
		return usuarioC.findAll();
	}

	@Override
	public Page<usuarios> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<usuarios>) usuarioC.findAll((Sort) pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<usuarios> findById(Integer id) {
		
		return usuarioC.findById(id);
	}


	@Override
	public usuarios save(usuarios usuario) {
		return usuarioC.save(usuario);
	}


	@Override
	public void deleteById(Integer id) {
		usuarioC.deleteById(id);
		
	}

	
	@Override
	public usuarios findById(int id) {
		
		return usuarioC.findById(id).orElse(null);
	}

	/*@Override
	public Optional<libros> findByLibro(String libro) {
		return libroC.findById());
	}*/

	



}
