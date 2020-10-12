package service.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , unique = true , nullable = false)
    private long id;
    @Column(name = "Tracking_Number" , unique = true)
    private String trackingNumber;
    @Column(name = "transaction_time")
    private Date transactionTime;
    @Column(name = "situation")
    private boolean situation;
    @OneToOne
    @JoinColumn(name = "fk_credit_card1")
    private CreditCard creditCard1;
    @OneToOne
    @JoinColumn(name = "fk_credit_card2")
    private CreditCard CreditCard2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public CreditCard getCreditCard1() {
        return creditCard1;
    }

    public void setCreditCard1(CreditCard creditCard1) {
        this.creditCard1 = creditCard1;
    }

    public CreditCard getCreditCard2() {
        return CreditCard2;
    }

    public void setCreditCard2(CreditCard creditCard2) {
        CreditCard2 = creditCard2;
    }

    public boolean isSituation() {
        return situation;
    }

    public void setSituation(boolean situation) {
        this.situation = situation;
    }
}
