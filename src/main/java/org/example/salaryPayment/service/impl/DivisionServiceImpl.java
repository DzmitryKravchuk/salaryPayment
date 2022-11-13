package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.persistence.entity.Division;
import org.example.salaryPayment.persistence.repositoty.DivisionRepository;
import org.example.salaryPayment.service.util.DivisionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Division getByCode(String code) {
        log.info("getByCode(): {}", code);
        return repository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Division with code " + code + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Division getById(Long id) {
        log.info("getById(): {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Division with index " + id + " not found"));
    }
}
