package com.project.ASAP.User;

import com.project.ASAP.User.Domain.User;
import com.project.ASAP.User.Domain.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Entity -> DTO
	UserDTO toDto(User user);
    // DTO -> Entity
	User toEntity(UserDTO userDTO);
    // Entity -> DTO List
	List<UserDTO> toDtoList(List<User> users);

	List<User> toEntityList(List<UserDTO> users);
}
