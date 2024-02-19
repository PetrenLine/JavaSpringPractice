package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "payment_method")
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
