package ma.project.api.ws;

import ma.project.api.dto.*;
import ma.project.api.entities.Client;
import ma.project.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@Service
@WebService(serviceName = "ClientSoapService")
public class ClientSoapService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(ClientRequest request) {
        Client client = new Client();
        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setEmail(request.getEmail());
        client.setTelephone(request.getTelephone());
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client updateClient(Long id, ClientRequest request) {
        return clientRepository.findById(id).map(client -> {
            client.setNom(request.getNom());
            client.setPrenom(request.getPrenom());
            client.setEmail(request.getEmail());
            client.setTelephone(request.getTelephone());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
