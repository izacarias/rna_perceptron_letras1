package perceptron_and;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Perceptron_AND {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SampleSet setAnd = new SampleSet();
        Net rnaAnd = new Net(2);

        double [][] entradasAnd = {
            {0, 0}, // Output 0
            {0, 1}, // Output 0
            {1, 0}, // Output 0
            {1, 1}  // Output 1
        };
        
        setAnd.addSample(entradasAnd[0], -1);
        setAnd.addSample(entradasAnd[1],  1);
        setAnd.addSample(entradasAnd[2],  1);
        setAnd.addSample(entradasAnd[3],  1);
        
        rnaAnd.train(setAnd);
        
        for (double[] entradaAnd : entradasAnd) {
            rnaAnd.test(entradaAnd);
        }
    }
}
