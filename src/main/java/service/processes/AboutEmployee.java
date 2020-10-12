package service.processes;

import repository.DAOEntites.EmployeeDAO;
import service.Input.InputArea;
import service.entities.BankManager;
import service.entities.Employee;

import java.util.Optional;

public class AboutEmployee {
    public static void editPassword(Employee employee){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.println("please enter last password you use that : ");
        while(true) {
            String password = InputArea.getPassword();
            if (employee.getPassword().equals(password)) {
                System.out.println("now enter your new password");
                String newPassword = InputArea.getPassword();
                employee.setPassword(newPassword);
                employeeDAO.update(employee);
                return;
            } else {
                System.out.println("your password is not correct please try again");
                System.out.println("do you want try again");
                if(InputArea.getBool()){
                    continue;
                }else{
                    break;
                }
            }
        }
    }

    public static void RecruitmentEmployee(BankManager bankManager){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee();
        System.out.println("Please enter name of employee");
        String name = InputArea.getUsername();
        employee.setName(name);
        System.out.println("please enter password of employee");
        String password = InputArea.getPassword();
        employee.setPassword(password);
        employee.setBankBranch(bankManager.getBankBranch());
        employeeDAO.add(employee);
    }

    public static void ExpulsionEmployee(BankManager bankManager){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.println("please enter name of employee you want expulsion it");
        String name = InputArea.getUsername();
        Optional<Employee> oEmployee = employeeDAO.findByName(name);
        if(oEmployee.isPresent()){
            if(oEmployee.get().getBankBranch().equals(bankManager.getBankBranch())){
                System.out.println("Are you sure ?");
                if(InputArea.getBool()){
                    employeeDAO.delete(oEmployee.get());
                }else{
                    return;
                }
            }else{
                System.out.println("This User Is Not For Us And Work For Another Branch");
                return;
            }
        }else{
            System.out.println("No User Found !!!");
            return;
        }
    }
}
