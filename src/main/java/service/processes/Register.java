package service.processes;

import repository.DAOEntites.CustomerDAO;
import service.Input.InputArea;
import service.entities.Address;
import service.entities.Customer;
import service.entities.CustomerAccount;
import service.entities.Gender;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Register {
    public static Optional<Customer> customerRegister(){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer();
        System.out.println("Please Enter Your Name : ");
        String name = InputArea.getTitle();
        customer.setName(name);
        System.out.println("Please choose your gender\n" +
                "1.Male\n" +
                "2.Female\n");
        int gender = InputArea.getNumberInRange(2);
        if(gender == 1){
            customer.setGender(Gender.Male);
        }else{
            customer.setGender(Gender.Female);
        }
        System.out.println("Please Enter Your Username : ");
        String username = InputArea.getUsername();
        customer.setUsername(username);
        System.out.println("Please Enter Your Password : ");
        String password = InputArea.getPassword();
        customer.setPassword(password);
        System.out.println("Please Enter Your Birthday : ");
        Date date = InputArea.getDate();
        customer.setBirthDay(date);
        Address address = new Address();
        System.out.println("Please Enter Your Country : ");
        String country = InputArea.getTitle();
        address.setCountry(country);
        System.out.println("Please Enter Your City : ");
        String city = InputArea.getTitle();
        address.setCity(city);
        System.out.println("Please Enter Your Rest Of Address");
        String restAddress = InputArea.getText();
        address.setRestAddress(restAddress);
        customer.setAddress(address);
        System.out.println("Do you want create Account in one of our branch");
        if(InputArea.getBool()){
            Optional<CustomerAccount> customerAccount = AboutCustomerAccount.createCustomerAccount();
            if(customerAccount.isPresent()){
                List<CustomerAccount> customerAccounts = customer.getCustomerAccounts();
                customerAccounts.add(customerAccount.get());
                customer.setCustomerAccounts(customerAccounts);
            }
        }
        customerDAO.add(customer);
        return Optional.of(customer);
    }
}
