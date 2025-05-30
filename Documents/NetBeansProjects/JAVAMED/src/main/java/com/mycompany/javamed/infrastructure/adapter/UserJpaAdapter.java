package com.mycompany.javamed.infrastructure.adapter;

import com.mycompany.javamed.domain.model.User;
import com.mycompany.javamed.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.mycompany.javamed.domain.port.UserPort;
import com.mycompany.javamed.infrastructure.repository.UserRepository;

@Component
public class UserJpaAdapter implements UserPort {

    private final UserRepository usuarioRepository;

    public UserJpaAdapter(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<User> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(UserEntity::toDomain); // Devuelve Optional en lugar de null
    }

    @Override
    public List<User> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UserEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void guardarUsuario(User usuario) {
        UserEntity usuarioEntity = UserEntity.fromDomain(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    @Override
    public Optional<User> obtenerPorDni(String dni) {
        return usuarioRepository.findByDni(dni)
                .map(UserEntity::toDomain);
    }

    @Override
    public List<User> obtenerPorTipoId(Integer tipoId) {
        return usuarioRepository.findByTipoId(tipoId)
                .stream()
                .map(UserEntity::toDomain)
                .collect(Collectors.toList());
    }
}
