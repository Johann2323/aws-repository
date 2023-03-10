package pe.todotic.demoSpringBootS3.model;

import java.util.Date;

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
public class libros {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NonNull
	private String titulo;
	private String autor;
	
	private String editorial;
	private double precio;
	private int stock;
	
	private String descripcion;
	private String categoria;
	private String imagenPhat;
	@Transient
	private String imagenURL;
	
	private String imagenpost;
	@Transient
	private String imagenget;
	
	private Date fechacreacion;
	
	
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagenPhat() {
		return imagenPhat;
	}
	public void setImagenPhat(String imagenPhat) {
		this.imagenPhat = imagenPhat;
	}
	public String getImagenURL() {
		return imagenURL;
	}
	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getImagenpost() {
		return imagenpost;
	}
	public void setImagenpost(String imagenpost) {
		this.imagenpost = imagenpost;
	}
	public String getImagenget() {
		return imagenget;
	}
	public void setImagenget(String imagenget) {
		this.imagenget = imagenget;
	}
	public Date getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	
	
	
	
	
	
}
