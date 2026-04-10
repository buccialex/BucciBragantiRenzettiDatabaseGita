package buccirenzettibragantidatabasegita;

public class FRMClasse extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(FRMClasse.class.getName());

    public FRMClasse() {
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
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        btnCreaClasse = new javax.swing.JButton();
        btnGita = new javax.swing.JButton();
        btnAlunno = new javax.swing.JButton();
        btnTab = new javax.swing.JButton();
        btnPartecipazione = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(578, 369));
        setPreferredSize(new java.awt.Dimension(578, 369));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Anno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 7, 2, 7);
        getContentPane().add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(jTextField6, gridBagConstraints);

        jLabel7.setText("Sezione");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 7);
        getContentPane().add(jTextField7, gridBagConstraints);

        btnCreaClasse.setText("Crea Classe");
        btnCreaClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaClasseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnCreaClasse, gridBagConstraints);

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

        btnPartecipazione.setText("Passa a Partecipazione");
        btnPartecipazione.addActionListener(evt -> btnPartecipazioneActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnPartecipazione, gridBagConstraints);

        btnTab.setText("Visualizza tabella");
        btnTab.addActionListener(evt -> btnTabActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(btnTab, gridBagConstraints);

        pack();
    }

    private void btnCreaClasseActionPerformed(java.awt.event.ActionEvent evt) {
        String annoStr  = jTextField6.getText().trim();
        String sezione  = jTextField7.getText().trim();

        if (annoStr.isEmpty() || sezione.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Compila tutti i campi.", "Attenzione", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int anno = Integer.parseInt(annoStr);
            GestioneDataBase db = new GestioneDataBase();
            db.creaTabelle();
            db.scriviClassi(anno, sezione);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Classe inserita con successo!", "OK", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField6.setText("");
            jTextField7.setText("");
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "L'anno deve essere un numero intero.", "Errore", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnGitaActionPerformed(java.awt.event.ActionEvent evt) {
        FRMGita f = new FRMGita();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnAlunnoActionPerformed(java.awt.event.ActionEvent evt) {
        FRMAlunno f = new FRMAlunno();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnPartecipazioneActionPerformed(java.awt.event.ActionEvent evt) {
        FRMPartecipazione f = new FRMPartecipazione();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnTabActionPerformed(java.awt.event.ActionEvent evt) {
        FRMTabella f = new FRMTabella("classi");
        f.setVisible(true); f.setLocationRelativeTo(this);
    }

    // Variables declaration
    private javax.swing.JButton btnAlunno;
    private javax.swing.JButton btnCreaClasse;
    private javax.swing.JButton btnGita;
    private javax.swing.JButton btnPartecipazione;
    private javax.swing.JButton btnTab;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
}
