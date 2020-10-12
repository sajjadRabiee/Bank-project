package service.processes;

import repository.DAOEntites.CreditCardDAO;
import repository.DAOEntites.CustomerAccountDAO;
import service.Input.InputArea;
import service.entities.*;

import java.util.*;
import java.util.function.Predicate;

public class AboutCustomerAccount {
    public static Optional<CustomerAccount> createCustomerAccount() {
        CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();
        CreditCardDAO creditCardDAO = new CreditCardDAO();
        CustomerAccount customerAccount = new CustomerAccount();
        System.out.println("Please Enter Branch Number You Want Create Account In It After Show All Branches In List Below ");
        Map<Integer, BankBranch> mapBanks = AboutBankBranch.showAllBanks();
        Integer branchNumber = InputArea.getNumberInRange(mapBanks.size());
        customerAccount.setBankBranch(mapBanks.get(branchNumber));
        System.out.println("Please Type Your Money You Want Stock Here");
        long stock = InputArea.getLong();
        customerAccount.setStock(stock);
        CreditCard creditCard = new CreditCard();
        String string1;
        while (true){
            Random random1 = new Random();
        string1 = "6221" + branchNumber + random1.nextInt(9999);
        if (!creditCardDAO.findByName(string1).isPresent()) {
            break;
        }
        }
        creditCard.setCardNumber(string1);
        customerAccount.setCreditCard(creditCard);
        creditCardDAO.add(creditCard);
        String string2;
        while (true){
            Random random2 = new Random();
            string2 = string1 + random2.nextInt(9999);
            if (!creditCardDAO.findByName(string2).isPresent()) {
                break;
            }
        }
        customerAccount.setAccountNumber(string2);
        customerAccountDAO.add(customerAccount);
        return Optional.of(customerAccount);
    }

    public static void showAccountInfo(CustomerAccount customerAccount , Integer i){
        System.out.println("-------------------------------  number "+i+" -----------------------------------");
        System.out.println("Account Number -> " + customerAccount.getAccountNumber());
        System.out.println("Card Number -> " + customerAccount.getCreditCard().getCardNumber());
        System.out.println("Bank Name -> " + customerAccount.getBankBranch().getName());
        String s = customerAccount.getSituation().equals(true) ? "Active" : "Is Not Active";
        System.out.println("Situation -> " + s);
        System.out.println("------------------------------------------------------------------");
    }

    public static Map<Integer,CustomerAccount> showAllAccounts(Predicate<CustomerAccount> p){
        CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();
        Map<Integer, CustomerAccount> map = new TreeMap<>();
        Integer i = 0;
        for(CustomerAccount b : customerAccountDAO.findAll(p)){
            map.put(i++,b);
            showAccountInfo(b,i);
        }
        return map;
    }

    public static Map<Integer,CustomerAccount> showAllAccounts(List<CustomerAccount> customerAccountList,Boolean justShowActive){
        Map<Integer, CustomerAccount> map = new TreeMap<>();
        Integer i = 0;
        for(CustomerAccount b : customerAccountList){
            if(justShowActive){
                if(b.getSituation()){
                    map.put(i++,b);
                    showAccountInfo(b,i);
                }
            }else{
                map.put(i++,b);
                showAccountInfo(b,i);
            }
        }
        return map;
    }

    public static void blockAccount(BankBranch bankBranch){
        CustomerAccountDAO customerAccountDAO = new CustomerAccountDAO();
        System.out.println("please enter username of customer you want block account of him : ");
        while (true) {
            String username = InputArea.getUsername();
            Optional<CustomerAccount> oCustomerAccount = customerAccountDAO.findByName(username);
            if (oCustomerAccount.isPresent()) {
                if (oCustomerAccount.get().getBankBranch().equals(bankBranch)) {
                    System.out.println("Are you sure ?");
                    if(InputArea.getBool()){
                        oCustomerAccount.get().setSituation(false);
                        customerAccountDAO.update(oCustomerAccount.get());
                        System.out.println("This account is successfully blocked");
                        break;
                    }else{
                        break;
                    }
                } else {
                    System.out.println("you can not block this customer because is not for our branch");
                }
            } else {
                System.out.println("this customer is not in our system");
                System.out.println("do you want show all customer of our branch ?");
                if (InputArea.getBool()) {
                    showAllAccounts(a -> a.getBankBranch().equals(bankBranch));
                }
                continue;
            }
        }
    }

    public static CustomerAccount manageAccount(Customer customer){
        Map<Integer, CustomerAccount> accountMap = showAllAccounts(customer.getCustomerAccounts(),true);
        System.out.println("Please enter number of account you want use it");
        Integer number = InputArea.getNumberInRange(accountMap.size());
        return accountMap.get(number);
    }
}
