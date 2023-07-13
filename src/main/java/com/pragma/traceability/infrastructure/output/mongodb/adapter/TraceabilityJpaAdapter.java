package com.pragma.traceability.infrastructure.output.mongodb.adapter;

import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.infrastructure.exception.TraceabilityException;
import com.pragma.traceability.infrastructure.output.mongodb.mapper.TraceabilityEntityMapper;
import com.pragma.traceability.infrastructure.output.mongodb.repository.ITraceabilityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TraceabilityJpaAdapter implements ITraceabilityPersistencePort {
    private final ITraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;

    @Override
    public void saveTraceability(Traceability traceability) {
        traceabilityRepository.save(traceabilityEntityMapper.toEntity(traceability));
    }

    @Override
    public List<Traceability> getTraceabilityByCustomerId(int customerId) {
        return traceabilityRepository.findByCustomerId(customerId)
                .stream()
                .map(this.traceabilityEntityMapper::toModel)
                .toList();
    }

    @Override
    public List<Traceability> getTraceabilityByOrderId(int orderId) {
        return traceabilityRepository.findByOrderId(orderId)
                .stream()
                .map(this.traceabilityEntityMapper::toModel)
                .toList();
    }
}
