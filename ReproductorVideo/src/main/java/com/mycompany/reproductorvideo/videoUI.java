/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reproductorvideo;

import java.awt.BorderLayout;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author DELL
 */
public class videoUI extends javax.swing.JFrame {
    private String filePath = null;
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
  
    /**
     * Creates new form videoUI
     */
    public videoUI() {
        initComponents();
         setLayout(new BorderLayout());

         
        JFXPanel fxPanel = new JFXPanel();
        jPanel4.add(fxPanel, BorderLayout.CENTER);

        mediaView = new MediaView();
        Group root = new Group(mediaView);
        Scene scene = new Scene(root);
        fxPanel.setScene(scene);
        
        
       
        
        
    }


 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        vol = new javax.swing.JSlider();
        reprod = new javax.swing.JToggleButton();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        open = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(255, 102, 102));
        exit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jPanel2.setBackground(new java.awt.Color(68, 105, 215));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 180));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vol.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volStateChanged(evt);
            }
        });
        jPanel3.add(vol, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, -1));

        reprod.setText("reproducir");
        reprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reprodActionPerformed(evt);
            }
        });
        jPanel3.add(reprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        back.setText("atras");
        jPanel3.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        next.setText("delante");
        jPanel3.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        open.setBackground(new java.awt.Color(0, 204, 102));
        open.setForeground(new java.awt.Color(255, 255, 255));
        open.setText("abrir");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jPanel3.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel3.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 400, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
   JFileChooser fileChooser = new JFileChooser();
int result = fileChooser.showOpenDialog(this);

if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    filePath = selectedFile.getAbsolutePath();

    if (filePath != null && !filePath.isEmpty()) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }

        Media media = new Media(new File(filePath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
        mediaView.setFitHeight(jPanel4.getHeight());
        mediaView.setFitWidth(jPanel4.getWidth());

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        // Obtén la duración del video y configura los valores del JSlider
          Duration duration = media.getDuration();
            jSlider1.setMinimum(0);
            jSlider1.setMaximum((int) duration.toSeconds());

            // Agrega un ChangeListener al JSlider
            jSlider1.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (mediaPlayer != null) {
                        mediaPlayer.seek(Duration.seconds(jSlider1.getValue()));
                    }
                }
            });
    }
}
    }//GEN-LAST:event_openActionPerformed

    private void reprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reprodActionPerformed
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                reprod.setText("Reanudar");
            } else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play();
                reprod.setText("Reproducir");
            }
        }
    }//GEN-LAST:event_reprodActionPerformed

    private void volStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volStateChanged
       int volume = vol.getValue();

    double volumeValue = volume / 100.0;
    
     if (mediaPlayer != null) {
        mediaPlayer.setVolume(volumeValue);
     }
    }//GEN-LAST:event_volStateChanged

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       dispose();
    }//GEN-LAST:event_exitActionPerformed

    
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
            java.util.logging.Logger.getLogger(videoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(videoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(videoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(videoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new videoUI().setVisible(true);
     
    }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton next;
    private javax.swing.JButton open;
    private javax.swing.JToggleButton reprod;
    private javax.swing.JSlider vol;
    // End of variables declaration//GEN-END:variables
}