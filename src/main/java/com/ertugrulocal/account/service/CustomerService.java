package com.ertugrulocal.account.service;

import com.ertugrulocal.account.dto.CustomerDTO;
import com.ertugrulocal.account.dto.converter.CustomerDTOConverter;
import com.ertugrulocal.account.exception.CustomerNotFoundException;
import com.ertugrulocal.account.model.Customer;
import com.ertugrulocal.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDTOConverter converter;
    public CustomerService(CustomerRepository customerRepository, CustomerDTOConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer could not find by id: " + id));
    }

    public CustomerDTO getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
