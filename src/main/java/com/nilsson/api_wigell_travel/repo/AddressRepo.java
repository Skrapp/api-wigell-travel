package com.nilsson.api_wigell_travel.repo;

import com.nilsson.api_wigell_travel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
