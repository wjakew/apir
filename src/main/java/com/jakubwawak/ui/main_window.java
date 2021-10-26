/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package com.jakubwawak.ui;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import utils.Profile_Engine;

/**
 *Object for creating main window
 * @author Jakub Wawak
 */
public class main_window extends javax.swing.JFrame {

    /**
     * Creates new form main_window
     */
    Profile_Engine profile_engine;
    ArrayList<String> content;
    ArrayList<String> history;
    String selected_text;
    public main_window(Profile_Engine profile_engine) {
        initComponents();
        this.profile_engine = profile_engine;
        history = new ArrayList<>();
        selected_text = "";
        this.setLocationRelativeTo(null);
        load_window();
        setVisible(true);
    }
    
    /**
     * Function for loading window data
     */
    void load_window(){
        load_profile();
        load_history();
    }
    
    /**
     * Function for loading profile data
     */
    void load_profile(){
        content = new ArrayList<>();
        field_url.setText(profile_engine.selected_profile.profile_url);
        content = profile_engine.selected_profile.load_components();
        DefaultListModel dlm = new DefaultListModel();
        dlm.addAll(content);
        list_content.setModel(dlm);
    }
    
    /**
     * Function for loading history
     */
    void load_history(){
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        dcm.addElement("Empty");
        combobox_history.setModel(dcm);
    }
    
    /**
     * Function for loading list content
     */
    void load_list_content(){
        DefaultListModel dlm = new DefaultListModel();
        dlm.addAll(content);
        list_content.setModel(dlm);
    }
    
    /**
     * Function for adding data to history combobox
     */
    void add_history(){
        history.add(field_request.getText());
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        dcm.addAll(history);
        combobox_history.setModel(dcm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        field_url = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        field_request = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_response = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_content = new javax.swing.JList<>();
        button_clear = new javax.swing.JButton();
        button_paste = new javax.swing.JButton();
        button_copyresponse = new javax.swing.JButton();
        combobox_history = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        button_checkconnection = new javax.swing.JButton();
        button_urlset = new javax.swing.JButton();
        button_createrequest = new javax.swing.JButton();
        button_new = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("API URL");

        field_url.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        field_url.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_urlMouseClicked(evt);
            }
        });

        jLabel2.setText("Request");

        field_request.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_requestMouseClicked(evt);
            }
        });

        field_response.setColumns(20);
        field_response.setRows(5);
        jScrollPane1.setViewportView(field_response);

        list_content.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list_content);

        button_clear.setText("Clear window");
        button_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_clearActionPerformed(evt);
            }
        });

        button_paste.setText("Copy");

        button_copyresponse.setText("Copy response");

        combobox_history.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("History");

        button_checkconnection.setText("Check connection");

        button_urlset.setText("ULR Set");
        button_urlset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_urlsetActionPerformed(evt);
            }
        });

        button_createrequest.setText("Create request");
        button_createrequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_createrequestActionPerformed(evt);
            }
        });

        button_new.setText("New");
        button_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_newActionPerformed(evt);
            }
        });

        jLabel3.setText("Saved content");

        jMenu1.setText("Apir");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Profiles");

        jMenu3.setText("Create new profile");

        jMenuItem1.setText("From window content");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("From creator");
        jMenu3.add(jMenuItem2);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("History");

        jMenuItem3.setText("Clear history");
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_urlset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobox_history, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(field_url)
                                    .addComponent(field_request)
                                    .addComponent(button_createrequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(button_copyresponse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_checkconnection, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_paste, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_new, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_checkconnection)
                    .addComponent(button_urlset)
                    .addComponent(jLabel5)
                    .addComponent(combobox_history, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field_url, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_paste)
                            .addComponent(button_new))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_request, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_createrequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_copyresponse)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_urlsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_urlsetActionPerformed
        field_url.setText(profile_engine.selected_profile.profile_url);
        field_request.setText(profile_engine.selected_profile.profile_url+"/");
    }//GEN-LAST:event_button_urlsetActionPerformed

    private void button_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_clearActionPerformed
        field_response.setText("");
        field_url.setText(profile_engine.selected_profile.profile_url);
    }//GEN-LAST:event_button_clearActionPerformed

    private void button_createrequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_createrequestActionPerformed
        add_history();
    }//GEN-LAST:event_button_createrequestActionPerformed

    private void button_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_newActionPerformed
        try{
            if ( !selected_text.equals(""))
                content.add(selected_text);
        }catch(Exception e){}
        load_list_content();
    }//GEN-LAST:event_button_newActionPerformed

    private void field_urlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_urlMouseClicked
        selected_text = field_url.getText();
    }//GEN-LAST:event_field_urlMouseClicked

    private void field_requestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_requestMouseClicked
        selected_text = field_request.getText();
    }//GEN-LAST:event_field_requestMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_checkconnection;
    private javax.swing.JButton button_clear;
    private javax.swing.JButton button_copyresponse;
    private javax.swing.JButton button_createrequest;
    private javax.swing.JButton button_new;
    private javax.swing.JButton button_paste;
    private javax.swing.JButton button_urlset;
    private javax.swing.JComboBox<String> combobox_history;
    private javax.swing.JTextField field_request;
    private javax.swing.JTextArea field_response;
    private javax.swing.JTextField field_url;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_content;
    // End of variables declaration//GEN-END:variables
}
