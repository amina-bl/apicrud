package ma.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ma.project.api.entities.Client;
import ma.project.api.repositories.ClientRepository;

@RestController
@RequestMapping("/client")
public class RestClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
}
