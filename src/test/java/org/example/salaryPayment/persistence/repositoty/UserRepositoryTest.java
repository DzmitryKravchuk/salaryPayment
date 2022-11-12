package org.example.salaryPayment.persistence.repositoty;

import org.assertj.core.api.Assertions;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

class UserRepositoryTest extends AbstractPersistenceTest {

    @Test
    void shouldGetUserByLogin() {
        var actualResult = userRepository.findByLogin("BA")
                .orElseThrow(() -> new ResourceNotFoundException("Failed to execute DivisionRepositoryTest.shouldGetDivisionByCode()"));

        Assertions.assertThat(actualResult.getDivisionId()).isEqualTo(1L);

    }
}
