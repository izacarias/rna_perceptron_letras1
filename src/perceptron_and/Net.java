package perceptron_and;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Net {

    private double bias;
    private final double alpha;
    private final InputLayer inputlayer;
    private boolean weightChange;

    private static final int MAX_EPOCHS = 200;
    private static final double ACT_LIMIAR = 0.2;

    public Net(int inputSize) {
        this.bias = 0;  // set BIAS to "0"
        this.alpha = 1; // set Alpha or Learning Rate to "1
        /* cria uma camada de entrada do tamanho desejado */
        this.inputlayer = new InputLayer(inputSize);
    }

    public boolean train(SampleSet sampleSet) {
        int epoch = 0;
        double y_in;
        int y;

        do {
            // indica se houve alteração de pesos
            this.weightChange = false;

            for (Sample s : sampleSet.getSampleSet()) {
                this.inputlayer.setInput(0, s.getValue(0));
                this.inputlayer.setInput(1, s.getValue(1));
                
                int t = (int) s.getDesiredOutput();

                y_in = bias + this.sumOfNeurons();
                y = this.activatcionFunc(y_in);
                if (y != t) {
                    for (int i = 0; i < this.inputlayer.getSize(); i++) {
                        this.inputlayer.setWeight(i,
                                this.inputlayer.getWeight(i)
                                + (alpha
                                * t
                                * this.inputlayer.getValue(i))
                        );
                    }
                    this.bias = this.bias + alpha * t;
                    this.weightChange = true; // houve alteração de pesos;
                }
            }
            epoch++;
        } while (weightChange && (epoch < MAX_EPOCHS));

        return false;
    }

    public int test(double[] inputs) {
        int result;
        //this.setInputs(input);
        for (int i = 0; i < inputs.length; i++) {
            this.inputlayer.setInput(i, inputs[i]);
        }

        double y_in = bias + this.sumOfNeurons();
        result = this.activatcionFunc(y_in);
        this.imprimeTeste(inputs, result);
        return result;
    }

    private double sumOfNeurons() {
        double sum = 0;
        for (int i = 0; i < this.inputlayer.getSize(); i++) {
            sum = sum + (this.inputlayer.getValue(i) * this.inputlayer.getWeight(i));
        }
        return sum;
    }

    private int activatcionFunc(double value) {
        if (value > ACT_LIMIAR) {
            return 1;
        } else if ((value >= (ACT_LIMIAR * -1)) && (value <= ACT_LIMIAR)) {
            return 0;
        } else if (value < (ACT_LIMIAR * -1)) {
            return -1;
        }
        return 0;
    }

    private void imprimeTeste(double[] inputs, int resultado) {
        for (int i = 0; i < inputs.length; i++) {
            System.out.printf("%2.0f", inputs[i]);
            System.out.print(" | ");
        }
        System.out.printf("%2d", resultado);
        System.out.println();
    }
}