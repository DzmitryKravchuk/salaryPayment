package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.persistence.entity.Division;
import org.example.salaryPayment.persistence.repositoty.DivisionRepository;
import org.example.salaryPayment.service.util.DivisionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Division getByCode(String code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Division with index " + code + " not found"));
    }
}
