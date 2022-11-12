package org.example.salaryPayment.persistence.repositoty;

import org.assertj.core.api.SoftAssertions;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

class UserRepositoryTest extends AbstractPersistenceTest {

    @Test
    void shouldGetUserByLogin() {
        var actualResult = userRepository.findByLogin("BA")
                .orElseThrow(() -> new ResourceNotFoundException("Failed to execute DivisionRepositoryTest.shouldGetDivisionByCode()"));

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getDivisionId()).isEqualTo(1L);
            softly.assertThat(actualResult.getPassword()).isEqualTo("changeit");
        });
    }
}
