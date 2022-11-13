package org.example.salaryPayment.persistence.repositoty;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SalaryPaymentRepositoryTest extends AbstractPersistenceTest {

    @Test
    void shouldGetData() {
        var months = List.of(1, 2, 3);
        var data = salaryPaymentRepository.findPaymentsFetchTitle(1L, 2022, months);

        Assertions.assertThat(data).hasSize(7 * 3);
    }

}