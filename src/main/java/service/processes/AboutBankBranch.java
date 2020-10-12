package service.processes;

import repository.DAOEntites.BankBranchDAO;
import service.entities.BankBranch;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class AboutBankBranch {
    public static void showBankInfo(BankBranch bankBranch){
        System.out.println("------------------------ branch "+bankBranch.getBranchNumber() +" ------------------------");
        System.out.println("branch name : " + bankBranch.getName());
        System.out.println("manager of branch : " + bankBranch.getBankManager());
        System.out.println("------------------------------------------------------------------");
    }
    public static Map<Integer,BankBranch> showAllBanks(){
        BankBranchDAO bankBranchDAO = new BankBranchDAO();
        Map<Integer,BankBranch> map = new TreeMap<>();
        for(BankBranch b : bankBranchDAO.findAll(a -> true)){
            map.put(b.getBranchNumber(),b);
            showBankInfo(b);
        }
        return map;
    }
}
