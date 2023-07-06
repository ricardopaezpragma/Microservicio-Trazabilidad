package com.pragma.traceability.infrastructure.configuration;

import com.pragma.traceability.domain.api.ITraceabilityServicePort;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.domain.usecase.TraceabilityUseCase;
import com.pragma.traceability.infrastructure.output.mongodb.adapter.TraceabilityJpaAdapter;
import com.pragma.traceability.infrastructure.output.mongodb.mapper.TraceabilityEntityMapper;
import com.pragma.traceability.infrastructure.output.mongodb.repository.ITraceabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITraceabilityRepository traceabilityRepository;
    private final TraceabilityEntityMapper traceabilityEntityMapper;

    @Bean
    public ITraceabilityServicePort traceabilityServicePort(){
        return new TraceabilityUseCase(traceabilityPersistencePort());
    }
    @Bean
    public ITraceabilityPersistencePort traceabilityPersistencePort(){
        return new TraceabilityJpaAdapter(traceabilityRepository,traceabilityEntityMapper);
    }
}
