package repository.DAOEntites;

import service.entities.BankManager;

public class BankManagerDAO extends BaseEntityDAO<BankManager,Long>{
    @Override
    protected Class<BankManager> getEntityClass() {
        return BankManager.class;
    }

    @Override
    protected String getFieldName() {
        return "username";
    }
}
