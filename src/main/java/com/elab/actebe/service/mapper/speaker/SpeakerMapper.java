package com.elab.actebe.service.mapper.speaker;

import com.elab.actebe.domaine.speaker.Speaker;
import com.elab.actebe.service.dto.speaker.SpeakerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpeakerMapper {
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    Speaker SpeakerDTOToSpeaker(SpeakerDTO clientDTO);

    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    SpeakerDTO ClientToClientDTO(Speaker client);

    List<Speaker> SpeakerDTOsToSpeakers(List<SpeakerDTO> clientDTOS);

    List<SpeakerDTO> SpeakersToSpeakerDTOs(List<Speaker> clientS);
}
