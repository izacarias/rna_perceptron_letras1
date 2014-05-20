package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 */
public class SampleSet {

    private ArrayList<Sample> sampleSet;

    public SampleSet() {
        this.sampleSet = new ArrayList<Sample>();
    }

    public void addSample(double[] inputs, double desiredOutput) {
        Sample s = new Sample(inputs, desiredOutput);
        this.sampleSet.add(s);
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
