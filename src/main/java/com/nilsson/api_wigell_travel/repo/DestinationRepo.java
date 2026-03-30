package com.nilsson.api_wigell_travel.repo;

import com.nilsson.api_wigell_travel.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepo extends JpaRepository<Destination, Long> {
}
