package pe.todotic.demoSpringBootS3.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.todotic.demoSpringBootS3.model.pedido;

public interface PedidoRepository extends JpaRepository<pedido, Integer>{

}
