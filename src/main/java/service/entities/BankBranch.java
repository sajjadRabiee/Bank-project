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
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "fk_bank_manager")
    private BankManager bankManager;
    @OneToMany
    @JoinColumn(name = "fk_employee")
    private List<Employee> employeeList = new ArrayList<>();

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
}
