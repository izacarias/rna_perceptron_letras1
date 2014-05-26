package perceptron_and;

import java.util.ArrayList;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Ocr {

    ArrayList<Net> rnaLetras;

    public Ocr(int numberOfCharacters, int bitsPerSymbol) {
        this.rnaLetras = new ArrayList<Net>(bitsPerSymbol);
        for (int i = 0; i < numberOfCharacters; i++) {
            Net n = new Net(bitsPerSymbol);
            this.rnaLetras.add(n);
        }
    }

    public void generateSampleData() {
        SampleSet[] ssData = new SampleSet[3];
        
        int[] DATA_A1 = {-1, -1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, -1, -1, 1, -1, 1, 1, 1, -1, 1, 1, 1};
        int[] DATA_A2 = {-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, -1, -1, 1, -1};
        int[] DATA_A3 = {-1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, 1, 1};

        int[] DATA_B1 = { 1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1};
        int[] DATA_B2 = { 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1};
        int[] DATA_B3 = { 1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1};

        int[] DATA_C1 = {-1, -1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, -1};
        int[] DATA_C2 = {-1, -1, 1, 1, 1, -1, -1, -1, 1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, -1, 1, 1, 1, -1, -1};
        int[] DATA_C3 = {-1, -1, 1, 1, 1, -1, 1, -1, 1, -1, -1, -1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, -1, 1, 1, 1, -1, -1};
        
        ssData[0] = new SampleSet();
        ssData[0].addSample(DATA_A1, 1);
        ssData[0].addSample(DATA_A2, 1);
        ssData[0].addSample(DATA_A3, 1);
        ssData[0].addSample(DATA_B1, -1);
        ssData[0].addSample(DATA_B2, -1);
        ssData[0].addSample(DATA_B3, -1);
        ssData[0].addSample(DATA_C1, -1);
        ssData[0].addSample(DATA_C2, -1);
        ssData[0].addSample(DATA_C3, -1);
        
        ssData[1] = new SampleSet();
        ssData[1].addSample(DATA_A1, -1);
        ssData[1].addSample(DATA_A2, -1);
        ssData[1].addSample(DATA_A3, -1);
        ssData[1].addSample(DATA_B1, 1);
        ssData[1].addSample(DATA_B2, 1);
        ssData[1].addSample(DATA_B3, 1);
        ssData[1].addSample(DATA_C1, -1);
        ssData[1].addSample(DATA_C2, -1);
        ssData[1].addSample(DATA_C3, -1);
        
        ssData[2] = new SampleSet();
        ssData[2].addSample(DATA_A1, -1);
        ssData[2].addSample(DATA_A2, -1);
        ssData[2].addSample(DATA_A3, -1);
        ssData[2].addSample(DATA_B1, -1);
        ssData[2].addSample(DATA_B2, -1);
        ssData[2].addSample(DATA_B3, -1);
        ssData[2].addSample(DATA_C1, 1);
        ssData[2].addSample(DATA_C2, 1);
        ssData[2].addSample(DATA_C3, 1);
        
        for (int ssIndex = 0; ssIndex < ssData.length; ssIndex++) {
            this.rnaLetras.get(ssIndex).train(ssData[ssIndex]);
        }
        
        //this.rnaLetras.get(0).train(ssDataA);
        
        //this.rnaLetras.get(0).test(DATA_A1);
        //this.rnaLetras.get(0).test(DATA_A2);
        //this.rnaLetras.get(0).test(DATA_A3);
        //this.rnaLetras.get(0).test(DATA_B1);
        //this.rnaLetras.get(0).test(DATA_B2);
        //this.rnaLetras.get(0).test(DATA_C1);
        //this.rnaLetras.get(0).test(DATA_C2);
        //this.rnaLetras.get(0).test(DATA_C3);
    }

    public void trainOcr() {

    }
}
