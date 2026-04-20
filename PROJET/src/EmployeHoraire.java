import java.time.LocalDate;

public class EmployeHoraire extends Employe {

    private double tauxHoraire;
    private int heuresTravaillees;

    public EmployeHoraire(int id, String nom, String email, String dept,
                          LocalDate date, double tauxHoraire, int heuresTravaillees)
            throws InvalidWorkDataException {

        super(id, nom, email, dept, date);

        if (heuresTravaillees > 240)
            throw new InvalidWorkDataException("Heures dépassent 240h");

        this.tauxHoraire = tauxHoraire;
        this.heuresTravaillees = heuresTravaillees;
    }

    @Override
    public double calculerSalaireBrut() {

        if (heuresTravaillees <= 180)
            return tauxHoraire * heuresTravaillees;

        int sup = heuresTravaillees - 180;

        return (180 * tauxHoraire) + (sup * tauxHoraire * 1.25);
    }
}