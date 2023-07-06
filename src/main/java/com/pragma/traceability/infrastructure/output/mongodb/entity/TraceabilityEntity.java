package com.pragma.traceability.infrastructure.output.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document(collection = "trazabilidad")
@AllArgsConstructor
@NoArgsConstructor
public class TraceabilityEntity {
    @Id
    private String id;
    private Integer orderId;
    private Integer customerId;
    private String customerEmail;
    private LocalDateTime date;
    private String previousState;
    private String newState;
    private Integer employeeId;
    private String employeeEmail;
}
