package service.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , unique = true , nullable = false)
    private long id;
    @Column(name = "card_number" , unique = true)
    private String cardNumber;
    @OneToMany
    @JoinColumn(name = "fk_transaction")
    private List<Transaction> transactionList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
