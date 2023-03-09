package pe.todotic.demoSpringBootS3.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.todotic.demoSpringBootS3.model.compra;

@Repository
public interface CompraRepository extends JpaRepository<compra, Integer>{

}
