package perceptron_and;

/**
 * Classe com amostras para o treinamento
 * @author Iulisloi Zacarias
 */
public class Sample {
    
    private final int[] inputs;
    private int desiredOutput;

    public Sample(int[] inputs, int desiredOutput) {
        this.inputs = inputs;
        this.desiredOutput = desiredOutput;
    }
    
    public void setValue(int index, int value){
        this.inputs[index] = value;
    }

    public int getValue(int index) {
        return this.inputs[index];
    }
    
    public void setDesiredOutput(int desiredOutput) {
        this.desiredOutput = desiredOutput;
    }

    public int getDesiredOutput() {
        return desiredOutput;
    }
    
    public int getInputsLenght(){
        return this.inputs.length;
    }
}