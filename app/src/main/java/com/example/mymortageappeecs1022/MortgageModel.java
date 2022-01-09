package com.example.mymortageappeecs1022;

import static java.lang.Integer.parseInt;
public class MortgageModel
{
    private double principle,  interest;
    private int amortization;
    public MortgageModel (String p, String a, String i)
    {
        this.principle = Double.parseDouble(p);
        this.amortization = parseInt(a);
        this.interest = Double.parseDouble(i);
    }
    public String computePayment()
    {
        double p = this.principle;
        int n = (this.amortization)*12;
        double r = (this.interest)/1200;
        double a = (r*p);
        double b = Math.pow(1+r,-n);
        double answer = a / ( 1 - b) ;
        String result = String.format("$%,.2f", answer);
        return result;
    }
}
















