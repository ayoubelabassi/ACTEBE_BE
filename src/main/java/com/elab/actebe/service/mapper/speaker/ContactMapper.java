package com.elab.actebe.service.mapper.speaker;

import com.elab.actebe.domaine.speaker.Contact;
import com.elab.actebe.service.dto.speaker.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    Contact ContactDTOToContact(ContactDTO ContactDTO);

    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    ContactDTO ContactToContactDTO(Contact Contact);

    List<Contact> ContactDTOsToContacts(List<ContactDTO> ContactDTOS);

    List<ContactDTO> ContactsToContactDTOs(List<Contact> ContactS);
}
