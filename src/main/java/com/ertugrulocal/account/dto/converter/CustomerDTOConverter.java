package com.ertugrulocal.account.dto.converter;

import com.ertugrulocal.account.dto.AccountCustomerDTO;
import com.ertugrulocal.account.dto.CustomerAccountDTO;
import com.ertugrulocal.account.dto.CustomerDTO;
import com.ertugrulocal.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDTOConverter {
    private final CustomerAccountDTOConverter converter;

    public CustomerDTOConverter(CustomerAccountDTOConverter converter) {
        this.converter = converter;
    }

    public AccountCustomerDTO convertToAccountCustomer(Customer from) {
        if (from == null) {
            return new AccountCustomerDTO("", "", "");
        }
        return new AccountCustomerDTO(from.getId(), from.getName(), from.getSurname());
    }

    public CustomerDTO convertToCustomerDto(Customer from) {
        return new CustomerDTO(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(converter::convert).collect(Collectors.toSet()));
    }

}

