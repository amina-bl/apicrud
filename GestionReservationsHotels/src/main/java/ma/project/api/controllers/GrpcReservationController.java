package ma.project.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ma.project.api.entities.Reservation;
import ma.project.api.repositories.ReservationRepository;

@RestController
@RequestMapping("/reservation")
public class GrpcReservationController {
    
	private ReservationRepository reservationRepository;
   
	// READ: Récupérer tous les reservations (JSON et XML)
	@GetMapping(value = "/reservations", produces = { "application/json", "application/xml" })
	    public List<Reservation> getAllReservations() {
	        return reservationRepository.findAll();
	    }
	

    // READ: Récupérer un reservation par son identifiant (JSON et XML)
    @GetMapping(value = "/reservations/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<Reservation> getCompteById(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(compte -> ResponseEntity.ok().body(compte))
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE: Ajouter un nouveau reservation (JSON et XML)
    @PostMapping(value = "/reservations", consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
    public Reservation createCompte(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // UPDATE: Mettre à jour un reservation existant (JSON et XML)
    @PutMapping(value = "/reservations/{id}", consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
    public ResponseEntity<Reservation> updateCompte(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                	reservation.setClientId(reservationDetails.getClientId());
                	reservation.setChambreId(reservationDetails.getChambreId());
                	reservation.setDateDebut(reservationDetails.getDateDebut());
                	reservation.setDateFin(reservationDetails.getDateFin());
                	reservation.setPreferences(reservationDetails.getPreferences());
                    Reservation updatedReservation = reservationRepository.save(reservation);
                    return ResponseEntity.ok().body(updatedReservation);
                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Supprimer un reservation
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(compte -> {
                	reservationRepository.delete(compte);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
