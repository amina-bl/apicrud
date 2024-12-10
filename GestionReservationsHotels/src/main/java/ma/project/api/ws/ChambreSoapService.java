package ma.project.api.ws;


import ma.project.api.dto.ChambreRequest;
import ma.project.api.entities.Chambre;
import ma.project.api.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@Service
@WebService(serviceName = "ChambreSoapService")
public class ChambreSoapService {

    @Autowired
    private ChambreRepository chambreRepository;

    public Chambre createChambre(ChambreRequest request) {
        Chambre chambre = new Chambre();
        chambre.setType(request.getType());
        chambre.setPrix(request.getPrix());
        chambre.setDisponible(request.isDisponible());
        return chambreRepository.save(chambre);
    }

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    public Chambre updateChambre(Long id, ChambreRequest request) {
        return chambreRepository.findById(id).map(chambre -> {
            chambre.setType(request.getType());
            chambre.setPrix(request.getPrix());
            chambre.setDisponible(request.isDisponible());
            return chambreRepository.save(chambre);
        }).orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}
