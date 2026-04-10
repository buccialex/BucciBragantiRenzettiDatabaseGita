package buccirenzettibragantidatabasegita;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class FRMAlunno extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(FRMAlunno.class.getName());

    public FRMAlunno() {
        initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        popolaComboClassi();
    }

    /** Carica le classi presenti nel DB dentro la ComboBox */
    private void popolaComboClassi() {
        GestioneDataBase db = new GestioneDataBase();
        db.creaTabelle();
        List<String> classi = db.ottieniClassiCombo();
        cmbClasse.removeAllItems();
        for (String c : classi) {
            cmbClasse.addItem(c);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        // ComboBox al posto del campo testuale per l'ID classe
        cmbClasse = new javax.swing.JComboBox<>();
        btnCreaAlunno = new javax.swing.JButton();
        btnGita = new javax.swing.JButton();
        btnClasse = new javax.swing.JButton();
        btnTab = new javax.swing.JButton();
        btnPartecipazione = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(578, 369));
        setPreferredSize(new java.awt.Dimension(578, 369));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(jTextField6, gridBagConstraints);

        jLabel6.setText("Cognome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 7, 2, 7);
        getContentPane().add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(jTextField7, gridBagConstraints);

        jLabel7.setText("Classe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(cmbClasse, gridBagConstraints);

        btnCreaAlunno.setText("Crea Alunno");
        btnCreaAlunno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaAlunnoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnCreaAlunno, gridBagConstraints);

        btnGita.setText("Passa a Gita");
        btnGita.addActionListener(evt -> btnGitaActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnGita, gridBagConstraints);

        btnClasse.setText("Passa a Classe");
        btnClasse.addActionListener(evt -> btnClasseActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnClasse, gridBagConstraints);

        btnPartecipazione.setText("Passa a Partecipazione");
        btnPartecipazione.addActionListener(evt -> btnPartecipazioneActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnPartecipazione, gridBagConstraints);

        btnTab.setText("Visualizza tabella");
        btnTab.addActionListener(evt -> btnTabActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnTab, gridBagConstraints);

        pack();
    }

    private void btnCreaAlunnoActionPerformed(java.awt.event.ActionEvent evt) {
        String alu_nome    = jTextField6.getText().trim();
        String alu_cognome = jTextField7.getText().trim();

        if (alu_nome.isEmpty() || alu_cognome.isEmpty() || cmbClasse.getSelectedItem() == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Compila tutti i campi e seleziona una classe.",
                    "Attenzione", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Estrae l'ID dalla voce "id - anno sezione"
        int alu_cla_id = GestioneDataBase.estraiId((String) cmbClasse.getSelectedItem());

        GestioneDataBase db = new GestioneDataBase();
        db.creaTabelle();
        db.scriviAlunni(alu_nome, alu_cognome, alu_cla_id);

        javax.swing.JOptionPane.showMessageDialog(this,
                "Alunno inserito con successo!", "OK", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        jTextField6.setText("");
        jTextField7.setText("");
    }

    private void btnGitaActionPerformed(java.awt.event.ActionEvent evt) {
        FRMGita f = new FRMGita();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnClasseActionPerformed(java.awt.event.ActionEvent evt) {
        FRMClasse f = new FRMClasse();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnPartecipazioneActionPerformed(java.awt.event.ActionEvent evt) {
        FRMPartecipazione f = new FRMPartecipazione();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnTabActionPerformed(java.awt.event.ActionEvent evt) {
        FRMTabella f = new FRMTabella("alunni");
        f.setVisible(true); f.setLocationRelativeTo(this);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FRMAlunno().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnClasse;
    private javax.swing.JButton btnCreaAlunno;
    private javax.swing.JButton btnGita;
    private javax.swing.JButton btnPartecipazione;
    private javax.swing.JButton btnTab;
    private javax.swing.JComboBox<String> cmbClasse;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
}
