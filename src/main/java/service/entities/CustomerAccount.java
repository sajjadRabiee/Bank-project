package service.entities;

import javax.persistence.*;
@Entity
@Table(name = "customer_account")
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , unique = true , nullable = false)
    private long id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "stock")
    private long stock;
    @Column(name = "situation")
    private Boolean situation = true;
    @ManyToOne
    @JoinColumn(name = "fk_bank_branch")
    private BankBranch bankBranch;
    @OneToOne
    @JoinColumn(name = "fk_credit_card")
    private CreditCard creditCard;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public Boolean getSituation() {
        return situation;
    }

    public void setSituation(Boolean situation) {
        this.situation = situation;
    }
}
