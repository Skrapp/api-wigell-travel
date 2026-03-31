package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.DestinationCreateDto;
import com.nilsson.api_wigell_travel.dto.DestinationDto;
import com.nilsson.api_wigell_travel.dto.DestinationPutUpdateDto;
import com.nilsson.api_wigell_travel.entity.Destination;
import com.nilsson.api_wigell_travel.exception.DestinationNotFoundException;
import com.nilsson.api_wigell_travel.mapper.DestinationMapper;
import com.nilsson.api_wigell_travel.repo.DestinationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService{
    private final DestinationRepo destinationRepo;

    public DestinationServiceImpl(DestinationRepo destinationRepo) {
        this.destinationRepo = destinationRepo;
    }

    @Override
    public List<DestinationDto> listAll() {
        return destinationRepo.findAll().stream()
                .map(DestinationMapper::toDto)
                .toList();
    }

    @Override
    public DestinationDto create(DestinationCreateDto dto) {
        Destination saved = destinationRepo.save(DestinationMapper.fromCreate(dto));
        return DestinationMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if(!destinationRepo.existsById(id))
            throw new DestinationNotFoundException(id);
        destinationRepo.deleteById(id);
    }

    @Override
    public DestinationDto putUpdate(Long id, DestinationPutUpdateDto dto) {
        Destination destination = destinationRepo.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException(id));
        DestinationMapper.applyPutUpdate(destination, dto);

        Destination saved = destinationRepo.save(destination);
        return DestinationMapper.toDto(saved);
    }
}
