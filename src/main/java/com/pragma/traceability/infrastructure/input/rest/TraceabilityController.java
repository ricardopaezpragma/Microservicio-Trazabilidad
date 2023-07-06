package com.pragma.traceability.infrastructure.input.rest;

import com.pragma.traceability.application.dto.TraceabilityDto;
import com.pragma.traceability.application.handler.interfaces.ITraceabilityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/traceability")
public class TraceabilityController {

    private final ITraceabilityHandler traceabilityHandler;

    @PostMapping()
    public ResponseEntity<HttpStatus> saveTraceability(@RequestBody TraceabilityDto traceabilityDto) {
        traceabilityHandler.saveTraceability(traceabilityDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<List<TraceabilityDto>> getTraceabilityByCustomerId(@PathVariable int customerId){
        return ResponseEntity.ok(traceabilityHandler.getTraceabilityByCustomerId(customerId));
    }
    @GetMapping("/sisas")
    public ResponseEntity<String> cosa(){
        return ResponseEntity.ok("sisas");
    }
}
