package service.menu;

import service.Input.InputArea;

public class MainMenu {
    public static void ShowMenu(){
        System.out.println("Please choose your role from roles below : \n" +
                "1.Manager\n" +
                "2.Employee\n" +
                "3.Customer\n");
        switch (InputArea.getNumberInRange(3)){
            case 1 :{
                System.out.println("--- Manager Menu ---");
                ManagerMenu.showLoginMenu();
                break;
            }
            case 2:{
                System.out.println("--- Employee Menu ---");
                EmployeeMenu.showLoginMenu();
                break;
            }
            case 3:{
                System.out.println("--- Customer Menu ---");
                CustomerMenu.showLoginMenu();
                break;
            }
        }
    }
}
