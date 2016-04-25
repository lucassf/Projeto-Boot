package screens;

import filters.*;
import projetoboot.*;
import javax.swing.text.AbstractDocument;

public class EditionDialog extends javax.swing.JDialog {

    private TextAreaFilter textareafilter;
    private FieldFilter fieldfilter;
    private EditAnnotation editannotation;

    // Inicia componentes swing e instancia os filtros para os campos de entrada 
    //do usuário
    public final void setSwing() {
        initComponents();
        textareafilter = new TextAreaFilter(50, 50);
        ((AbstractDocument) TextArea.getDocument()).setDocumentFilter(textareafilter);
        fieldfilter = new FieldFilter(50);
        ((AbstractDocument) TitleField.getDocument()).setDocumentFilter(fieldfilter);
    }

    // Construtor para quando o usuário deseja criar uma nova anotação
    public EditionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setSwing();
    }

    // Construtor para quando o usuário deseja editar uma anotação já criada
    public EditionDialog(java.awt.Frame parent, boolean modal, Annotation an) {
        super(parent, modal);
        setSwing();
        // Edita os campos com dados da anotação
        TextArea.setText(an.getText());
        TitleField.setText(an.getTitle());
        TagField.setText(Functions.SetToString(an.getMetatag()));
        ActionButton.setText("Atualizar");
        ActionButton.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        ActionButton = new javax.swing.JButton();
        HeaderText = new javax.swing.JLabel();
        Version = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TagField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane2.setViewportView(TextArea);

        ActionButton.setText("Salvar");
        ActionButton.setEnabled(false);
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });

        HeaderText.setText("Programa para criar e editar anotações.");

        Version.setText("Ver 1.0");

        jLabel1.setText("Tags:");

        jLabel2.setText("Título:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HeaderText)
                                .addGap(18, 18, 18)
                                .addComponent(Version))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ActionButton)))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(TitleField))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HeaderText)
                    .addComponent(Version))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActionButton)
                    .addComponent(jLabel1)
                    .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Botão de ação quando o usuário deseja salvar o arquivo
    private void ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButtonActionPerformed
        /*Annotation an = new Annotation(TitleField.getText(),TextArea.getText(),
         new Date(),new Date(),new HashSet<>(Arrays.asList(TagField.getText().split(" "))));
         editannotation.Create(an);
         JOptionPane.showMessageDialog(rootPane, "Anotação criada com sucesso.");
         TextArea.setText("");
         TagField.setText("");
         ActionButton.setEnabled(false);*/
    }//GEN-LAST:event_ActionButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActionButton;
    private javax.swing.JLabel HeaderText;
    private javax.swing.JTextField TagField;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JTextField TitleField;
    private javax.swing.JLabel Version;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
