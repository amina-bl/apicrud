package ma.project.api.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
    @XmlTransient
	private Client client;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne
    @XmlTransient
	private Chambre chambre;
	
	private String preferences;

    @XmlElement(name = "clientId")
    public Long getClientId() {
        return client != null ? client.getId() : null;
    }

    @XmlElement(name = "chambreId")
    public Long getChambreId() {
        return chambre != null ? chambre.getId() : null;
    }

    @XmlElement(name = "clientId")
    public void setClientId(Long idclinet) {
         client.setId(idclinet);
    }

    @XmlElement(name = "chambreId")
    public void setChambreId(Long idChambre) {
    	chambre.setId(idChambre);
    }
    @Override
    public String toString() {
        return "Reservation{" +
               "id=" + id +
               ", dateDebut=" + dateDebut +
               ", dateFin=" + dateFin +
               ", preferences='" + preferences + '\'' +
               ", clientId=" + getClientId() +
               ", chambreId=" + getChambreId() +
               '}';
    }
}
