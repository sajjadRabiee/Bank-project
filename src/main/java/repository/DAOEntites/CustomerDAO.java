package repository.DAOEntites;

import service.entities.Customer;

public class CustomerDAO extends BaseEntityDAO<Customer,Long> {

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    protected String getFieldName() {
        return "username";
    }
}
