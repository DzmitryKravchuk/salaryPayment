package org.example.salaryPayment.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AbstractEntity {
    @Id
    protected Long id;
}
