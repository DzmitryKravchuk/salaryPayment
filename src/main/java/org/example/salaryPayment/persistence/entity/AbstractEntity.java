package org.example.salaryPayment.persistence.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class AbstractEntity {
    @Id
    protected Long id;
}
