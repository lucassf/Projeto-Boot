package screens;

import filters.*;
import java.io.IOException;
import java.util.Arrays;
import projetoboot.*;
import javax.swing.text.AbstractDocument;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditionDialog extends javax.swing.JDialog {

    private final EditAnnotation editannotation;
    private final Annotation anot;
    
    // Incicializa componentes Swing e configura os filtros
    private void setSwing(){
        initComponents();
        ((AbstractDocument) TextArea.getDocument()).
                setDocumentFilter(new TextAreaFilter(50, 50));
        ((AbstractDocument) TitleField.getDocument()).
                setDocumentFilter(new FieldFilter(50)); 
        ((AbstractDocument) TagField.getDocument()).
                setDocumentFilter(new FieldFilter(50)); 
    }
    
    // Construtor para quando deseja-se criar uma nova anotação.
    // anot é igualada a null
    public EditionDialog(java.awt.Frame parent, boolean modal, EditAnnotation editanot) {
        super(parent, modal);
        anot = null;     
        setSwing();  
        editannotation = editanot;
        ActionButton.setEnabled(false);
    }
    
    // Construtor para quando deseja-se atualizar uma anotação.
    // anot é igualada ao parâmetro editanot
    public EditionDialog(java.awt.Frame parent, boolean modal,Annotation an, EditAnnotation editanot) {        
        super(parent, modal);
        anot = an;        
        setSwing(); 
        TextArea.setText(an.getText());
        TitleField.setText(an.getTitle());
        TagField.setText(Functions.SetToString(an.getMetatag()));
        ActionButton.setText("Atualizar");
        HeaderText.setText("Editar anotação");
        ActionButton.setEnabled(true);
        editannotation = editanot;
    }
    
    // Verifica se os campos de título e conteúdo estão vazio, evitando o salvamento
    // caso estejam
    private boolean canCreate(){
        return !TextArea.getText().isEmpty()&&!TitleField.getText().isEmpty();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        HeaderText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TagField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        ActionButton = new javax.swing.JButton();
        TitleExp = new javax.swing.JLabel();
        TitleExp1 = new javax.swing.JLabel();
        TitleExp2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TextArea.setColumns(20);
        TextArea.setRows(5);
        TextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextAreaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TextArea);

        HeaderText.setText("Criar nova anotação");

        jLabel1.setText("Tags:");

        jLabel2.setText("Título:");

        TitleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TitleFieldKeyReleased(evt);
            }
        });

        ActionButton.setText("Salvar");
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });

        TitleExp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TitleExp.setText("Campo obrigatório. Máximo de 50 caracteres.");

        TitleExp1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TitleExp1.setText("Campo obrigatório. Máximo de 50 caracteres por linha. Máximo de 50 linhas");

        TitleExp2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TitleExp2.setText("Campo opicional. Máximo de 50 caracteres.");

        jLabel3.setText("Conteúdo da anotação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitleExp)
                            .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HeaderText)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TitleExp2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ActionButton)))))
                            .addComponent(jLabel3)
                            .addComponent(TitleExp1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitleExp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(TitleExp1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ActionButton)
                        .addComponent(TagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitleExp2)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionButtonActionPerformed
        //criar anotacao nova
        if (anot == null){
           Annotation nova = new Annotation(TitleField.getText(),TextArea.getText(),
            new Date() ,new Date(), new HashSet<>(Arrays.asList(TagField.getText().split(" "))));
            editannotation.Create(nova);
            TitleField.setText("");
            TextArea.setText("");
            TagField.setText("");
            ActionButton.setEnabled(false); 
            JOptionPane.showMessageDialog(rootPane, "Anotação criada com sucesso.");
        }
        //editar anotacao
        else{
            anot.setLastmodification(new Date());
            anot.setTitle(TitleField.getText());
            anot.setText(TextArea.getText());
            anot.setMetatag(new HashSet<String>(Arrays.asList(TagField.getText().split(" "))));
            editannotation.Edit(anot);
            JOptionPane.showMessageDialog(rootPane, "Anotação editada com sucesso.");
        }
    }//GEN-LAST:event_ActionButtonActionPerformed

    private void TitleFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TitleFieldKeyReleased
        ActionButton.setEnabled(canCreate());
    }//GEN-LAST:event_TitleFieldKeyReleased

    private void TextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextAreaKeyReleased
        ActionButton.setEnabled(canCreate());
    }//GEN-LAST:event_TextAreaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActionButton;
    private javax.swing.JLabel HeaderText;
    private javax.swing.JTextField TagField;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JLabel TitleExp;
    private javax.swing.JLabel TitleExp1;
    private javax.swing.JLabel TitleExp2;
    private javax.swing.JTextField TitleField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
