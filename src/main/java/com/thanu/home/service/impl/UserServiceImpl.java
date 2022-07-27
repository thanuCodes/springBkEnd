package com.thanu.home.service.impl;

import com.thanu.home.dto.UserDTO;
import com.thanu.home.entity.User;
import com.thanu.home.repository.UserRepository;
import com.thanu.home.service.Exception.DuplicateEmailException;
import com.thanu.home.service.Exception.NotFoundException;
import com.thanu.home.service.UserService;
import com.thanu.home.util.EntityDTOMapping;

import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final EntityDTOMapping transform;

    public UserServiceImpl(UserRepository userRepository, EntityDTOMapping transform) {
        this.userRepository = userRepository;
        this.transform = transform;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws DuplicateEmailException {
        if(userRepository.existsUserByEmail(userDTO.getEmail())) throw new DuplicateEmailException("User already exists");
        userDTO.setId(UUID.randomUUID().toString());
        return transform.getUserDTO(userRepository.save(transform.getUserEntity(userDTO)));
    }

    @Override
    public void updateUser(UserDTO userDTO) throws NotFoundException {
        Optional<User> optUser = userRepository.findById(userDTO.getId());
        if(!optUser.isPresent()) throw new NotFoundException("No user found");
        optUser.get().setUserName(userDTO.getUserName());
        optUser.get().setPassword(userDTO.getPassword());

    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
        return userRepository.findById(userId).map(transform::getUserDTO)
                .orElseThrow(()->new NotFoundException("Invalid User"));
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {
        if(!userRepository.existsById(userId))throw new NotFoundException("Invalid UserId");
        userRepository.deleteById(userId);

    }
}
