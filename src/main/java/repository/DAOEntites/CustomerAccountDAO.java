package repository.DAOEntites;

import service.entities.CustomerAccount;

public class CustomerAccountDAO extends BaseEntityDAO<CustomerAccount,Long> {

    @Override
    protected Class<CustomerAccount> getEntityClass() {
        return CustomerAccount.class;
    }

    @Override
    protected String getFieldName() {
        return "account_number";
    }
}
