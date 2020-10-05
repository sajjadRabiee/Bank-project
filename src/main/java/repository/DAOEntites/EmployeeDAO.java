package repository.DAOEntites;

import service.entities.Employee;

public class EmployeeDAO extends BaseEntityDAO<Employee,Long> {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    protected String getFieldName() {
        return "name";
    }
}
