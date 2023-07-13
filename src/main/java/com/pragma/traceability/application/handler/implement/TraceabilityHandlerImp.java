package com.pragma.traceability.application.handler.implement;

import com.pragma.traceability.application.dto.TraceabilityDto;
import com.pragma.traceability.application.handler.interfaces.ITraceabilityHandler;
import com.pragma.traceability.application.mapper.TraceabilityDtoMapper;
import com.pragma.traceability.domain.api.ITraceabilityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TraceabilityHandlerImp implements ITraceabilityHandler {
    private final ITraceabilityServicePort traceabilityServicePort;
    private final TraceabilityDtoMapper traceabilityDtoMapper;

    @Override
    public void saveTraceability(TraceabilityDto traceabilityDto) {
        traceabilityDto.setDate(LocalDateTime.now());
        traceabilityServicePort.saveTraceability(traceabilityDtoMapper.toModel(traceabilityDto));
    }

    @Override
    public List<TraceabilityDto> getTraceabilityByCustomerId(int customerId) {
        return traceabilityServicePort.getTraceabilityByCustomerId(customerId)
                .stream()
                .map(this.traceabilityDtoMapper::toDto)
                .toList();
    }

    @Override
    public List<TraceabilityDto> getTraceabilityByOrderId(int orderId) {
        return traceabilityServicePort.getTraceabilityByOrderId(orderId)
                .stream()
                .map(this.traceabilityDtoMapper::toDto)
                .toList();
    }
}
