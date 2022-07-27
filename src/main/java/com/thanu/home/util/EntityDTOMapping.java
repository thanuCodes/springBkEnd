package com.thanu.home.util;

import com.thanu.home.dto.UserDTO;
import com.thanu.home.entity.User;
import org.modelmapper.ModelMapper;

public class EntityDTOMapping {
    private ModelMapper mapper;

    public EntityDTOMapping (ModelMapper mapper) {
        this.mapper = mapper;
    }
    public User getUserEntity(UserDTO userDTO){

        return mapper.map(userDTO, User.class);
    }
    public UserDTO getUserDTO(User user){

        return mapper.map(user,UserDTO.class);
    }
}
