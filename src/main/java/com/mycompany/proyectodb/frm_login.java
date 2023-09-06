package com.mycompany.proyectodb;

import javax.swing.JOptionPane;

/**
 *
 * @author ervargas
 */
public class frm_login extends javax.swing.JFrame {

    /**
     * Creates new form cls_login
     */
    public frm_login() {
        initComponents();

        /*
        * Aca se puede probar la conexcion instanciando la clase
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_user = new javax.swing.JTextField();
        tf_psswrd = new javax.swing.JTextField();
        button_login = new javax.swing.JButton();
        label_login = new javax.swing.JLabel();
        label_user = new javax.swing.JLabel();
        label_psswrd = new javax.swing.JLabel();
        button_create_account = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(330, 330));
        setSize(new java.awt.Dimension(330, 330));
        getContentPane().setLayout(null);

        tf_user.setToolTipText("");
        getContentPane().add(tf_user);
        tf_user.setBounds(50, 90, 210, 24);

        tf_psswrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_psswrdActionPerformed(evt);
            }
        });
        getContentPane().add(tf_psswrd);
        tf_psswrd.setBounds(50, 150, 210, 24);

        button_login.setText("Login");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });
        getContentPane().add(button_login);
        button_login.setBounds(100, 190, 120, 40);

        label_login.setText("LOGIN");
        getContentPane().add(label_login);
        label_login.setBounds(140, 20, 50, 30);

        label_user.setText("User:");
        getContentPane().add(label_user);
        label_user.setBounds(50, 70, 50, 16);

        label_psswrd.setText("Password:");
        getContentPane().add(label_psswrd);
        label_psswrd.setBounds(51, 130, 80, 16);

        button_create_account.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        button_create_account.setText("Create Account");
        button_create_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_create_accountActionPerformed(evt);
            }
        });
        getContentPane().add(button_create_account);
        button_create_account.setBounds(190, 260, 110, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_psswrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_psswrdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_psswrdActionPerformed

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed

        String username = tf_user.getText();
        String password = new String(tf_psswrd.getText());

        cls_admin_user adminUser = new cls_admin_user();
        if (adminUser.loginUser(tf_user.getText(), tf_psswrd.getText())) {
            frm_software softwareForm = new frm_software(username);
            softwareForm.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas. Por favor, inténtalo nuevamente.");
        }
    }//GEN-LAST:event_button_loginActionPerformed

    private void button_create_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_create_accountActionPerformed
        frm_create_user create_user = new frm_create_user();
        create_user.setSize(330, 330);
        create_user.setVisible(true);
        this.hide();
    }//GEN-LAST:event_button_create_accountActionPerformed

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
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_create_account;
    private javax.swing.JButton button_login;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_psswrd;
    private javax.swing.JLabel label_user;
    private javax.swing.JTextField tf_psswrd;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}
