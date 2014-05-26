package perceptron_letras;

/**
 *
 * @author Iulisloi Zacarias
 */
public class AssociationLayer {
    
    public InputLayer inputLayer;
    private double sum;

    public AssociationLayer(InputLayer inputLayer) {
        this.inputLayer = inputLayer;
        this.sum = 0;
    }

    public double getSum() {
        this.executeSum();
        return sum;
    }
    
    private void executeSum(){
        this.sum = 0;
        for (int i = 0; i < this.inputLayer.getSize(); i++) {
            sum = sum + (this.inputLayer.getValue(i) * this.inputLayer.getWeight(i));
        }
    }
}
