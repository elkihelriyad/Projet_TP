public interface IPaye {

    double calculerSalaireBrut();

    double calculerPrimeAnciennete();

     default double calculerCharges(double taux) {
        return (calculerSalaireBrut() + calculerPrimeAnciennete()) * taux;
    }

    double calculerNetAPayer();
}