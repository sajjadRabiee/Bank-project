package service.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , unique = true , nullable = false)
    private long id;
    @Column(name = "branch_number" , unique = true , nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int branchNumber;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "fk_bank_manager")
    private BankManager bankManager;
    @OneToMany(mappedBy = "bankBranch" , fetch = FetchType.LAZY)
    private List<Employee> employeeList = new ArrayList<>();
    @OneToMany(mappedBy = "bankBranch" , fetch = FetchType.LAZY)
    private List<CustomerAccount> customerAccountList = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankManager getBankManager() {
        return bankManager;
    }

    public void setBankManager(BankManager bankManager) {
        this.bankManager = bankManager;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public List<CustomerAccount> getCustomerAccountList() {
        return customerAccountList;
    }

    public void setCustomerAccountList(List<CustomerAccount> customerAccountList) {
        this.customerAccountList = customerAccountList;
    }
}
