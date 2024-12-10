package ma.project.api.dto;

import lombok.Getter;
import lombok.Setter;
import ma.project.api.entities.TypeChambre;
@Setter
@Getter
public class ChambreRequest {
	
	private TypeChambre type;
	private double prix;
	private boolean disponible;

}
