package pe.edu.galaxy.training.java.api.demo.productos.rest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.api.demo.productos.entity.Calificacion;
import pe.edu.galaxy.training.java.api.demo.productos.repository.CalificacionRepository;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionRest {

	@Autowired
	private CalificacionRepository  calificacionRepository;
	
	@GetMapping
	public ResponseEntity<?>  findAll(){
		return ResponseEntity.ok(calificacionRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>  findById(@PathVariable String id){
		return ResponseEntity.ok(calificacionRepository.findById(UUID.fromString(id)));
	}

	@GetMapping("/medico/{medicoId}")
	public ResponseEntity<?>  findByMedicoId(@PathVariable Integer medicoId){
		return ResponseEntity.ok(calificacionRepository.findByMedicoId(medicoId));
	}
	
	@PostMapping
	public ResponseEntity<?>  save(@RequestBody Calificacion producto){
		producto.setFecha(LocalDateTime.now());
		return ResponseEntity.ok(calificacionRepository.save(producto));
	}
}
