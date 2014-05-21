package perceptron_and;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Perceptron_AND {

    private static Net rnaAnd;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        rnaAnd = new Net(2);
        Perceptron_AND.trainRNA();
        Perceptron_AND.testRNA();
    }

    public static void trainRNA() {
        SampleSet setAnd = new SampleSet();
        int[][] entradasAnd = {
            {0, 0}, // Output 0
            {0, 1}, // Output 0
            {1, 0}, // Output 0
            {1, 1}  // Output 1
        };

        int[] saidasAnd = {
            -1,
            -1,
            -1,
            1
        };

        for (int i = 0; i < entradasAnd.length; i++) {
            setAnd.addSample(entradasAnd[i], saidasAnd[i]);
        }
        rnaAnd.train(setAnd);
    }

    public static void testRNA() {
        int[] entrada1 = {0, 0};
        int[] entrada2 = {0, 1};
        int[] entrada3 = {1, 0};
        int[] entrada4 = {1, 1};
        
        rnaAnd.test(entrada1);
        rnaAnd.test(entrada2);
        rnaAnd.test(entrada3);
        rnaAnd.test(entrada4);
    }
}
