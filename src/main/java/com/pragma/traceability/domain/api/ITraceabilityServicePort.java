package com.pragma.traceability.domain.api;

import com.pragma.traceability.domain.model.Traceability;

import java.util.List;

public interface ITraceabilityServicePort {
    void saveTraceability(Traceability traceability);

    List<Traceability> getTraceabilityByCustomerId(int customerId);
}
