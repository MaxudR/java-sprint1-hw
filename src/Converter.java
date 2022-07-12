public class Converter {
    static final double KM = 75 * 0.00_001; //перевод шагов в километры из расчета что в одном шаге 75 см
    static final double KCAL = 50 * 0.001; //перевод шагов в килокалории из расчета что в одном шаге 50 кал

    double convertStepToCm(int countStep) {
        return countStep * KM;
    }

    double convertStepToCal(int countStep) {
        return countStep * KCAL;
    }

}
