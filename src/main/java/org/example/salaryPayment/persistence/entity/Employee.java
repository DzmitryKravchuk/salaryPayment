package org.example.salaryPayment.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.salaryPayment.enums.Title;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractEntity{

    private String firstName;

    private String lastName;

    private Title title;

    private Long divisionId;
}
