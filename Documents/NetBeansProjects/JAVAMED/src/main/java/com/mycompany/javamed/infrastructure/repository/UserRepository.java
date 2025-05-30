package com.mycompany.javamed.infrastructure.repository;

import com.mycompany.javamed.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
    Optional<UserEntity> findByDni(String dni); // Usa Optional para evitar null

    List<UserEntity> findByDatosBancariosIsNotNull();

    List<UserEntity> findByTipoId(Integer tipoId); // Nuevo método para buscar por tipo de usuario
}
