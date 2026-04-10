package com.nilsson.api_wigell_travel.repo;

import com.nilsson.api_wigell_travel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdIsNot(String email, Long id);

    boolean existsByKeycloakUserId(String keycloakUserId);
}
