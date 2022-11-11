package org.example.salaryPayment.persistence.repositoty;

import org.assertj.core.api.Assertions;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

class DivisionRepositoryTest extends AbstractPersistenceTest {

    @Test
    void shouldGetDivisionByCode() {
        var id =1L;
        var ob = divisionRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to execute DivisionRepositoryTest.shouldGetDivisionByCode()"));

        var ob1 = divisionRepository.findByCode(ob.getCode())
                .orElseThrow(() -> new ResourceNotFoundException("Failed to execute DivisionRepositoryTest.shouldGetDivisionByCode()"));

        Assertions.assertThat(id).isEqualTo(ob1.getId());
    }
}