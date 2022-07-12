public class Converter {
    static final double KM = 75 * 0.00_001;
    static final double KCAL = 50 * 0.001;

    double convertStepToCm(int countStep) {
        return countStep * KM;
    }

    double convertStepToCal(int countStep) {
        return countStep * KCAL;
    }

}
