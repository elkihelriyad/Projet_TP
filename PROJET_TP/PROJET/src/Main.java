import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {

            Employe e1 = new EmployeFixe(
                    1,
                    "Riyad",
                    "elkihelriyad@gmail.com",
                    "IT",
                    LocalDate.of(2020, 1, 10),
                    8000,
                    1000
            );

            Employe e2 = new EmployeHoraire(
                    2,
                    "Taha",
                    "taha@gmail.com",
                    "Relation externe",
                    LocalDate.of(2022, 6, 5),
                    50,
                    190
            );


            System.out.println("===== RESULTATS PAIE =====");

            System.out.println("Employé 1 (Fixe) :");
            System.out.println("Brut = " + e1.calculerSalaireBrut());
            System.out.println("Prime ancienneté = " + e1.calculerPrimeAnciennete());
            System.out.println("Net à payer = " + e1.calculerNetAPayer());

            System.out.println("\nEmployé 2 (Horaire) :");
            System.out.println("Brut = " + e2.calculerSalaireBrut());
            System.out.println("Prime ancienneté = " + e2.calculerPrimeAnciennete());
            System.out.println("Net à payer = " + e2.calculerNetAPayer());

        } catch (InvalidWorkDataException e) {
            System.out.println("Erreur de validation : " + e.getMessage());
        }
    }
}