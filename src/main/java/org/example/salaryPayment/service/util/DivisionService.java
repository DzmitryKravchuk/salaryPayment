package org.example.salaryPayment.service.util;

import org.example.salaryPayment.persistence.entity.Division;

public interface DivisionService {
    Division getByCode (String code);
}
