package screens;

import filters.*;
import projetoboot.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class MainFrame extends javax.swing.JFrame {

    private final Search search;
    private final SimpleDateFormat dateformat;
    private final String versioncontrolmessage;
    private final EditAnnotation editannotation;
    private Vector<Annotation> an;

    public MainFrame() {
        initComponents();
        setComboBoxes();
        ((AbstractDocument) TitleField.getDocument()).
                setDocumentFilter(new FieldFilter(100));
        ((AbstractDocument) TagsField.getDocument()).
                setDocumentFilter(new FieldFilter(100));
        editannotation = new EditAnnotation();
        an = editannotation.getAnnotations();

        an.addElement(new Annotation("Ultimo dia", "A noite\nsombria e escura\n",
                new Date(), new Date(), new HashSet<>(Arrays.asList("doc inutil test test doc".split(" ")))));
        an.addElement(new Annotation("Merchandise", "Denis\n\n\n\nArrot",
                new GregorianCalendar(2016, 2, 30).getTime(), new GregorianCalendar(2016, 2, 27).getTime(),
                new HashSet<>(Arrays.asList("doc sup test test".split(" ")))));
        an.addElement(new Annotation("Sentença", "Se fosse tão facil não seria impossível",
                new GregorianCalendar(2016, 2, 27).getTime(), new GregorianCalendar(2016, 3, 2).getTime(),
                new HashSet<>(Arrays.asList("".split(" ")))));

        search = new Search(editannotation.getAnnotations());
        dateformat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        versioncontrolmessage = "Bloco de anotações\nV. 1.0";
    }

    private void setComboBoxes() {
        int yearlimit = Year.now().getValue();

        for (int i = 2016; i <= yearlimit; i++) {
            CreationYearComboBox.addItem(i);
            UpdateYearComboBox.addItem(i);
        }
    }

    private int[] ValidateComboBoxes(JComboBox year, JComboBox month, JComboBox day) {
        int[] calendar = null;
        calendar = new int[]{
            year.getSelectedIndex() == 0 ? 0 : (Integer) year.getSelectedItem(),
            month.getSelectedIndex(),
            day.getSelectedIndex()
        };
        if (Functions.CheckDateIsValid(calendar)) {
            return calendar;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        CreationDayComboBox = new javax.swing.JComboBox();
        CreationMonthComboBox = new javax.swing.JComboBox();
        CreationYearComboBox = new javax.swing.JComboBox();
        UpdateDayComboBox = new javax.swing.JComboBox();
        UpdateMonthComboBox = new javax.swing.JComboBox();
        UpdateYearComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        TagsField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultsTable = new javax.swing.JTable();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        NewButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewMenuItem = new javax.swing.JMenuItem();
        ExitMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar");

        jLabel2.setText("Título:");

        jLabel3.setText("Data De Criação:");

        jLabel4.setText("Última modificação:");

        CreationDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        CreationMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        CreationYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano" }));

        UpdateDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        UpdateMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        UpdateYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ano" }));

        jLabel5.setText("Tags:");

        SearchButton.setText("Pesquisar");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        ResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Tags", "Data de criação", "Última modificação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResultsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ResultsTable);

        EditButton.setText("Editar");
        EditButton.setEnabled(false);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Excluir");
        DeleteButton.setEnabled(false);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        NewButton.setText("Novo");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("Zerar campos");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        FileMenu.setText("Arquivo");

        NewMenuItem.setText("Novo");
        NewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(NewMenuItem);

        ExitMenuItem.setText("Sair");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenuItem);

        jMenuBar1.add(FileMenu);

        HelpMenu.setText("Ajuda");

        AboutMenuItem.setText("Sobre");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenuItem);

        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TitleField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TagsField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CreationDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CreationMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CreationYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UpdateDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(UpdateMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(UpdateYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CreationDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreationMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreationYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ResetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TagsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton)
                    .addComponent(DeleteButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String message;
        int[] creationcalendar = ValidateComboBoxes(CreationYearComboBox,
                CreationMonthComboBox, CreationDayComboBox);
        int[] updatecalendar = ValidateComboBoxes(UpdateYearComboBox,
                UpdateMonthComboBox, UpdateDayComboBox);
        if (creationcalendar == null) {
            message = "Data de criação inválida";
        } else if (updatecalendar == null) {
            message = "Data de última modificação inválida";
        } else {
            int found = search.Search(TitleField.getText(),
                    new HashSet<>(Arrays.asList(TagsField.getText().split(" "))),
                    creationcalendar, updatecalendar, Annotation.SortCriteria.LASTMODIFICATION);
            message = found + (found != 1 ? " anotações encontradas" : " anotação encontrada");
        }
        ArrayList<Annotation> results = search.GetResults();
        DefaultTableModel model = (DefaultTableModel) ResultsTable.getModel();
        model.setRowCount(0);
        for (Annotation an : results) {
            model.addRow(new Object[]{
                an.getTitle(),
                Functions.SetToString(an.getMetatag()),
                dateformat.format(an.getCreation()),
                dateformat.format(an.getLastmodification())
            });
        }
        JOptionPane.showMessageDialog(rootPane, message);
        EditButton.setEnabled(false);
        DeleteButton.setEnabled(false);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(rootPane, versioncontrolmessage);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        new EditionDialog(this, true, search.GetResults().
                get(ResultsTable.getSelectedRow())).setVisible(true);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedrows = ResultsTable.getSelectedRowCount();
        String message = "Deseja remover " + selectedrows + (selectedrows > 1
                ? " anotações?" : " anotação");
        int ans = JOptionPane.showConfirmDialog(rootPane, message, "Realizar exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            try {
                int[] indexes = ResultsTable.getSelectedRows();
                Annotation an;
                for (int i = indexes.length - 1; i >= 0; i--) {
                    ArrayList<Annotation> results;
                    results = search.GetResults();
                    an = results.get(i);
                    editannotation.Delete(an);
                    results.remove(i);
                    ((DefaultTableModel) ResultsTable.getModel()).removeRow(i);
                }
                JOptionPane.showMessageDialog(rootPane, selectedrows + (selectedrows > 1
                        ? " anotações removidas" : " anotação removida"));
                EditButton.setEnabled(false);
                DeleteButton.setEnabled(false);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ResultsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultsTableMousePressed
        int row = ResultsTable.getSelectedRow();
        if (row >= 0) {
            EditButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        }
        if (evt.getClickCount() == 2 && evt.getButton() == evt.BUTTON1 && row >= 0) {
            new EditionDialog(this, true, search.GetResults().
                    get(ResultsTable.getSelectedRow())).setVisible(true);
        }
    }//GEN-LAST:event_ResultsTableMousePressed

    private void NewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMenuItemActionPerformed
        new EditionDialog(this, true).setVisible(true);
    }//GEN-LAST:event_NewMenuItemActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        new EditionDialog(this, true).setVisible(true);
    }//GEN-LAST:event_NewButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        TitleField.setText("");
        TagsField.setText("");
        CreationYearComboBox.setSelectedIndex(0);
        CreationMonthComboBox.setSelectedIndex(0);
        CreationDayComboBox.setSelectedIndex(0);
        UpdateYearComboBox.setSelectedIndex(0);
        UpdateMonthComboBox.setSelectedIndex(0);
        UpdateDayComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_ResetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JComboBox CreationDayComboBox;
    private javax.swing.JComboBox CreationMonthComboBox;
    private javax.swing.JComboBox CreationYearComboBox;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JButton NewButton;
    private javax.swing.JMenuItem NewMenuItem;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTable ResultsTable;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField TagsField;
    private javax.swing.JTextField TitleField;
    private javax.swing.JComboBox UpdateDayComboBox;
    private javax.swing.JComboBox UpdateMonthComboBox;
    private javax.swing.JComboBox UpdateYearComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
