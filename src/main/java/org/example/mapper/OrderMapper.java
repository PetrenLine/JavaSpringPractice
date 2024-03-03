package org.example.mapper;

import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderDTOToOrder(OrderDTO dto);

    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "orderStatus", target = "orderStatus")
    @Mapping(source = "paymentMethod", target = "paymentMethod")
    @Mapping(source = "customer.id", target = "customerId")
    OrderDTO orderToOrderDTO(Order orders);
}