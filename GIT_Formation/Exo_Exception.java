import java.util.ArrayList;
import java.util.Scanner;

public class Exo_Exception {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);

        ArrayList <Integer> table = new ArrayList<>();

        while(true)
        {
            try
            {
            System.out.println("Veuillez entrez un nombre (tapez q pour quitter)");

            var number = input.nextLine();

            if(number.equalsIgnoreCase("q"))
            {
                break;
            }

            var firstNumber = (Integer.parseInt(number));

            if (table.contains(firstNumber))
            {
                System.out.println("Chiffre deja ajoute a la saisie ");
            }
            else
            {
                table.add(firstNumber);
            }
            System.out.println(table);
        }
            catch (NumberFormatException e)
            {
                System.out.println("L'erreur est " + e);
            }
        }

        System.out.println("Le tableau saisi est : \n" +table);

        System.out.printf("Vous avez saisi %d nombres",table.size());

    }
}