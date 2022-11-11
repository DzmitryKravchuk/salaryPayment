package org.example.salaryPayment.persistence.repositoty;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class EmployeeRepositoryTest extends AbstractPersistenceTest{
    @Test
    void shouldGetByNamesContaining() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("Shal","Ko");

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(2);
            softly.assertThat(actualResult).anyMatch(e->e.getFirstName().equals("Shaldon"));
            softly.assertThat(actualResult).anyMatch(e->e.getFirstName().equals("Shally"));
        });
    }
    @Test
    void shouldGetByFirstNameContaining() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("John","");

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(2);
            softly.assertThat(actualResult).anyMatch(e->e.getLastName().equals("Conor"));
            softly.assertThat(actualResult).anyMatch(e->e.getLastName().equals("Doe"));
        });
    }

    @Test
    void shouldGetByNamesOne() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("","Conor");

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(2);
            softly.assertThat(actualResult).anyMatch(e->e.getFirstName().equals("John"));
            softly.assertThat(actualResult).anyMatch(e->e.getFirstName().equals("Sarah"));
        });
    }

    @Test
    void shouldGetByLastNameContaining() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("John","Conor");

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(1);
            softly.assertThat(actualResult).anyMatch(e->e.getLastName().equals("Conor"));
            softly.assertThat(actualResult).anyMatch(e->e.getFirstName().equals("John"));
        });
    }
}