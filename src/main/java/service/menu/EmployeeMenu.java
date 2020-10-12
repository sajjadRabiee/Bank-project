package service.menu;

import service.Input.InputArea;
import service.entities.Employee;
import service.processes.AboutCustomerAccount;
import service.processes.AboutCustomer;
import service.processes.AboutEmployee;
import service.processes.Login;

import java.util.Optional;

public class EmployeeMenu {
    public static void showMainMenu(Employee employee){
        System.out.println("0.Go Back\n" +
                "1.See Information of Customers\n" +
                "2.Create New Password For Customer\n" +
                "3.Edit My Password\n" +
                "4.Block Account of Customer\n" +
                "Please Enter Your Choice : ");
        switch (InputArea.getNumberInRange(4)){
            case 0:{
                return;
            }
            case 1:{
                AboutCustomer.showCustomers();
            }
            case 2:{
                AboutCustomer.editPasswordOfCustomerByEmployee();
            }
            case 3:{
                AboutEmployee.editPassword(employee);
            }
            case 4:{
                AboutCustomerAccount.blockAccount(employee.getBankBranch());
            }
        }

    }
    public static void showLoginMenu(){
        System.out.println("0.Go Back\n" +
                "1.Login\n" +
                "Please Enter Your Choice : ");
        switch (InputArea.getNumberInRange(1)){
            case 0:{
                MainMenu.ShowMenu();
            }
            case 1:{
                Optional<Employee> onlineEmployee = Login.employeeLogin();
                if(onlineEmployee.isPresent()){
                    showMainMenu(onlineEmployee.get());
                }else{
                    System.out.println("Sorry your information is not correct for login");
                }
                break;
            }
        }

    }
}
