package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.*;
import com.nilsson.api_wigell_travel.entity.Address;
import com.nilsson.api_wigell_travel.entity.Customer;
import com.nilsson.api_wigell_travel.exception.AddressAlreadyExistsException;
import com.nilsson.api_wigell_travel.exception.CustomerNotFoundException;
import com.nilsson.api_wigell_travel.mapper.CustomerMapper;
import com.nilsson.api_wigell_travel.repo.CustomerRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepo customerRepo;
    private final AddressService addressService;

    public CustomerServiceImpl(CustomerRepo customerRepo, AddressServiceImpl addressService) {
        this.customerRepo = customerRepo;
        this.addressService = addressService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> listAll() {
        List<Customer> customers = customerRepo.findAll();
        return customers.stream()
                .map(CustomerMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CustomerDto createCustomerWithAccount(CustomerWithAccountCreateDto dto) {
        if(customerRepo.existsByKeycloakUserId(dto.keycloakUserId()))
            throw new IllegalArgumentException("Finns redan en kund i denna tjänst kopplad till denna användare");
        if(customerRepo.existsByEmail(dto.email()))
            throw new IllegalArgumentException("Email används redan av en annan kund");

        Customer customer = CustomerMapper.fromCreate(dto);
        Address address = addressService.getOrCreate(dto.address());
        customer.addAddress(address);
        Customer saved = customerRepo.save(customer);

        //Add keycloak user
        return CustomerMapper.toDto(saved);
    }

    @Override
    @Transactional
    public CustomerDto putUpdateCustomer(Long id, CustomerPutUpdateDto dto) {
        if(customerRepo.existsByEmailAndIdIsNot(dto.email(), id))
            throw new IllegalArgumentException("Email används redan av en annan kund");

        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        CustomerMapper.applyPutUpdate(customer, dto);

        Customer saved = customerRepo.save(customer);
        return CustomerMapper.toDto(saved);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        if(!customerRepo.existsById(id))
            throw new CustomerNotFoundException(id);
        customerRepo.deleteById(id);
    }

    @Override
    @Transactional
    public CustomerDto addAddressToCustomer(Long customerId, AddressCreateDto dto) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        if(customerHasAddress(customer, dto)){
            throw new AddressAlreadyExistsException("Denna kund äger redan adressen");
        }
        Address address = addressService.getOrCreate(dto);

        customer.addAddress(address);

        Customer saved = customerRepo.save(customer);
        return CustomerMapper.toDto(saved);
    }

    private boolean customerHasAddress(Customer customer, AddressCreateDto dto) {
        return customer.getAddresses().stream()
                .anyMatch(address -> 
                        address.getStreetAddress().equals(dto.streetAddress())
                        && address.getCity().equals(dto.city())
                        && address.getPostalCode().equals(dto.postalCode())
                );
    }

    @Override
    @Transactional
    public CustomerDto deleteAddressFromCustomer(Long customerId, Long addressId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        if(customer.getAddresses().removeIf(address -> address.getId().equals(addressId)))
            customer = customerRepo.save(customer);
        //Loggning om det togs bort eller inte

        return CustomerMapper.toDto(customer);
    }
}
