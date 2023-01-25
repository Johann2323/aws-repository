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


import pe.todotic.demoSpringBootS3.model.libros;
import pe.todotic.demoSpringBootS3.model.vm.Asset;
import pe.todotic.demoSpringBootS3.respository.CursoRepository;

@Service
public class S3Service implements CursoService {
	private final static String Bucket = "renatos3bucket";
	
	
	@Autowired
	private AmazonS3Client s3Client;
	
	@Autowired
	private CursoRepository libroC;
	
	@Autowired
	private CursoRepository libroDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<libros> findAll() {
		
		return libroC.findAll();
	}

	@Override
	public Page<libros> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<libros>) libroC.findAll((Sort) pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<libros> findById(Integer id) {
		
		return libroC.findById(id);
	}


	@Override
	public libros save(libros libro) {
		return libroC.save(libro);
	}


	@Override
	public void deleteById(Integer id) {
		libroC.deleteById(id);
		
	}

	
	@Override
	public libros findById(int id) {
		
		return libroC.findById(id).orElse(null);
	}

	/*@Override
	public Optional<libros> findByLibro(String libro) {
		return libroC.findById());
	}*/

	
	
	public String putObject(MultipartFile multipartField) {
		String extensions = StringUtils.getFilenameExtension(multipartField.getOriginalFilename());
		String key = String.format("%s.%s", UUID.randomUUID(), extensions);
		
		
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType(multipartField.getContentType());
		
		try {
			PutObjectRequest putObjectRequest = new PutObjectRequest(Bucket, key, multipartField.getInputStream(), objectMetadata);

					s3Client.putObject(putObjectRequest);
					return key;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public Asset getObject(String key) {
		S3Object s3Object = s3Client.getObject(Bucket, key);
		ObjectMetadata metadata = s3Object.getObjectMetadata();
		
		try {
			S3ObjectInputStream inputStream = s3Object.getObjectContent();
			byte[] bytes = IOUtils.toByteArray(inputStream);
			
			return new Asset(bytes, metadata.getContentType());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void deleteObject(String key) {
		s3Client.deleteObject(Bucket, key);
	}
	
	public String getObjectUrl(String key) {
		return String.format("https://%s.s3.amazonaws.com/%s", Bucket, key);
	}

	



}
