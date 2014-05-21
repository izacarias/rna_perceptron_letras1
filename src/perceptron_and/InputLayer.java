package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 */
public class InputLayer {

    private final ArrayList<Neuron> neurons;

    public InputLayer(int inputSize) {
        this.neurons = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            Neuron n = new Neuron();
            this.neurons.add(n);
        }
    }

    public ArrayList<Neuron> getInputLayer() {
        return neurons;
    }

    public int getSize() {
        return this.neurons.size();
    }

    public void setInput(int index, int value) {
        this.neurons.get(index).setValue(value);
    }

    public void setWeight(int index, double weight) {
        this.neurons.get(index).setWeight(weight);
    }

    public double getValue(int index) {
        return this.neurons.get(index).getValue();
    }

    public double getWeight(int index) {
        return this.neurons.get(index).getWeight();
    }
}
