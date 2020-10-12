package service.menu;

import service.Input.InputArea;
import service.entities.BankManager;
import service.processes.AboutCustomer;
import service.processes.AboutCustomerAccount;
import service.processes.AboutEmployee;
import service.processes.Login;

import java.util.Optional;

public class ManagerMenu {
    public static void showMainMenu(BankManager bankManager){
        System.out.println("0.Go Back\n" +
                "1.Recruitment Employee\n" +
                "2.Expulsion Employee\n" +
                "3.Block Account of Customer\n" +
                "4.See Information of Customers\n" +
                "dar dast sakht--5.Hol Capital of Customers\n" +
                "dar dast sakht--6.Hol Income From Fee\n" +
                "Please Enter Your Choice : ");
        switch (InputArea.getNumberInRange(6)){
            case 0:{
                return;
            }
            case 1:{
                AboutEmployee.RecruitmentEmployee(bankManager);
                break;
            }
            case 2:{
                AboutEmployee.ExpulsionEmployee(bankManager);
                break;
            }
            case 3:{
                AboutCustomerAccount.blockAccount(bankManager.getBankBranch());
                break;
            }
            case 4:{
                AboutCustomer.showCustomers();
                break;
            }
            case 5:
            case 6: {
                System.out.println("dar dast sakht");
                break;
            }

        }
        showMainMenu(bankManager);
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
                Optional<BankManager> onlineManger = Login.bankManagerLogin();
                if(onlineManger.isPresent()){
                    showMainMenu(onlineManger.get());
                }else{
                    System.out.println("Sorry your information is not correct for login");
                }
                break;
            }
        }

    }

}
