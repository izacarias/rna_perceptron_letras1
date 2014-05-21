package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 */
public class SampleSet {

    private ArrayList<Sample> sampleSet;

    public SampleSet() {
        this.sampleSet = new ArrayList<>();
    }

    public void addSample(int[] inputs, int desiredOutput) {
        Sample s = new Sample(inputs, desiredOutput);
        this.sampleSet.add(s);
    }
    
    public void addSample(int input1, int input2, int desiredOutput){
        int[] inputs = {input1, input2};
        this.addSample(inputs, desiredOutput);
    }

    public ArrayList<Sample> getSampleSet() {
        return sampleSet;
    }

    public Sample getSample(int index) {
        return this.sampleSet.get(index);
    }

    public void setSampleSet(ArrayList<Sample> sampleSet) {
        this.sampleSet = sampleSet;
    }
}
