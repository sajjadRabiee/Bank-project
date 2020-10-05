package repository.DAOEntites;

import service.entities.BankBranch;

public class BankBranchDAO extends BaseEntityDAO<BankBranch , Long> {
    @Override
    protected Class<BankBranch> getEntityClass() {
        return BankBranch.class;
    }

    @Override
    protected String getFieldName() {
        return "name";
    }
}
