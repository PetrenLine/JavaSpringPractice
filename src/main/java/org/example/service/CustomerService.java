package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.mapper.CustomerMapper;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(CustomerDTO dto) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(dto);
        return customerRepository.save(customer);
    }

    public Customer readById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
}

