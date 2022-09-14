package pe.edu.galaxy.training.java.api.demo.productos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.api.demo.productos.entity.Calificacion;

@Repository
public interface CalificacionRepository extends CassandraRepository<Calificacion, UUID>{
	
	@Query("select CALIFICACION_ID,MEDICO_ID,VALOR,FECHA  from Calificacion where MEDICO_ID =:medicoId ALLOW FILTERING") // CQL
	List<Calificacion> findByMedicoId(@Param("medicoId") Integer medicoId);
	
}
