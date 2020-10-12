package service.processes;

import repository.DAOEntites.CreditCardDAO;
import repository.DAOEntites.TransactionDAO;
import service.Input.InputArea;
import service.entities.CreditCard;
import service.entities.CustomerAccount;
import service.entities.Transaction;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class AboutTransactions {
    public static void showTransactionInfo(Transaction transaction){
        System.out.println("------------------------------------------------------------------");
        System.out.println("Tracking Number -> " + transaction.getTrackingNumber());
        System.out.println("Transaction Time -> " + transaction.getTransactionTime());
        System.out.println("First Credit Card Number -> " + transaction.getCreditCard1());
        System.out.println("Second Credit Card Number -> " + transaction.getCreditCard2());
        String s = transaction.isSituation() ? "Successfully completed" : "Is Not Completed";
        System.out.println("Situation ->" + s);
        System.out.println("------------------------------------------------------------------");
    }

    public static void showAllTransactions(List<Transaction> transactionList){
        for(Transaction t : transactionList){
            showTransactionInfo(t);
        }
    }

    public static void showAllTransactionsOfAccount(CustomerAccount customerAccount){
      showAllTransactions(customerAccount.getCreditCard().getTransactionList());
    }

    public static void createTransfer(CustomerAccount customerAccount){
        TransactionDAO transactionDAO = new TransactionDAO();
        CreditCardDAO creditCardDAO = new CreditCardDAO();
        Transaction transaction = new Transaction();
        System.out.println("please enter credit card number of how you want send money : ");
        while(true) {
            String cc2 = InputArea.getTitle();
            if (creditCardDAO.findByName(cc2).isPresent()) {
                transaction.setCreditCard1(customerAccount.getCreditCard());
                transaction.setCreditCard2(creditCardDAO.findByName(cc2).get());
                break;
            } else {
                System.out.println("this credit card number is wrong");
                System.out.println("do you want try again");
                if(InputArea.getBool()){
                    continue;
                }else{
                    return;
                }
            }
        }
        System.out.println("how much you want to send money");
        long money = InputArea.getLong();
        if(customerAccount.getStock() >= money + 500){
            customerAccount.setStock(customerAccount.getStock() - money + 500);
        }else{
            System.out.println("you have not enough money");
            return;
        }
        transaction.setTransactionTime(new Date());
        transactionDAO.add(transaction);
        customerAccount.getCreditCard().getTransactionList().add(transaction);
        transactionDAO.add(transaction);
    }
}
