package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this
        List<Customer> customers = new ArrayList<>();
        List<Customer> positives = new ArrayList<>();
        List<Customer> negatives = new ArrayList<>();


        for (String[] m : customerData){
            boolean decision = false;
            Customer account = new Customer(Integer.parseInt(m[0]), m[1]);
            if (customers.isEmpty()){
                customers.add(account);
            }
            for (Customer u : customers){
                if (u.getId() == account.getId()){
                    decision = true;
                    AccountRecord a = new AccountRecord();
                    a.setCharge(Integer.parseInt(m[2]));
                    a.setChargeDate(m[3]);
                    u.getCharges().add(a);
                    continue;
                }

            }
            if (decision == false){
                customers.add(account);
                AccountRecord a = new AccountRecord();
                a.setCharge(Integer.parseInt(m[2]));
                a.setChargeDate(m[3]);
                account.getCharges().add(a);
            }
        }

        for (Customer p : customers){
            if (p.getBalance() >= 0){
                positives.add(p);
            }
            else{
                negatives.add(p);
            }
        }

        System.out.println("Positive accounts:");
        for (Customer p : positives){
            System.out.println(p.toString());
        }
        System.out.println("Negative accounts:");
        for (Customer p : negatives){
            System.out.println(p.toString());
        }
    }
}
