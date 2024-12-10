package ma.project.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.project.api.entities.Utilisateur;



public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
