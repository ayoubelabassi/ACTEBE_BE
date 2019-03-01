package com.elab.actebe.service.mapper.security;

import com.elab.actebe.domaine.security.User;
import com.elab.actebe.service.dto.security.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    UserDTO UserToUserDTO(User User);

    List<UserDTO> UsersToUserDTOs(List<User> Users);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    User UserDTOtoUser(UserDTO UserDTO);

    List<User> UserDTOsToUsers(List<UserDTO> Users);
}
