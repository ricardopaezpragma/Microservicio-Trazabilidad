package com.pragma.traceability.application.handler.interfaces;

import com.pragma.traceability.application.dto.TraceabilityDto;

import java.util.List;

public interface ITraceabilityHandler {
    void saveTraceability(TraceabilityDto traceabilityDto);
    List<TraceabilityDto> getTraceabilityByCustomerId(int customerId);

    List<TraceabilityDto> getTraceabilityByOrderId(int orderId);
}
