package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.DestinationCreateDto;
import com.nilsson.api_wigell_travel.dto.DestinationDto;
import com.nilsson.api_wigell_travel.dto.DestinationPutUpdateDto;
import com.nilsson.api_wigell_travel.entity.Destination;
import com.nilsson.api_wigell_travel.exception.DestinationNotFoundException;
import com.nilsson.api_wigell_travel.logging.LoggingAspectControllers;
import com.nilsson.api_wigell_travel.mapper.DestinationMapper;
import com.nilsson.api_wigell_travel.repo.DestinationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService{
    private final DestinationRepo destinationRepo;

    public DestinationServiceImpl(DestinationRepo destinationRepo) {
        this.destinationRepo = destinationRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DestinationDto> listAll() {
        return destinationRepo.findAll().stream()
                .map(DestinationMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public DestinationDto create(DestinationCreateDto dto) {
        Destination saved = destinationRepo.save(DestinationMapper.fromCreate(dto));
        return DestinationMapper.toDto(saved);
    }

    /**
     * Before deletion of a destination, all relations to bookings are removed by setting the destination
     * in said bookings to null.
     * @param id
     */
    @Override
    @Transactional
    public void delete(Long id) {
        Destination destination = destinationRepo.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException(id));

        if(!destination.getBookings().isEmpty()){
            destination.getBookings()
                    .forEach(b -> b.setDestination(null));
        }

        destinationRepo.deleteById(id);
    }

    @Override
    @Transactional
    public DestinationDto putUpdate(Long id, DestinationPutUpdateDto dto) {
        Destination destination = destinationRepo.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException(id));
        DestinationMapper.applyPutUpdate(destination, dto);

        Destination saved = destinationRepo.save(destination);
        return DestinationMapper.toDto(saved);
    }
}
