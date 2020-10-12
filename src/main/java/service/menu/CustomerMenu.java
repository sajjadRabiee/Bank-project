package service.menu;

import service.Input.InputArea;
import service.entities.Customer;
import service.entities.CustomerAccount;
import service.processes.*;

import java.util.Optional;

public final class CustomerMenu {
    public static void showMainMenu(Customer customer){
        System.out.println("0.Go Back\n" +
                "1.Manage Accounts\n" +
                "2.Create new Account\n" +
                "3.Edit My Password\n" +
                "4.Show My Information\n" +
                "Please Enter Your Choice : ");
        switch (InputArea.getNumberInRange(3)){
            case 0:{
                return;
            }
            case 1:{
                showCreditCardMenu(AboutCustomerAccount.manageAccount(customer));
                break;
            } case 2:{
                AboutCustomerAccount.createCustomerAccount();
                break;
            }
            case 3:{
                AboutCustomer.editPasswordOfCustomerByOwns(customer);
                break;
            }
            case 4:{
                AboutCustomer.showCustomerInfo(customer,true,1);
            }
        }

    }
    public static void showCreditCardMenu(CustomerAccount customerAccount){
        System.out.println("0.Go Back\n" +
                "1.Transfer\n" +
                "2.Show My Transaction\n" +
                "3.Show My Account Information\n" +
                "Please Enter Your Choice : ");
        switch (InputArea.getNumberInRange(3)){
            case 0:{
                return;
            }
            case 1:{
                AboutTransactions.createTransfer(customerAccount);
                break;
            }
            case 2:{
                AboutTransactions.showAllTransactionsOfAccount(customerAccount);
                break;
            }
            case 3:{
                AboutCustomerAccount.showAccountInfo(customerAccount,1);
                break;
            }
        }

    }

    public static void showLoginMenu(){
        System.out.println("0.Go Back\n" +
                "1.Login\n" +
                "2.Register\n" +
                "Please Enter Your Choice : ");
        switch (InputArea.getNumberInRange(2)){
            case 0:{
                MainMenu.ShowMenu();
            }
            case 1:{
                Optional<Customer> onlineCustomer = Login.customerLogin();
                if(onlineCustomer.isPresent()){
                    showMainMenu(onlineCustomer.get());
                }else{
                    System.out.println("Sorry your information is not correct for login ! ");
                }
                break;
            }
            case 2:{
                Optional<Customer> onlineCustomer = Register.customerRegister();
                if(onlineCustomer.isPresent()){
                    showMainMenu(onlineCustomer.get());
                }else{
                    System.out.println("Sorry something is not correct in your registration ! ");
                }
                break;
            }
        }

    }
}
