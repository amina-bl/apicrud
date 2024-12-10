package ma.project.api.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TypeChambre type;
    private double prix;
    private boolean disponible;
    
    @OneToMany(mappedBy = "chambre", fetch = FetchType.EAGER)
    @XmlTransient
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "Chambre{" +
               "id=" + id +
               ", type=" + type +
               ", prix=" + prix +
               ", disponible=" + disponible +
               '}';
    }
}