import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CosNaming.*;
import TempApp.*;

import java.util.Scanner;

public class TempAppClient {

    public static void main(String[] args) {

        try {
            ORB orb = ORB.init(args, null);
            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            TempChecker tempChecker = (TempChecker) TempCheckerHelper.narrow(ncRef.resolve_str("App"));

            Scanner sc = new Scanner(System.in);
            System.out.println("Bem vindo ao sistema de controle de temperaturas! ");
            System.out.println("Escolha uma opção para continuar: ");

            boolean aux = false;
            while (!aux){
                System.out.println("1 - Listar paises e suas temperaturas medias.");
                System.out.println("2 - Faça a conversão da temperatura de um pais de Celsius para Fahrenheit.");
                System.out.println("0 - Sair.");

                switch (sc.nextInt()){
                    case 0:
                        System.out.println ("Até mais!");
                        aux = true;
                        break;

                    case 1:
                        System.out.println(tempChecker.getCountries());
                        break;

                    case 2:
                        boolean t = false;
                        String valueInput = "";
                        System.out.println("Insira o nome do pais que deseja converter a temperatura");
                        while (!t){
                            valueInput = sc.next();
                            if (valueInput.equalsIgnoreCase("brasil") ||
                                    valueInput.equalsIgnoreCase("argentina") ||
                                    valueInput.equalsIgnoreCase("chile")){
                                t = true;
                            }else{
                                System.out.println("Nome invalido, escolha um pais da lista.");
                            }

                        }
                        System.out.println("");
                        System.out.println("A temperatura media em Fahrenheit é de: "+tempChecker.convertCelsiusToF(valueInput));
                        System.out.println("");
                        System.out.println(" --------------------------------------------------- ");
                        break;
                }

                Thread.sleep(1000);
                System.out.println();

            }



        } catch (Exception e) {
            System.out.println("ERROR : " + e) ;
            e.printStackTrace(System.out);
        }
    }
}
