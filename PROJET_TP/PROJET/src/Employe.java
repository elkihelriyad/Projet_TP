import java.time.LocalDate;

public abstract class Employe implements IPaye {

    protected int id;
    protected String nom;
    protected String email;
    protected String departement;
    protected LocalDate dateEmbauche;

    public Employe(int id, String nom, String email, String departement, LocalDate dateEmbauche) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.departement = departement;
        this.dateEmbauche = dateEmbauche;
    }

    public int getAnciennete() {
        LocalDate today = LocalDate.now();

        int annees = today.getYear() - dateEmbauche.getYear();

        if (today.getMonthValue() < dateEmbauche.getMonthValue() ||
                (today.getMonthValue() == dateEmbauche.getMonthValue()
                        && today.getDayOfMonth() < dateEmbauche.getDayOfMonth())) {
            annees--;
        }

        return annees;
    }

    @Override
    public double calculerPrimeAnciennete() {
        double brut = calculerSalaireBrut();
        int an = getAnciennete();

        if (an < 2) {
            return 0;}
        else if (an <= 5) {
            return brut * 0.05;}
        else {
            return brut * 0.10;}
    }

    @Override
    public double calculerNetAPayer() {
        double brut = calculerSalaireBrut();
        double prime = calculerPrimeAnciennete();
        double charges = calculerCharges(0.20);

        return (brut + prime) - charges;
    }
}