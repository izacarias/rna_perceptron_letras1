package perceptron_and;

/**
 *
 * @author Iulisloi Zacarias
 */
public class InputLayer {
    
    private Neuron[] neurons;
    private int size;

    public InputLayer(int inputSize) {
        this.neurons = new Neuron[inputSize];
        this.size = inputSize;
        for (int i = 0; i < this.neurons.length; i++) {
            this.neurons[i] = new Neuron();
        }
    }
    
    public Neuron[] getInputLayer() {
        return neurons;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setInput(int index, double value){
        this.neurons[index].setValue(value);
    }
    
    public void setWeight(int index, double weight){
        this.neurons[index].setWeight(weight);
    }
    
    public double getValue(int index){
        return this.neurons[index].getValue();
    }
    
    public double getWeight(int index){
        return this.neurons[index].getWeight();
    }
}
