package org.example.mapper;

import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDTOToCustomer(CustomerDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    CustomerDTO customerToCustomerDTO(Customer customer);

}