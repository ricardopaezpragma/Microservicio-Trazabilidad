package com.pragma.traceability.infrastructure.output.mongodb.mapper;

import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.infrastructure.output.mongodb.entity.TraceabilityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TraceabilityEntityMapper {
    Traceability toModel(TraceabilityEntity traceabilityEntity);
    TraceabilityEntity toEntity(Traceability traceability);
}
