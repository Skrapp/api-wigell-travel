package com.nilsson.api_wigell_travel.repo;

import com.nilsson.api_wigell_travel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
    Optional<Address> findAddressByStreetAddressAndPostalCodeAndCity(String streetAddress, String postalCode, String city);
}
