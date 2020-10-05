package service.proccess;

import repository.DAOEntites.CustomerDAO;
import service.entities.BankManager;
import service.entities.Customer;
import service.entities.Employee;

public final class Login {
    public static Customer customerLogin(){
        CustomerDAO customerDAO = new CustomerDAO();
        System.out.println("Please enter your username : ");
        System.out.println("Please enter your password : ");
    }
    public static Employee employeeLogin(){

    }
    public static BankManager bankManagerLogin(){

    }
}
