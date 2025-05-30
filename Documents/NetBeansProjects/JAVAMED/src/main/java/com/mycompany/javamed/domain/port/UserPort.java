package com.mycompany.javamed.domain.port;

import com.mycompany.javamed.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserPort {
    
    Optional<User> obtenerPorId(Integer id); // Usamos Optional para evitar null
    List<User> obtenerTodos();
    void guardarUsuario(User usuario);

    Optional<User> obtenerPorDni(String dni); // Nuevo método para buscar por DNI
    List<User> obtenerPorTipoId(Integer tipoId); // Nuevo método para filtrar por tipo
}
