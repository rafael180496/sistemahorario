package com.horario.upoli.horario;

public class Pruebas {

    public static void main(String[] args) {
        String n1="l";
        String n2="ro";
        String n[]={"RAafel","rafa","LOL","R"};

        for (String m:n
             ) {
            if((n1.compareToIgnoreCase(m)<=4) &&(n1.compareToIgnoreCase(m)>=-4))
            {
                System.out.println("entra="+m+"["+n1.compareToIgnoreCase(m)+"]");
            }


        }


    }
}
