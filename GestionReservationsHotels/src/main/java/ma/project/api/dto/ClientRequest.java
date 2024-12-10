package ma.project.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
	
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
}
