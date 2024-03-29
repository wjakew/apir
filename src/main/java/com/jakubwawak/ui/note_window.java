/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package com.jakubwawak.ui;

import com.jakubwawak.ui_maintenance.message_window;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *Object for creating note window
 * @author kubaw
 */
public class note_window extends javax.swing.JFrame {

    String note;
    /**
     * Creates new form note_window
     */
    public note_window(JFrame parent,String note) {
        initComponents();
        this.note = note;
        this.setLocationRelativeTo(parent);
        load_window();
        setVisible(true);
    }
    
    /**
     * Function for loading window icon
     */
    void load_window_icon(){
        try{
            ImageIcon img = new ImageIcon("apir_icon.png");
            this.setIconImage(img.getImage());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Function for loading window
     */
    void load_window(){
        load_window_icon();
        field_note.setText(note);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        field_note = new javax.swing.JTextArea();
        button_savetofile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Note");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        field_note.setColumns(20);
        field_note.setRows(5);
        jScrollPane1.setViewportView(field_note);

        button_savetofile.setText("Save to file");
        button_savetofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_savetofileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button_savetofile)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_savetofile)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_savetofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_savetofileActionPerformed
        try {
            FileWriter fw = new FileWriter("apir_note.txt");
            note = field_note.getText();
            fw.write(note);
            fw.close();
            new message_window(this,true,"Saved to file!","");
        } catch (IOException ex) {
            new message_window(this,true,"Failed to save note to file\n"+ex.toString(),"");
        }
    }//GEN-LAST:event_button_savetofileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        note = field_note.getText();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_savetofile;
    private javax.swing.JTextArea field_note;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
