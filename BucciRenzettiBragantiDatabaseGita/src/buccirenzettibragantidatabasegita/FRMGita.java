package buccirenzettibragantidatabasegita;

public class FRMGita extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(FRMGita.class.getName());

    public FRMGita() {
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
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        btnCreaGita = new javax.swing.JButton();
        btnFrmClasse = new javax.swing.JButton();
        btnFrmAlunno = new javax.swing.JButton();
        btnTab = new javax.swing.JButton();
        btnPartecipazione = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creazione Gita");
        setMinimumSize(new java.awt.Dimension(578, 369));
        setPreferredSize(new java.awt.Dimension(578, 369));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[]{0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights   = new int[]{0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabel2.setText("Destinazione");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 5);
        getContentPane().add(jTextField2, gridBagConstraints);

        jLabel3.setText("Durata (giorni)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        getContentPane().add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 5);
        getContentPane().add(jTextField3, gridBagConstraints);

        jLabel4.setText("Prezzo (€)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        getContentPane().add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 55; gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 5);
        getContentPane().add(jTextField4, gridBagConstraints);

        btnCreaGita.setText("Crea Gita");
        btnCreaGita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaGitaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(btnCreaGita, gridBagConstraints);

        btnFrmClasse.setText("Passa a Classe");
        btnFrmClasse.addActionListener(evt -> btnFrmClasseActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 8;
        getContentPane().add(btnFrmClasse, gridBagConstraints);

        btnFrmAlunno.setText("Passa a Alunno");
        btnFrmAlunno.addActionListener(evt -> btnFrmAlunnoActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 8;
        getContentPane().add(btnFrmAlunno, gridBagConstraints);

        btnPartecipazione.setText("Passa a Partecipazione");
        btnPartecipazione.addActionListener(evt -> btnPartecipazioneActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6; gridBagConstraints.gridy = 8;
        getContentPane().add(btnPartecipazione, gridBagConstraints);

        btnTab.setText("Visualizza Tabella");
        btnTab.addActionListener(evt -> btnTabActionPerformed(evt));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7; gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(btnTab, gridBagConstraints);

        pack();
    }

    private void btnCreaGitaActionPerformed(java.awt.event.ActionEvent evt) {
        String dest    = jTextField2.getText().trim();
        String durStr  = jTextField3.getText().trim();
        String prezStr = jTextField4.getText().trim();

        if (dest.isEmpty() || durStr.isEmpty() || prezStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Compila tutti i campi.", "Attenzione", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int durata = Integer.parseInt(durStr);
            int prezzo = Integer.parseInt(prezStr);
            GestioneDataBase db = new GestioneDataBase();
            db.creaTabelle();
            db.scriviGite(dest, durata, prezzo);
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Gita inserita con successo!", "OK", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField2.setText(""); jTextField3.setText(""); jTextField4.setText("");
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Durata e prezzo devono essere numeri interi.", "Errore", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnFrmClasseActionPerformed(java.awt.event.ActionEvent evt) {
        FRMClasse f = new FRMClasse();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnFrmAlunnoActionPerformed(java.awt.event.ActionEvent evt) {
        FRMAlunno f = new FRMAlunno();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    private void btnTabActionPerformed(java.awt.event.ActionEvent evt) {
        FRMTabella f = new FRMTabella("gite");
        f.setVisible(true); f.setLocationRelativeTo(this);
    }

    private void btnPartecipazioneActionPerformed(java.awt.event.ActionEvent evt) {
        FRMPartecipazione f = new FRMPartecipazione();
        f.setVisible(true); f.setLocationRelativeTo(this); this.dispose();
    }

    // Variables declaration
    private javax.swing.JButton btnCreaGita;
    private javax.swing.JButton btnFrmAlunno;
    private javax.swing.JButton btnFrmClasse;
    private javax.swing.JButton btnPartecipazione;
    private javax.swing.JButton btnTab;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
}
