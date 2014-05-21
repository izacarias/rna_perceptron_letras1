package perceptron_and;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Neuron {

    private int value;
    private double weight;

    public Neuron() {
        this.value = 0;
        this.weight = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
