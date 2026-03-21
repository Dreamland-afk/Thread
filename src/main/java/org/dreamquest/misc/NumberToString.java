package org.dreamquest.misc;

import java.util.Map;

public class NumberToString {

    static final Map<Integer,String>  ones = Map.of(0,"",1,"One ",2,"Two ",3,"Three ",4,"Four ",
            5,"Five ",6,"Six ",7,"Seven ",8,"Eight ",9,"Nine ");
    static final Map<Integer,String> tens = Map.of(10,"Ten ",11,"Eleven ",12,"Twelve ",13,"Thirteen ",14,"Fourteen ",
            15,"Fifteen ", 16,"Sixteen ",17,"Seventeen ",18,"Eighteen ",19,"Nineteen ");

    static final Map<Integer,String> tensMultiple = Map.of(2,"Twenty ",3,"Thirty ",4,"Forty ",5,"Fifty ",
            6,"Sixty ",7,"Seventy ",8,"Eighty ",9,"Ninety ");

    static final Map<Integer,String> powerOfTen = Map.of(100,"Hundred ",1000,"Thousand ");


    int[] devisor = {1000,100,10};

    public String numberToWords(int num, String output) {

        if ( ones.containsKey(num)){
            return output + ones.get(num);
        }
        if ( tens.containsKey(num)){
            return output + tens.get(num);
        }

        else{

            for (int j : devisor) {
                if (num >= j) {
                    int quotient = num / j;
                    int remainder = num % j;
                    if(num >= 100)
                        output = output + numberToWords(quotient, "") + powerOfTen.getOrDefault(j, "");
                    else
                        output = output + tensMultiple.getOrDefault(quotient, "");

                    return numberToWords(remainder, output);
                }
            }

        }
        return output;
    }
    public static void main(String[] args) {

        NumberToString checker = new NumberToString();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + " : " + checker.numberToWords(i, ""));
        }

    }
}
