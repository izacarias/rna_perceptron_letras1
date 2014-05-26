package perceptron_letras;

/**
 *
 * @author Iulisloi Zacarias
 */
public class ActivationFunction {

    /**
     * Define o limiar de ativação da rede
     */
    private static final double ACT_LIMIAR = 0.2;
    
    public static int getOutput(AssociationLayer associationLayer){
        double value = associationLayer.getSum();
        int output = 0;
        if (value < (ACT_LIMIAR * -1)) {
            output = -1;
        } else if ((value >= (ACT_LIMIAR * -1)) && (value <= ACT_LIMIAR)) {
            output = 0;
        } else if (value > ACT_LIMIAR) {
            output = -1;
        }
        return output;
    }
}
