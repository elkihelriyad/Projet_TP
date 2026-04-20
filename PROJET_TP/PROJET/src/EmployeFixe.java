import java.time.LocalDate;

public class EmployeFixe extends Employe {

    private double salaireBase;
    private double primePerformance;

    public EmployeFixe(int id, String nom, String email, String dept,
                       LocalDate date, double salaireBase, double primePerformance)
            throws InvalidWorkDataException {

        super(id, nom, email, dept, date);

        if (salaireBase < 3000)
            throw new InvalidWorkDataException("Salaire inférieur au SMIG");

        this.salaireBase = salaireBase;
        this.primePerformance = primePerformance;
    }

    @Override
    public double calculerSalaireBrut() {
        return salaireBase + primePerformance;
    }
}