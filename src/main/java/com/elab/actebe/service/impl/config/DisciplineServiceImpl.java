package com.elab.actebe.service.impl.config;

import com.elab.actebe.domaine.config.Discipline;
import com.elab.actebe.repository.config.DisciplineRepository;
import com.elab.actebe.service.dto.config.DisciplineDTO;
import com.elab.actebe.service.intf.config.DisciplineService;
import com.elab.actebe.service.mapper.config.DisciplineMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    @Inject
    private DisciplineRepository repository;

    @Inject
    private DisciplineMapper mapper;

    @Override
    public DisciplineDTO save(DisciplineDTO disciplineDTO) {
        Discipline discipline = mapper.DisciplineDTOtoDiscipline(disciplineDTO);
        discipline = repository.save(discipline);
        return mapper.DisciplineToDisciplineDTO(discipline);
    }

    @Override
    public List<DisciplineDTO> findAll() {
        List<DisciplineDTO> disciplineDTOS = mapper.DisciplinesToDisciplineDTOs(repository.findAllByDeleted(false));
        return disciplineDTOS;
    }

    @Override
    public DisciplineDTO findOne(long id) {
        DisciplineDTO discipline = mapper.DisciplineToDisciplineDTO(repository.getOne(id));
        return discipline;
    }
}
