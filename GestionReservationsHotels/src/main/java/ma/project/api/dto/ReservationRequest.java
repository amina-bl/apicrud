package ma.project.api.dto;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import ma.project.api.entities.Chambre;
import ma.project.api.entities.Client;

@Setter
@Getter
public class ReservationRequest {
	
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
    private String preferences;
    private Long clientId;
    private Long chambreId;
    
}
