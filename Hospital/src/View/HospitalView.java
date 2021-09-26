package View;


import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Shannon
 */
public class HospitalView extends javax.swing.JFrame {

    public HospitalView() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChildren = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOriginCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        txtTutor = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        combGender = new javax.swing.JComboBox();
        combHospital = new javax.swing.JComboBox();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnAddPatient = new javax.swing.JButton();
        btnDeletePatient = new javax.swing.JButton();
        btnModifyPatient = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Children's Hospital");

        jPanel1.setBackground(new java.awt.Color(123, 174, 192));

        tbChildren.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Last name", "Age", "Gender", "Hospital origin", "Inscription", "DateBirth", "Tutor", "Telephone", "City"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbChildren.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbChildrenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbChildren);
        if (tbChildren.getColumnModel().getColumnCount() > 0) {
            tbChildren.getColumnModel().getColumn(0).setResizable(false);
            tbChildren.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbChildren.getColumnModel().getColumn(1).setResizable(false);
            tbChildren.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbChildren.getColumnModel().getColumn(2).setResizable(false);
            tbChildren.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbChildren.getColumnModel().getColumn(3).setResizable(false);
            tbChildren.getColumnModel().getColumn(3).setPreferredWidth(20);
            tbChildren.getColumnModel().getColumn(4).setResizable(false);
            tbChildren.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbChildren.getColumnModel().getColumn(5).setResizable(false);
            tbChildren.getColumnModel().getColumn(5).setPreferredWidth(80);
            tbChildren.getColumnModel().getColumn(6).setResizable(false);
            tbChildren.getColumnModel().getColumn(6).setPreferredWidth(50);
            tbChildren.getColumnModel().getColumn(7).setResizable(false);
            tbChildren.getColumnModel().getColumn(7).setPreferredWidth(50);
            tbChildren.getColumnModel().getColumn(8).setResizable(false);
            tbChildren.getColumnModel().getColumn(8).setPreferredWidth(80);
            tbChildren.getColumnModel().getColumn(9).setResizable(false);
            tbChildren.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Children's Hospital");

        jPanel2.setBackground(new java.awt.Color(159, 198, 168));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel3.setText("Last name");

        txtLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel4.setText("City");

        txtOriginCity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel5.setText("gender");

        jLabel6.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel6.setText("Hospital origin");

        jLabel7.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel7.setText("Date birth");

        jLabel8.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel8.setText("age");

        jLabel9.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel9.setText("tutor name");

        jLabel10.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel10.setText("telephone");

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTutor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTelephone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        combGender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combGender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combGenderItemStateChanged(evt);
            }
        });
        combGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combGenderActionPerformed(evt);
            }
        });

        combHospital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAge)
                            .addComponent(combGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtTutor))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combHospital, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOriginCity)
                    .addComponent(txtTelephone)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtOriginCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(combGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(215, 179, 189));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buttons"));

        btnAddPatient.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        btnAddPatient.setText("add new patient");
        btnAddPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPatientActionPerformed(evt);
            }
        });

        btnDeletePatient.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        btnDeletePatient.setText("delete patient");
        btnDeletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePatientActionPerformed(evt);
            }
        });

        btnModifyPatient.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        btnModifyPatient.setText("modify patient");
        btnModifyPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnAddPatient)
                .addGap(125, 125, 125)
                .addComponent(btnModifyPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeletePatient)
                .addGap(93, 93, 93))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPatient)
                    .addComponent(btnDeletePatient)
                    .addComponent(btnModifyPatient))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
       
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
      
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void combGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combGenderActionPerformed
 
    }//GEN-LAST:event_combGenderActionPerformed

    private void combGenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combGenderItemStateChanged

    }//GEN-LAST:event_combGenderItemStateChanged

    private void tbChildrenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChildrenMouseClicked

    }//GEN-LAST:event_tbChildrenMouseClicked

    private void btnModifyPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyPatientActionPerformed

    }//GEN-LAST:event_btnModifyPatientActionPerformed

    private void btnDeletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatientActionPerformed

    }//GEN-LAST:event_btnDeletePatientActionPerformed

    public JButton getBtnAddPatient() {
        return btnAddPatient;
    }

    public JButton getBtnDeletePatient() {
        return btnDeletePatient;
    }

    public JButton getBtnModifyPatient() {
        return btnModifyPatient;
    }

    public JComboBox getCombGender() {
        return combGender;
    }

    public JComboBox getCombHospital() {
        return combHospital;
    }

    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtOriginCity() {
        return txtOriginCity;
    }

    public JTextField getTxtTelephone() {
        return txtTelephone;
    }

    public JTextField getTxtTutor() {
        return txtTutor;
    }

    public JTable getTbChildren() {
        return tbChildren;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnDeletePatient;
    private javax.swing.JButton btnModifyPatient;
    private javax.swing.JComboBox combGender;
    private javax.swing.JComboBox combHospital;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTable tbChildren;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOriginCity;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtTutor;
    // End of variables declaration//GEN-END:variables
}
