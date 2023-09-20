package javasort;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormSistema extends javax.swing.JFrame {
    ArrayList<Dados> lista = new ArrayList<>();
   // Definir os comparadores

    
    public FormSistema() {
        initComponents();
        carregaArquivo();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblProx = new javax.swing.JLabel();
        labelComparacoes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOrdena = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        cbOrdena = new javax.swing.JComboBox<>();
        btnbusca = new javax.swing.JButton();
        jTextBusca = new javax.swing.JTextField();
        jRadioButtonBinaria = new javax.swing.JRadioButton();
        jRadioButtonLinear = new javax.swing.JRadioButton();
        cbBusca = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        lblProx.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        lblProx.setForeground(new java.awt.Color(255, 255, 255));
        lblProx.setText("Sistema de Informações Cidades de Minas Gerais");

        labelComparacoes.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        labelComparacoes.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(labelComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(lblProx, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblProx, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelComparacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 24))); // NOI18N

        btnOrdena.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnOrdena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javasort/check-list (1).png"))); // NOI18N
        btnOrdena.setText("Ordenar");
        btnOrdena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenaActionPerformed(evt);
            }
        });

        tabelaDados.setAutoCreateRowSorter(true);
        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IBGEcode", "Cidade", "Pop Estimada 2018", "IDH", "PIB 2014"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDados);
        if (tabelaDados.getColumnModel().getColumnCount() > 0) {
            tabelaDados.getColumnModel().getColumn(0).setResizable(false);
            tabelaDados.getColumnModel().getColumn(1).setResizable(false);
            tabelaDados.getColumnModel().getColumn(2).setResizable(false);
            tabelaDados.getColumnModel().getColumn(3).setResizable(false);
            tabelaDados.getColumnModel().getColumn(4).setResizable(false);
        }

        cbOrdena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IBGE code", "POP Estimada", "IDH", "PIB"}));
        cbOrdena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenaActionPerformed(evt);
            }
        });

        btnbusca.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnbusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javasort/check-list (1).png"))); // NOI18N
        btnbusca.setText("Buscar");
        btnbusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscaActionPerformed(evt);
            }
        });

        jTextBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscaActionPerformed(evt);
            }
        });

        jRadioButtonBinaria.setText("Busca Binaria");
        jRadioButtonBinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBinariaActionPerformed(evt);
            }
        });

        jRadioButtonLinear.setText("Busca Linear");

        cbBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IBGE code", "Cidade"}));
        cbBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbOrdena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBinaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonLinear)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cbOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonBinaria)
                            .addComponent(jRadioButtonLinear))
                        .addGap(18, 18, 18)
                        .addComponent(btnbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void carregaArquivo(){
     String csvFile = "MinasIBGE - MinasIBGE.csv";
        String line = "";
        String[] leitura = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                Dados citys = new Dados();
                leitura = line.split(",");
                
                
                   
                citys.setIbgeCode(Integer.parseInt(leitura[0]));

                citys.setCidade(leitura[1]);

                citys.setPop2018(Integer.parseInt(leitura[2]));
   
                citys.setIDH(Double.parseDouble(leitura[3]));
    
                citys.setPib2014(Double.parseDouble(leitura[4]));
                    
                
                lista.add(citys); 
            }// fim percurso no arquivo
            mostra();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //https://1bestcsharp.blogspot.com/2016/03/java-populate-jtable-from-arraylist.html
    void mostra(){
        //limpando a tabela
        tabelaDados.setModel(new DefaultTableModel(null,new String[]{"IBGEcode","LocalCidade","PopEstimada_2018","IDH","Pib_2014"}));
       
        DefaultTableModel model = (DefaultTableModel)tabelaDados.getModel();
        Object rowData[] = new Object[5];// qtd colunas
        for(Dados d: lista)
        {
            rowData[0] = d.getIbgeCode();
            rowData[1] = d.getCidade();
            rowData[2] = d.getPop2018();
            rowData[3] = d.getIDH();
            rowData[4] = d.getPib2014();
            model.addRow(rowData);
        }// fim preenche modelo
    }// fim mostra
   
    
   
    
    
    private void btnOrdenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenaActionPerformed
          String colunaSelecionada = (String) cbOrdena.getSelectedItem();
    
        // Verifique a coluna selecionada e ordene de acordo com a escolha
        switch (colunaSelecionada) {
            case "IBGE code":
                ordenarPorIBGECode();
                break;
            case "POP Estimada":
                ordenarPorPopEstimada();
                break;
            case "IDH":
                ordenarPorIDH();
                break;
            case "PIB":
                ordenarPorPIB();
                break;
            // Adicione outros casos conforme necessário
        }
        mostra();
    }//GEN-LAST:event_btnOrdenaActionPerformed

    private void ordenarPorIBGECode() {
        Collections.sort(lista, new Comparator<Dados>() {
            @Override
            public int compare(Dados d1, Dados d2) {
                return Integer.compare(d1.getIbgeCode(), d2.getIbgeCode());
            }
        });
    }

    private void ordenarPorPopEstimada() {
        Collections.sort(lista, new Comparator<Dados>() {
            @Override
            public int compare(Dados d1, Dados d2) {
                return Integer.compare(d1.getPop2018(), d2.getPop2018());
            }
        });
    }

    private void ordenarPorIDH() {
        Collections.sort(lista, new Comparator<Dados>() {
            @Override
            public int compare(Dados d1, Dados d2) {
                return Double.compare(d1.getIDH(), d2.getIDH());
            }
        });
    }

    private void ordenarPorPIB() {
        Collections.sort(lista, new Comparator<Dados>() {
            @Override
            public int compare(Dados d1, Dados d2) {
                return Double.compare(d1.getPib2014(), d2.getPib2014());
            }
        });
    }
    
    
    private void cbOrdenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdenaActionPerformed

    private void btnbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaActionPerformed
        
        
        
        if (jRadioButtonLinear.isSelected()) {
            // Verifique qual coluna foi selecionada na combobox
            String colunaBusca = (String) cbBusca.getSelectedItem();
            String termoBusca = jTextBusca.getText();

            // Verifique a coluna de busca selecionada
            switch (colunaBusca) {
                case "IBGE code":
                    buscarPorIBGECode(termoBusca);
                    break;
                case "Cidade":
                    buscarPorCidade(termoBusca);
                    break;
            }
        } else if (jRadioButtonBinaria.isSelected()) {
                // Verifique qual coluna foi selecionada na combobox
            String colunaBusca = (String) cbBusca.getSelectedItem();
            String termoBusca = jTextBusca.getText();

            // Verifique a coluna de busca selecionada
           switch (colunaBusca) {
                case "Cidade":
                    // Ordenar a lista de dados com base na coluna "Cidade"
                    Collections.sort(lista);
                    int resultadoBuscaCidade = buscaBinariaCidade(termoBusca);


                    if (resultadoBuscaCidade != -1) {
                        DefaultTableModel model = (DefaultTableModel) tabelaDados.getModel();
                        model.setRowCount(0);

                        // Obtém o resultado da busca binária
                        Dados cidadeEncontrada = lista.get(resultadoBuscaCidade);

                        // Adiciona o resultado à tabela
                        Object[] rowData = {cidadeEncontrada.getIbgeCode(), cidadeEncontrada.getCidade(),
                                            cidadeEncontrada.getPop2018(), cidadeEncontrada.getIDH(),
                                            cidadeEncontrada.getPib2014()};
                        model.addRow(rowData);
                    } else {
                        // Mostrar mensagem se não encontrar
                        labelComparacoes.setText("Não existe na base de dados");
                    }
                    break;
                case "IBGE code":
                    // Ordenar a lista de dados com base na coluna "IBGE code"
                    Collections.sort(lista, new Comparator<Dados>() {
                        @Override
                        public int compare(Dados d1, Dados d2) {
                            return Integer.compare(d1.getIbgeCode(), d2.getIbgeCode());
                        }
                    });

                    int resultadoBuscaIBGE = buscaBinariaIBGE(termoBusca);

                    if (resultadoBuscaIBGE != -1) {
                        DefaultTableModel model = (DefaultTableModel) tabelaDados.getModel();
                        model.setRowCount(0);
                        Dados cidadeEncontrada = lista.get(resultadoBuscaIBGE);
                        Object[] rowData = {cidadeEncontrada.getIbgeCode(), cidadeEncontrada.getCidade(),
                                            cidadeEncontrada.getPop2018(), cidadeEncontrada.getIDH(),
                                            cidadeEncontrada.getPib2014()};
                        model.addRow(rowData);
                    } else {
                        // Mostrar mensagem se não encontrar
                        labelComparacoes.setText("Não existe na base de dados");
                    }
                    break;
                // Adicione casos para outras colunas, se necessário
            }
        }
        
        
    }//GEN-LAST:event_btnbuscaActionPerformed

    private int buscaBinariaIBGE(String ibgeBuscado) {
        int esquerda = 0;
        int direita = lista.size() - 1;
        int comparacoes = 0;
        
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            Dados d = lista.get(meio);
            int comparacao = Integer.compare(d.getIbgeCode(), Integer.parseInt(ibgeBuscado));
            comparacoes++; 
            

            if (comparacao == 0) {
                labelComparacoes.setText("Comparacoes (Busca Binária): " + comparacoes);
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        labelComparacoes.setText("Comparacoes (Busca Binária): " + comparacoes);
        return -1;
    }
    
    private int buscaBinariaCidade(String cidadeBuscada) {
        int esquerda = 0;
        int direita = lista.size() - 1;
        int comparacoes = 0;
        
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            Dados d = lista.get(meio);
            int comparacao = d.getCidade().compareToIgnoreCase(cidadeBuscada);
            comparacoes++; 
            
            if (comparacao == 0) {
                labelComparacoes.setText("Comparacoes (Busca Binária): " + comparacoes);
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        labelComparacoes.setText("Comparacoes (Busca Binária): " + comparacoes);
        return -1;
    }
    
    private void buscarPorIBGECode(String termo) {
        DefaultTableModel model = (DefaultTableModel) tabelaDados.getModel();
        model.setRowCount(0);
        
        int comparacoes = 0;

        for (Dados d : lista) {
            comparacoes++;
            if (String.valueOf(d.getIbgeCode()).contains(termo)) {
                Object[] rowData = {d.getIbgeCode(), d.getCidade(), d.getPop2018(), d.getIDH(), d.getPib2014()};
                model.addRow(rowData);
            }
        }
        
        labelComparacoes.setText("Comparacoes (Busca Linear IBGE Code): " + comparacoes);
    }

    private void buscarPorCidade(String termo) {
        DefaultTableModel model = (DefaultTableModel) tabelaDados.getModel();
        model.setRowCount(0);
        int comparacoes = 0;
        
        for (Dados d : lista) {
            comparacoes++;
            if (d.getCidade().toLowerCase().contains(termo.toLowerCase())) {
                Object[] rowData = {d.getIbgeCode(), d.getCidade(), d.getPop2018(), d.getIDH(), d.getPib2014()};
                model.addRow(rowData);
            }
        }
        labelComparacoes.setText("Comparacoes (Busca Linear Cidade): " + comparacoes);
    }
    
    private void jTextBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscaActionPerformed

    private void jRadioButtonBinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBinariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonBinariaActionPerformed

    private void cbBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBuscaActionPerformed

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
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrdena;
    private javax.swing.JButton btnbusca;
    private javax.swing.JComboBox<String> cbBusca;
    private javax.swing.JComboBox<String> cbOrdena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonBinaria;
    private javax.swing.JRadioButton jRadioButtonLinear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBusca;
    private javax.swing.JLabel labelComparacoes;
    private javax.swing.JLabel lblProx;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}
