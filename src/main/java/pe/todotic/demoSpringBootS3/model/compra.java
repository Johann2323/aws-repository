package pe.todotic.demoSpringBootS3.model;

import java.util.Date;

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
public class compra {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer id_pedido;
	private Date fecha_compra;
	private String estado;
	private Integer total;
	private String metodo_pago;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	
	

}
