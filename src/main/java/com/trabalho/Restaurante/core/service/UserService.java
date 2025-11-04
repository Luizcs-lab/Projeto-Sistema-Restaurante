package com.trabalho.Restaurante.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.Restaurante.core.dto.UserDto;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.mapper.UserMapper;
import com.trabalho.Restaurante.core.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	private final UserMapper mapper;

	public UserService(UserRepository repository, UserMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<UserDto> findAll() {
		return repository.findAll().stream().map(user -> mapper.toDto(user)).toList();
	}

	public UserDto findById(Long id) {
		return repository.findById(id)
			.map(user -> mapper.toDto(user))
			.orElseThrow(() -> BusinessException.notFoundException("Usuário não encontrado"));
	}

	public UserDto save(UserDto userDto) {
		var user = mapper.toEntity(userDto);
		return mapper.toDto(repository.save(user));
	}

	public UserDto update(Long id, UserDto userDto) {
		var existingUser = this.findById(id);
		userDto.setId(existingUser.getId());
		var user = mapper.toEntity(userDto);
		return mapper.toDto(repository.save(user));
	}

	public void deleteById(Long id) {
		this.findById(id);
		repository.deleteById(id);
	}

}
