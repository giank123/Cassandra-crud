package pe.edu.galaxy.training.java.api.demo.productos.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.Data;

@Data
@Table(value = "CALIFICACION")
public class Calificacion {

	@PrimaryKey("CALIFICACION_ID")
	private UUID calificacionID= UUID.randomUUID();

	@Column("MEDICO_ID")
	private Integer medicoId;
	
	@Column("VALOR")
	private Integer valor;
	
	@Column("FECHA")
	private LocalDateTime fecha;
}
