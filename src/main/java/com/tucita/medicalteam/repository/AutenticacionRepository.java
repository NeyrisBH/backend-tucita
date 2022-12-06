package com.tucita.medicalteam.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.tucita.medicalteam.model.Usuario;

@Repository
public interface AutenticacionRepository extends MongoRepository<Usuario, String> {
	@Query("{usuario: '?0', clave: '?1'}")
	Optional<Usuario> loginUsuario(String usuario, String clave);
}
