package service.processes;

import com.mysql.cj.xdevapi.Table;
import repository.DAOEntites.CustomerDAO;
import service.Input.InputArea;
import service.entities.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class AboutCustomer {
    public static void showCustomerInfo(Customer customer,boolean showComplete,Integer i){
        System.out.println("-------------------------------  number "+i+" -----------------------------------");
        System.out.println("name : " + customer.getName());
        System.out.println("gender : " + customer.getGender());
        System.out.println("national code : " + customer.getNationalCode());
        if(showComplete){
            System.out.println(customer.getAddress());
            System.out.println(customer.getBirthDay());
            System.out.println(customer.getUsername());
            AboutCustomerAccount.showAllAccounts(customer.getCustomerAccounts(),false);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static Map<Integer, String> showAllCustomer(){
        CustomerDAO customerDAO = new CustomerDAO();
        Map<Integer, String> map = new TreeMap<>();
        Integer i = 0;
        for(Customer b : customerDAO.findAll(a -> true)){
            map.put(i++,b.getUsername());
            showCustomerInfo(b,false,i);
        }
        return map;
    }

    public static Customer showCustomers(){
        CustomerDAO customerDAO = new CustomerDAO();
        Map<Integer, String> customerMap = showAllCustomer();
        System.out.println("Please enter number of customer you want see complete information it");
        Integer number = InputArea.getNumberInRange(customerMap.size());
        Customer customer = customerDAO.findByName(customerMap.get(number)).get();
        showCustomerInfo(customer , true , number);
        return customer;
    }

    public static void editPasswordOfCustomerByEmployee(){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = showCustomers();
        System.out.println("Are you sure that you want edit password of this customer ?");
        if(InputArea.getBool()){
            System.out.println("please enter new password");
            String password = InputArea.getPassword();
            customer.setPassword(password);
            customerDAO.update(customer);
        }else{
            return;
        }
    }

    public static void editPasswordOfCustomerByOwns(Customer customer){
        CustomerDAO customerDAO = new CustomerDAO();
        while(true) {
            System.out.println("please enter old password");
            String password = InputArea.getPassword();
            if (customer.getPassword().equals(password)) {
                System.out.println("please enter new password");
                String newPassword = InputArea.getPassword();
                customer.setPassword(newPassword);
                customerDAO.update(customer);
            } else {
                System.out.println("password is not corrected");
                System.out.println("do you want try again : ");
                if(InputArea.getBool()){
                    continue;
                }else{
                    break;
                }
            }
        }
    }
}

