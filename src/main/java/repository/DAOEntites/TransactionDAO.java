package repository.DAOEntites;

import service.entities.Transaction;

public class TransactionDAO extends BaseEntityDAO<Transaction,Long> {

    @Override
    protected Class<Transaction> getEntityClass() {
        return Transaction.class;
    }

    @Override
    protected String getFieldName() {
        return "Tracking_Number";
    }
}
