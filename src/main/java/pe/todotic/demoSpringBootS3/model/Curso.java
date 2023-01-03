package pe.todotic.demoSpringBootS3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Curso {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private String titulo;
	
	private String imagenPhat;
	
	@Transient
	private String ImagenURL;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagenPhat() {
		return imagenPhat;
	}

	public void setImagenPhat(String imagenPhat) {
		this.imagenPhat = imagenPhat;
	}

	public String getImagenURL() {
		return ImagenURL;
	}

	public void setImagenURL(String imagenURL) {
		ImagenURL = imagenURL;
	}
	
	
}
