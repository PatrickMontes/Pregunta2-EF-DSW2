package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Facultad;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Integer> {
}
