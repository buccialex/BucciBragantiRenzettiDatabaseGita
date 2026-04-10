package buccirenzettibragantidatabasegita;

import java.util.List;

public class FRMPartecipazione extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(FRMPartecipazione.class.getName());

    public FRMPartecipazione() {
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
        popolaCombo();
    }

    /** Carica alunni e gite presenti nel DB dentro le rispettive ComboBox */
    private void popolaCombo() {
        GestioneDataBase db = new GestioneDataBase();
        db.creaTabelle();

        List<String> alunni = db.ottieniAlunniCombo();
        cmbAlunno.removeAllItems();
        for (String a : alunni) cmbAlunno.addItem(a);

        List<String> gite = db.ottieniGiteCombo();
        cmbGita.removeAllItems();
        for (String g : gite) cmbGita.addItem(g);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbAlunno = new javax.swing.JComboBox<>();
        cmbGita   = new javax.swing.JComboBox<>();
        btnCreaPartecipazione = new javax.swing.JButton();
        btnGita   = new javax.swing.JButton();
        btnAlunno = new javax.swing.JButton();
        btnClasse = new javax.swing.JButton();
        btnTab    = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crea Partecipazioni");
        setMinimumSize(new java.awt.Dimension(578, 369));
        setPreferredSize(new java.awt.Dimension(578, 369));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Alunno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 7, 2, 7);
        getContentPane().add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(cmbAlunno, gridBagConstraints);

        jLabel3.setText("Gita");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(cmbGita, gridBagConstraints);

        btnCreaPartecipazione.setText("Crea Partecipazione");
        btnCreaPartecipazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaPartecipazioneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnCreaPartecipazione, gridBagConstraints);

        btnGita.setText("Passa a Gita");
        btnGita.addActionListener(evt -> btnGitaActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnGita, gridBagConstraints);

        btnAlunno.setText("Passa a Alunno");
        btnAlunno.addActionListener(evt -> btnAlunnoActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnAlunno, gridBagConstraints);

        btnClasse.setText("Passa a Classe");
        btnClasse.addActionListener(evt -> btnClasseActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnClasse, gridBagConstraints);

        btnTab.setText("Mostra tabella");
        btnTab.addActionListener(evt -> btnTabActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnTab, gridBagConstraints);

        pack();
    }

    private void btnCreaPartecipazioneActionPerformed(java.awt.event.ActionEvent evt) {
        if (cmbAlunno.getSelectedItem() == null || cmbGita.getSelectedItem() == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Seleziona un alunno e una gita.", "Attenzione", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        int par_alu_id = GestioneDataBase.estraiId((String) cmbAlunno.getSelectedItem());
        int par_git_id = GestioneDataBase.estraiId((String) cmbGita.getSelectedItem());

        GestioneDataBase db = new GestioneDataBase();
        db.creaTabelle();
        db.scriviPartecipazione(par_alu_id, par_git_id);

        javax.swing.JOptionPane.showMessageDialog(this,
                "Partecipazione inserita con successo!", "OK", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnTabActionPerformed(java.awt.event.ActionEvent evt) {
        FRMTabella f = new FRMTabella("partecipazione");
        f.setVisible(true); f.setLocationRelativeTo(this);
    }

    private void btnGitaActionPerformed(java.awt.event.ActionEvent evt) {
        FRMGita f = new FRMGita();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnAlunnoActionPerformed(java.awt.event.ActionEvent evt) {
        FRMAlunno f = new FRMAlunno();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnClasseActionPerformed(java.awt.event.ActionEvent evt) {
        FRMClasse f = new FRMClasse();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    // Variables declaration
    private javax.swing.JButton btnAlunno;
    private javax.swing.JButton btnClasse;
    private javax.swing.JButton btnCreaPartecipazione;
    private javax.swing.JButton btnGita;
    private javax.swing.JButton btnTab;
    private javax.swing.JComboBox<String> cmbAlunno;
    private javax.swing.JComboBox<String> cmbGita;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
}
