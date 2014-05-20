package perceptron_and;

/**
 * Classe com amostras para o treinamento
 * @author Iulisloi Zacarias
 */
public class Sample {
    
    private double[] inputs;
    private double desiredOutput;

    public Sample(double[] inputs, double desiredOutput) {
        this.inputs = inputs;
        this.desiredOutput = desiredOutput;
    }
    
    public double setValue(int index, double value){
        return this.inputs[index] = value;
    }

    public double getValue(int index) {
        return this.inputs[index];
    }
    
    public void setDesiredOutput(double desiredOutput) {
        this.desiredOutput = desiredOutput;
    }

    public double getDesiredOutput() {
        return desiredOutput;
    }
}