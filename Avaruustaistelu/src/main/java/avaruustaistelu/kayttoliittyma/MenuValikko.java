package avaruustaistelu.kayttoliittyma;

import avaruustaistelu.avaruustaistelu.Avaruustaistelu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 * Java Swing Menu -valikko.
 * 
 * @author Jyri
 */
public class MenuValikko extends javax.swing.JFrame {

    /**
     * Creates new form MenuValikko.
     */
    public MenuValikko() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1Valikko = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2Ohjeet = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3Ennatykset = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel2Eka = new javax.swing.JLabel();
        jLabel3Toka = new javax.swing.JLabel();
        jLabel4Kolmas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Avaruustaistelu");
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1Valikko.setMaximumSize(new java.awt.Dimension(600, 600));
        jPanel1Valikko.setMinimumSize(new java.awt.Dimension(600, 600));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Whimsy TT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Avaruustaistelu");
        jLabel1.setMaximumSize(new java.awt.Dimension(350, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(350, 100));
        jLabel1.setPreferredSize(new java.awt.Dimension(350, 100));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("AcmeFont", 0, 18)); // NOI18N
        jButton1.setText("Aloita peli");
        jButton1.setMaximumSize(new java.awt.Dimension(135, 65));
        jButton1.setMinimumSize(new java.awt.Dimension(135, 65));
        jButton1.setPreferredSize(new java.awt.Dimension(135, 65));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 51));
        jButton2.setFont(new java.awt.Font("AcmeFont", 0, 18)); // NOI18N
        jButton2.setText("Ohjeet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 255, 255));
        jButton3.setFont(new java.awt.Font("AcmeFont", 0, 18)); // NOI18N
        jButton3.setText("Ennätykset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setFont(new java.awt.Font("AcmeFont", 0, 18)); // NOI18N
        jButton4.setText("Lopeta peli");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1ValikkoLayout = new javax.swing.GroupLayout(jPanel1Valikko);
        jPanel1Valikko.setLayout(jPanel1ValikkoLayout);
        jPanel1ValikkoLayout.setHorizontalGroup(
            jPanel1ValikkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1ValikkoLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(jPanel1ValikkoLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addGroup(jPanel1ValikkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1ValikkoLayout.setVerticalGroup(
            jPanel1ValikkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1ValikkoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1Valikko, "card2");

        jPanel2Ohjeet.setMaximumSize(new java.awt.Dimension(600, 600));
        jPanel2Ohjeet.setMinimumSize(new java.awt.Dimension(600, 600));

        jButton5.setBackground(new java.awt.Color(102, 255, 51));
        jButton5.setFont(new java.awt.Font("AcmeFont", 0, 18)); // NOI18N
        jButton5.setText("Takaisin valikkoon");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Ohjeet");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 255, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("-Pelaaja liikkuttaa avaruusalusta oikealle \"D\" näppäimestä ja \n vasemmalle \"A\" näppäimestä. Avaruusalus ampuu ohjuksia \"H\"\n näppäimestä.\n\n-Pelaaja ei saa osua avaruusaluksella meteoroidiin tai päästää\n ohitseen meteoroideja niin, että elämäpisteet menevät\n nollaan, muuten peli päättyy. Jokaisesta ohi päästetystä\n meteoroidista avaruusalus menettää yhden (1) elämäpisteen.\n\n-Meteoroidit tuhoutuvat viidestä (5) ohjuksen osumasta.\n\n-Pelaaja saa yhden (1) pisteen jokaisesta tuhotusta\n meteoroidista.\n\n-Pelaaja voi tankata elämäpisteitään keräämällä\n elämäpaketteja.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2OhjeetLayout = new javax.swing.GroupLayout(jPanel2Ohjeet);
        jPanel2Ohjeet.setLayout(jPanel2OhjeetLayout);
        jPanel2OhjeetLayout.setHorizontalGroup(
            jPanel2OhjeetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2OhjeetLayout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(jPanel2OhjeetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2OhjeetLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2OhjeetLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(192, 192, 192))))
        );
        jPanel2OhjeetLayout.setVerticalGroup(
            jPanel2OhjeetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2OhjeetLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2Ohjeet, "card3");

        jPanel3Ennatykset.setMaximumSize(new java.awt.Dimension(600, 600));
        jPanel3Ennatykset.setMinimumSize(new java.awt.Dimension(600, 600));

        jButton6.setBackground(new java.awt.Color(51, 255, 255));
        jButton6.setFont(new java.awt.Font("AcmeFont", 0, 18)); // NOI18N
        jButton6.setText("Takaisin valikkoon");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2Eka.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2Eka.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2Eka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3Toka.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3Toka.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3Toka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4Kolmas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4Kolmas.setForeground(new java.awt.Color(204, 102, 0));
        jLabel4Kolmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setBackground(new java.awt.Color(0, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Ennätykset");

        javax.swing.GroupLayout jPanel3EnnatyksetLayout = new javax.swing.GroupLayout(jPanel3Ennatykset);
        jPanel3Ennatykset.setLayout(jPanel3EnnatyksetLayout);
        jPanel3EnnatyksetLayout.setHorizontalGroup(
            jPanel3EnnatyksetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3EnnatyksetLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(jPanel3EnnatyksetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4Kolmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3Toka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2Eka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(195, 195, 195))
        );
        jPanel3EnnatyksetLayout.setVerticalGroup(
            jPanel3EnnatyksetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3EnnatyksetLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel2Eka, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3Toka, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4Kolmas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel3Ennatykset, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * JButton, jolla aloitetaan uusi peli.
     * 
     * @param evt Painettu näppäin
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            
            public void sleep(int aikaMillisekunteina) {
                try {
                    Thread.sleep(aikaMillisekunteina);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MenuValikko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            protected Void doInBackground() throws Exception {
                Avaruustaistelu avaruustaistelu = new Avaruustaistelu();
                Kayttoliittyma kayttoliittyma = new Kayttoliittyma(avaruustaistelu);
                SwingUtilities.invokeLater(kayttoliittyma);
                
                while (kayttoliittyma.getPiirtoalusta() == null) {
                    sleep(100);
                }
                
                avaruustaistelu.setPiirtoalusta(kayttoliittyma.getPiirtoalusta());
                avaruustaistelu.pelinLoop();
                return null;
            }
            
        };
        
        swingWorker.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * JButton, jolla pääsee valikosta ohjeisiin.
     * 
     * @param evt Painettu näppäin
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.jPanel1Valikko.setVisible(false);
        this.jPanel2Ohjeet.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * JButton, jolla lopetetaan peli, eli suljetaan ohjelma.
     * 
     * @param evt Painettu näppäin
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * JButton, jolla pääsee ohjeista takaisin valikkoon.
     * 
     * @param evt Painettu näppäin
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.jPanel2Ohjeet.setVisible(false);
        this.jPanel1Valikko.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * JButton, jolla pääsee valikosta ennätyksiin.
     * 
     * @param evt Painettu näppäin
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        paivitaEnnatykset();
        this.jPanel1Valikko.setVisible(false);
        this.jPanel3Ennatykset.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * JButton, jolla pääsee ennätyksistä takaisin valikkoon.
     * 
     * @param evt Painettu näppäin
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:        
        this.jPanel3Ennatykset.setVisible(false);
        this.jPanel1Valikko.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * Metodi, jota kutsutaan kun siirrytään valikosta ennätyksiin. Päivittää tiedostosta
     * sen hetkiset ennätyspisteet.
     */
    public void paivitaEnnatykset() {
        File tiedosto = new File("./ennatykset/ennatykset.txt");

        try {
            Scanner lukija = new Scanner(tiedosto.getAbsoluteFile());
            int ensimmainenSija = Integer.parseInt(lukija.nextLine());
            int toinenSija = Integer.parseInt(lukija.nextLine());
            int kolmasSija = Integer.parseInt(lukija.nextLine());
            this.jLabel2Eka.setText("1. sija: " + ensimmainenSija);
            this.jLabel3Toka.setText("2. sija: " + toinenSija);
            this.jLabel4Kolmas.setText("3. sija: " + kolmasSija);
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.print(e);
        }
    }
    
    /**
     * Main.
     * 
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
            java.util.logging.Logger.getLogger(MenuValikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuValikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuValikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuValikko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuValikko().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2Eka;
    private javax.swing.JLabel jLabel3Toka;
    private javax.swing.JLabel jLabel4Kolmas;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1Valikko;
    private javax.swing.JPanel jPanel2Ohjeet;
    private javax.swing.JPanel jPanel3Ennatykset;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
