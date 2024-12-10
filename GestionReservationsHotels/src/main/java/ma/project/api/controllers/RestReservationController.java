package ma.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.api.entities.Reservation;
import ma.project.api.repositories.ReservationRepository;

@RestController
@RequestMapping("/reservation")
public class RestReservationController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@GetMapping("/reservations")
	public List<Reservation> getAllReservations(){
		return reservationRepository.findAll();
	}
	
	@GetMapping("/reservation/{id}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable Long id){
		return reservationRepository.findById(id)
				.map(reservation ->ResponseEntity.ok().body(reservation))
				.orElse(ResponseEntity.notFound().build());
	}
}
