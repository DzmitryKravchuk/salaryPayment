package org.example.salaryPayment.persistence.repositoty;

import org.assertj.core.api.SoftAssertions;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.enums.Title;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class EmployeeRepositoryTest extends AbstractPersistenceTest {

    @Test
    void shouldGetByNamesContaining() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("Shal", "Ko" );

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(2);
            softly.assertThat(actualResult).anyMatch(e -> e.getFirstName().equals("Shaldon" ));
            softly.assertThat(actualResult).anyMatch(e -> e.getFirstName().equals("Shally" ));
        });
    }

    @Test
    void shouldGetByFirstNameContaining() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("John", "" );

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(3);
            softly.assertThat(actualResult).anyMatch(e -> e.getLastName().equals("Conor" ));
            softly.assertThat(actualResult).anyMatch(e -> e.getLastName().equals("Doe" ));
            softly.assertThat(actualResult).anyMatch(e -> e.getLastName().equals("Snow" ));
        });
    }

    @Test
    void shouldGetByNamesOne() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("", "Conor" );

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(2);
            softly.assertThat(actualResult).anyMatch(e -> e.getFirstName().equals("John" ));
            softly.assertThat(actualResult).anyMatch(e -> e.getFirstName().equals("Sarah" ));
        });
    }

    @Test
    void shouldGetByLastNameContaining() {
        var actualResult = employeeRepository.findByFirstNameContainingAndLastNameContaining("John", "Conor" );

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(1);
            softly.assertThat(actualResult).anyMatch(e -> e.getLastName().equals("Conor" ));
            softly.assertThat(actualResult).anyMatch(e -> e.getFirstName().equals("John" ));
        });
    }

    @Test
    void shouldGetModels() {
        var actualResult = employeeRepository.findEmployeesFetchDivision();
        var baResult = actualResult.stream()
                .filter(m -> m.getCode().equals("BA" ))
                .collect(Collectors.toList());
        var qaResult = actualResult.stream()
                .filter(m -> m.getCode().equals("QA" ))
                .collect(Collectors.toList());

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult).hasSize(13);
            softly.assertThat(baResult).hasSize(7);
            softly.assertThat(qaResult).hasSize(6);
        });
    }

    @Test
    void shouldGetModelById() {
        var actualResult = employeeRepository.findByIdFetchDivision(1L)
                .orElseThrow(() -> new ResourceNotFoundException("Failed to execute DivisionRepositoryTest.shouldGetDivisionByCode()"));


        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getFirstName()).isEqualTo("John");
            softly.assertThat(actualResult.getLastName()).isEqualTo("Doe");
            softly.assertThat(actualResult.getCode()).isEqualTo("BA");
            softly.assertThat(actualResult.getTitle()).isEqualTo(Title.JUNIOR);
        });
    }
}