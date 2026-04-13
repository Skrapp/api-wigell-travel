package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<CustomerDto> listAll();
    CustomerDto createCustomerWithAccount(CustomerWithAccountCreateDto dto);
    CustomerDto putUpdateCustomer(Long id, CustomerPutUpdateDto dto);
    void deleteCustomer(Long id);
    CustomerDto addAddressToCustomer(Long customerId, AddressCreateDto dto);
    CustomerDto deleteAddressFromCustomer(Long customerId, Long addressId);
}
