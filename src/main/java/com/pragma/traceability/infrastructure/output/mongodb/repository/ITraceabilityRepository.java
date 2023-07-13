package com.pragma.traceability.infrastructure.output.mongodb.repository;

import com.pragma.traceability.infrastructure.output.mongodb.entity.TraceabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITraceabilityRepository extends MongoRepository<TraceabilityEntity,String> {
    List<TraceabilityEntity> findByCustomerId(int customerId);
    List<TraceabilityEntity> findByOrderId(int orderId);

}
