package screens;

import filters.*;
import projetoboot.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import java.util.Date;
import java.util.HashSet;

public class MainFrame extends javax.swing.JFrame {

    private final TextAreaFilter textareafilter;
    private final FieldFilter fieldfilter;
    private EditAnnotation editannotation;
    private final Search search;

    public MainFrame() {
        initComponents();
        textareafilter = new TextAreaFilter(50, 50);
        ((AbstractDocument) TextArea.getDocument()).setDocumentFilter(textareafilter);
        fieldfilter = new FieldFilter(50);
        ((AbstractDocument) TitleField.getDocument()).setDocumentFilter(fieldfilter);
        editannotation = new EditAnnotation();
        search = new Search(editannotation.getAnnotations());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        SaveButton = new javax.swing.JButton();
        HeaderText = new javax.swing.JLabel();
        Version = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TagField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        ButtonFechar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MainMenu = new javax.swing.JMenu();
        SearchMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TextArea.setColumns(20);
        TextArea.setRows(5);
        TextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextAreaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TextArea);

        SaveButton.setText("Salvar");
        SaveButton.setEnabled(false);
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        HeaderText.setText("Programa para criar e editar anotações.");

        Version.setText("Ver 1.0");

        jLabel1.setText("Tags:");

        jLabel2.setText("Título:");

        ButtonFechar.setText("Fechar");
        ButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFecharActionPerformed(evt);
            }
        });

        MainMenu.setText("Arquivo");

        SearchMenu.setText("Pesquisar");
        SearchMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMenuActionPerformed(evt);
            }
        });
        MainMenu.add(SearchMenu);

        ExitMenu.setText("Sair");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        MainMenu.add(ExitMenu);

        jMenuBar1.add(MainMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HeaderText)
                                .addGap(18, 18, 18)
                                .addComponent(Version)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SaveButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TitleField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HeaderText)
                        .addComponent(Version))
                    .addComponent(ButtonFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(jLabel1)
                    .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        Annotation an = new Annotation();
        an.setText(TextArea.getText());
        an.setMetatag(new HashSet<>(Arrays.asList(TagField.getText().split(" "))));
        an.setCreation(new Date());
        an.setLastmodification(new Date());
        editannotation.Create(an);
        JOptionPane.showMessageDialog(rootPane, "Anotação criada com sucesso.");
        TextArea.setText("");
        TagField.setText("");
        SaveButton.setEnabled(false);
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void TextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextAreaKeyReleased
        if (!TextArea.getText().isEmpty()) {
            SaveButton.setEnabled(true);
        } else {
            SaveButton.setEnabled(false);
        }
    }//GEN-LAST:event_TextAreaKeyReleased

    private void SearchMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchMenuActionPerformed
        new SearchDialog(this,true).setVisible(true);
    }//GEN-LAST:event_SearchMenuActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void ButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFecharActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_ButtonFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonFechar;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JLabel HeaderText;
    private javax.swing.JMenu MainMenu;
    private javax.swing.JButton SaveButton;
    private javax.swing.JMenuItem SearchMenu;
    private javax.swing.JTextField TagField;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JTextField TitleField;
    private javax.swing.JLabel Version;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
