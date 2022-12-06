package com.tucita.medicalteam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tucita.medicalteam.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
