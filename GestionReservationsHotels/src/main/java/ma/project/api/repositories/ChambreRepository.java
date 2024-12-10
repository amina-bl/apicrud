package ma.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.project.api.entities.Chambre;

@Repository

public interface ChambreRepository extends JpaRepository<Chambre, Long>{

}
