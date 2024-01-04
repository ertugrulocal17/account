package com.ertugrulocal.account.service;

import com.ertugrulocal.account.dto.CustomerDTO;
import com.ertugrulocal.account.dto.converter.CustomerDTOConverter;
import com.ertugrulocal.account.exception.CustomerNotFoundException;
import com.ertugrulocal.account.model.Customer;
import com.ertugrulocal.account.repository.CustomerRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



import java.util.Optional;
import java.util.Set;


import static org.mockito.Mockito.mock;

public class CustomerServiceTest {
    private CustomerService service;
    private CustomerRepository customerRepository;
    private CustomerDTOConverter converter;

    @BeforeEach
    public void setUp(){
        customerRepository = mock(CustomerRepository.class);
        converter = mock(CustomerDTOConverter.class);
        service = new CustomerService(customerRepository,converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer("id","name","surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

         Customer result = service.findCustomerById("id");

        Assertions.assertEquals(result,customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class,()->service.getCustomerById("id"));
    }

    @Test
    public void testGetCustomerByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer("id","name","surname", Set.of());
        CustomerDTO customerDTO = new CustomerDTO("id","name","surname", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDTO);
        CustomerDTO result = service.getCustomerById("id");

        Assertions.assertEquals(result,customerDTO);
    }

    @Test
    public void testGetCustomerByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());
        Assertions.assertThrows(CustomerNotFoundException.class,()->service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);
    }


}
