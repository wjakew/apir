/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package com.jakubwawak.ui_maintenance;
import com.jakubwawak.ui.main_window;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import utils.Profile;
import utils.Profile_Engine;

/**
 * Window for picking profile
 * @author kubaw
 */
public class profile_picker_window extends javax.swing.JDialog {

    /**
     * Creates new form profile_picker_window
     */
    
    Profile_Engine profile_engine;
    String build_number;
    public profile_picker_window(java.awt.Frame parent, boolean modal,Profile_Engine profiles,String build_number) {
        super(parent, modal);
        this.build_number = build_number;
        this.profile_engine = profiles;
        initComponents();
        this.setLocationRelativeTo(null);
        load_window();
        setVisible(true);
    }
    
    /**
     * Function for load window components
     */
    void load_window(){
        load_window_icon();
        load_list();
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
     * Function for loading list objects
     */
    void load_list(){
        DefaultListModel dlm = new DefaultListModel();
        dlm.addElement("0:Empty profile");
        int id = 1;
        if (profile_engine.list_profiles.size() > 0){
            for(Profile profile : profile_engine.list_profiles){
                dlm.addElement(id + ":"+profile.profile_name);
                id++;
            }
        }
        list_profiles.setModel(dlm);
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
        list_profiles = new javax.swing.JList<>();
        button_setprofile = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_profiles = new javax.swing.JMenu();
        menu_createnewprofile = new javax.swing.JMenuItem();
        menu_removeprofile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Profile picker");

        list_profiles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_profiles);

        button_setprofile.setText("Set profile");
        button_setprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_setprofileActionPerformed(evt);
            }
        });

        menu_profiles.setText("Profiles");

        menu_createnewprofile.setText("Create new profile");
        menu_createnewprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_createnewprofileActionPerformed(evt);
            }
        });
        menu_profiles.add(menu_createnewprofile);

        menu_removeprofile.setText("Remove profile");
        menu_removeprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_removeprofileActionPerformed(evt);
            }
        });
        menu_profiles.add(menu_removeprofile);

        jMenuBar1.add(menu_profiles);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(button_setprofile, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_setprofile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_createnewprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_createnewprofileActionPerformed
        new new_profile_window(this,true,profile_engine);
        load_window();
    }//GEN-LAST:event_menu_createnewprofileActionPerformed

    private void button_setprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_setprofileActionPerformed
        try{
            int object_id = Integer.parseInt(list_profiles.getSelectedValue().toString().split(":")[0]);
            if ( object_id == 0 ){
                Profile profile = new Profile();
                profile_engine.selected_profile = profile;
                new message_window(this,true,"Empty profile set","");
            }
            else{
                profile_engine.selected_profile = profile_engine.list_profiles.get(object_id-1);
                new message_window(this,true,"Profile "+profile_engine.selected_profile.profile_name+" set.","");
            }
            dispose();
            new main_window(profile_engine,build_number);
        }catch(NullPointerException e){
            new message_window(this,true,"No profile selected.","");
        }
        catch(Exception e){
            new message_window(this,true,"Error\n"+e.toString(),"");
        }
    }//GEN-LAST:event_button_setprofileActionPerformed

    private void menu_removeprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_removeprofileActionPerformed
       try{
            int object_id = Integer.parseInt(list_profiles.getSelectedValue().toString().split(":")[0]);
            if ( object_id == 0 ){
                new message_window(this,true,"No profile to remove","");
            }
            else{
                profile_engine.remove_profile(object_id-1);
                new message_window(this,true,"Profile "+profile_engine.selected_profile.profile_name+" set.","");
                load_window();
            }
            dispose();
            new main_window(profile_engine,build_number);
        }catch(Exception e){
            new message_window(this,true,"Error\n"+e.toString(),"");
        }
    }//GEN-LAST:event_menu_removeprofileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_setprofile;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_profiles;
    private javax.swing.JMenuItem menu_createnewprofile;
    private javax.swing.JMenu menu_profiles;
    private javax.swing.JMenuItem menu_removeprofile;
    // End of variables declaration//GEN-END:variables
}
