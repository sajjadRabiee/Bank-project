package repository.DAOEntites;

import service.entities.CreditCard;

public class CreditCardDAO extends BaseEntityDAO<CreditCard , Long> {
    @Override
    protected Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }

    @Override
    protected String getFieldName() {
        return "card_number";
    }
}
