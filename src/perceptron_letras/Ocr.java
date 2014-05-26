package perceptron_letras;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

/**
 *
 * @author Iulisloi Zacarias
 */
public class Ocr {

    private ArrayList<Perceptron> perceptronLetras;
    private static final String[] alphabeto = {"A", "B", "C", "D", "E", "F",
        "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y", "Z"};
    private int numberOfCharacters;

    public Ocr(int numberOfCharacters, int bitsPerSymbol) {
        this.perceptronLetras = new ArrayList<Perceptron>(bitsPerSymbol);
        for (int i = 0; i < numberOfCharacters; i++) {
            Perceptron n = new Perceptron(bitsPerSymbol);
            this.perceptronLetras.add(n);
        }
        this.numberOfCharacters = numberOfCharacters;
    }

    public void generateSampleData(String train_directory, 
            JProgressBar progressBar) throws IOException {
        
        SampleSet[] ssData = new SampleSet[numberOfCharacters];

        // faz uma lista dos arquivos no diretório de treinamento
        ArrayList<String> fileNames = new ArrayList<String>();
        File[] files = new File(train_directory).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }
        
        // seta o valor máximo da progress bar
        progressBar.setMaximum(alphabeto.length * fileNames.size());
        progressBar.setValue(0);

        // varre cada letra do alfabeto, se o padrão for igual ao da letra que
        // está sendo treinada seta a saída desejada como 1, caso o padrão for
        // de outra letra, seta a saída desejada para -1
        for (int i = 0; i < alphabeto.length; i++) {
            ssData[i] = new SampleSet();
            for (String fileName : fileNames) {
                /* Armazena o bitmap do arquivo com 1 e -1 */
                int[] bitMapLetra = new int[900];
                // abre a imagem cada imagem da lista de arquivos
                try {
                    File imageFile = new File(train_directory, fileName);
                    BufferedImage image = ImageIO.read(imageFile);
                    int counter = 0;
                    for (int j = 0; j < image.getHeight(); j++) {
                        for (int k = 0; k < image.getWidth(); k++) {
                            bitMapLetra[counter] = (image.getRGB(k, j) < -8388608) ? 1 : -1;
                            counter++;
                        }
                    }

                    // informações de treinamento
                    if (fileName.startsWith(alphabeto[i].toLowerCase())) {
                        ssData[i].addSample(bitMapLetra, 1);
                    } else {
                        ssData[i].addSample(bitMapLetra, -1);
                    }
                    
                    // avança a progressbar
                    progressBar.setValue(progressBar.getValue() + 1);
                    progressBar.update(progressBar.getGraphics());
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int ssIndex = 0; ssIndex < ssData.length; ssIndex++) {
            this.perceptronLetras.get(ssIndex).train(ssData[ssIndex]);
        }
    }

    public String recognizeCharacter(int[] input) {

        for (int i = 0; i < this.perceptronLetras.size(); i++) {
            if (this.perceptronLetras.get(i).run(input) == 1) {
                return alphabeto[i];
            }
        }
        return "Letra desconhecida";
    }
}
