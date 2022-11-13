package org.example.salaryPayment.mapper;
import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.EmployeeDivisionResponse;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.persistence.entity.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeDivisionResponse mapToResponse (EmployeeDivisionModel model);

    Employee mapToEntity (UpdEmployeeRequest request);
}
