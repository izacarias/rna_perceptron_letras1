package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import perceptron_letras.Ocr;

/**
 *
 * @author iulisloi
 */
public class MainUserInterface extends javax.swing.JFrame {

    private static String DIR_BASE
            = "/home/iulisloi/NetBeansProjects/rna_perceptron_letras1/src";
    private String DIR_TRAIN = DIR_BASE + "/Treinamento";
    private String DIR_TEST = DIR_BASE + "/Teste";
    private boolean baseTreinada;

    Ocr ocrEngine;

    /**
     * Creates new form MainUserInterface
     */
    public MainUserInterface() {
        initComponents();

        this.setResizable(false);
        this.setLocationRelativeTo(null);

        /* Seleciona os diretórios da aplicação */
        this.selectImageDirectories();

        this.listFilesToRecognize();
        ocrEngine = new Ocr(26, 900); // 26 letras com 900 pixels cada
        this.baseTreinada = false;
        this.jBtnReconhecer.setEnabled(this.baseTreinada);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnTreinar = new javax.swing.JButton();
        jProgressBarTreinar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jCbSelecionarLetra = new javax.swing.JComboBox();
        jLblImagemLetra = new javax.swing.JLabel();
        jBtnReconhecer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLblRecognizedChar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OCR Simples");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Treinamento"));

        jBtnTreinar.setText("Treinar");
        jBtnTreinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTreinarActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("OBS: Antes de tentar reconhecer um caractere clique no botão \"Treinar\" acima.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setSelectionEnd(0);
        jTextArea1.setSelectionStart(0);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtnTreinar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(jProgressBarTreinar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtnTreinar, jProgressBarTreinar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jBtnTreinar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBarTreinar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Reconhecimento"));

        jCbSelecionarLetra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbSelecionarLetraItemStateChanged(evt);
            }
        });
        jCbSelecionarLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbSelecionarLetraActionPerformed(evt);
            }
        });

        jLblImagemLetra.setBackground(java.awt.Color.white);
        jLblImagemLetra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblImagemLetra.setOpaque(true);

        jBtnReconhecer.setText("Reconhecer");
        jBtnReconhecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnReconhecerActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Caractere reconhecido:");

        jLblRecognizedChar.setBackground(java.awt.Color.lightGray);
        jLblRecognizedChar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLblRecognizedChar.setForeground(java.awt.Color.red);
        jLblRecognizedChar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblRecognizedChar.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtnReconhecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCbSelecionarLetra, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblImagemLetra, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLblRecognizedChar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jCbSelecionarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblImagemLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnReconhecer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblRecognizedChar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OCR Simples");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbSelecionarLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbSelecionarLetraActionPerformed

    }//GEN-LAST:event_jCbSelecionarLetraActionPerformed

    private void jCbSelecionarLetraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbSelecionarLetraItemStateChanged
        File imageFile = new File(DIR_TEST, jCbSelecionarLetra.getSelectedItem().toString());
        try {
            BufferedImage characterImage = ImageIO.read(imageFile);
            jLblImagemLetra.setIcon(new ImageIcon(characterImage));
        } catch (IOException ex) {
            Logger.getLogger(MainUserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCbSelecionarLetraItemStateChanged

    private void jBtnTreinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTreinarActionPerformed
        try {
            ocrEngine.generateSampleData(DIR_TRAIN, jProgressBarTreinar);
            this.baseTreinada = true;
            this.jBtnReconhecer.setEnabled(baseTreinada);
        } catch (IOException ex) {
            Logger.getLogger(MainUserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnTreinarActionPerformed

    private void jBtnReconhecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnReconhecerActionPerformed
        String recognizedChar = this.recognizeCharacter(
                jCbSelecionarLetra.getSelectedItem().toString());
        jLblRecognizedChar.setText(recognizedChar);
    }//GEN-LAST:event_jBtnReconhecerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUserInterface().setVisible(true);
            }
        });
    }

    private void listFilesToRecognize() {
        //jCbSelecionarLetra.removeAllItems();
        ArrayList<String> fileNames = new ArrayList<String>();
        File[] files = new File(DIR_TEST).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                // fileNames.add(file.getName());
                jCbSelecionarLetra.addItem(file.getName());
            }
        }
    }

    private String recognizeCharacter(String fileName) {
        int[] bitMapLetra = new int[900];
        String recognizedChar;
        File imageFile = new File(DIR_TEST, fileName);
        BufferedImage image;
        try {
            image = ImageIO.read(imageFile);
            int counter = 0;
            for (int j = 0; j < image.getHeight(); j++) {
                for (int k = 0; k < image.getWidth(); k++) {
                    bitMapLetra[counter] = (image.getRGB(k, j) < -8388608) ? 1 : -1;
                    counter++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainUserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ocrEngine.recognizeCharacter(bitMapLetra);
    }

    private String selectDirectory(String dialogTitle) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src"));
        chooser.setDialogTitle(dialogTitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnReconhecer;
    private javax.swing.JButton jBtnTreinar;
    private javax.swing.JComboBox jCbSelecionarLetra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblImagemLetra;
    private javax.swing.JLabel jLblRecognizedChar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBarTreinar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void selectImageDirectories() {
        JOptionPane.showMessageDialog(this,
                "Selecione o diretório que contém as imagens de TREINAMENTO.");
        do {
            this.DIR_TRAIN = selectDirectory(
                    "Diretório com imagens de treinamento");

            if ((this.DIR_TEST.isEmpty()) || (this.DIR_TRAIN.isEmpty())) {
                JOptionPane.showMessageDialog(this,
                        "Você não selecionou o diretório com imagens de treinamento. \n"
                        + "Não é possível continuar sem selecioná-lo!");
            }
        } while (this.DIR_TRAIN.isEmpty());

        JOptionPane.showMessageDialog(this,
                "Selecione o diretório que contém as imagens de TESTE.");
        do {
            this.DIR_TEST = selectDirectory(
                    "Diretório com imagens de teste");
            if ((this.DIR_TEST.isEmpty()) || (this.DIR_TRAIN.isEmpty())) {
                JOptionPane.showMessageDialog(this,
                        "Você não selecionou o diretório com imagens de testes. \n"
                        + "Não é possível continuar sem selecioná-lo!");
            }
        } while (this.DIR_TRAIN.isEmpty());
    }
}
