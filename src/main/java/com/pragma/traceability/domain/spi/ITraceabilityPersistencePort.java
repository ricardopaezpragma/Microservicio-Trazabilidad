package com.pragma.traceability.domain.spi;

import com.pragma.traceability.domain.model.Traceability;

import java.util.List;

public interface ITraceabilityPersistencePort {

    void saveTraceability(Traceability traceability);
    List<Traceability> getTraceabilityByCustomerId(int customerId);
    List<Traceability> getTraceabilityByOrderId(int orderId);

}
