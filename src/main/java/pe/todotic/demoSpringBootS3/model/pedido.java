package pe.todotic.demoSpringBootS3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class pedido {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer id_usuario;
	private Integer id_libro;
	private Data fecha_pedido;
	private String estado;
	private String direccion_envio;
	private Integer total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_libro() {
		return id_libro;
	}
	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}
	public Data getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Data fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDireccion_envio() {
		return direccion_envio;
	}
	public void setDireccion_envio(String direccion_envio) {
		this.direccion_envio = direccion_envio;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	

}
