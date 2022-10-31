/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package contsmartparking;

import com.opencsv.CSVWriter;
import controller.ViewDatosDetallePagoOnlineJpaController;
import controller.ViewDatosPagoOnlineJpaController;
import entidades.ViewDatosDetallePagoOnline;
import entidades.ViewDatosPagoOnline;
import java.awt.Color;
import java.awt.Cursor;
import java.io.File;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author gemacron
 */
public final class ExportDataForCont extends javax.swing.JFrame {

    private ViewDatosPagoOnlineJpaController vdpjc = new ViewDatosPagoOnlineJpaController();
    private ViewDatosDetallePagoOnlineJpaController DetallePagoController = new ViewDatosDetallePagoOnlineJpaController();

    /**
     * Creates new form ExportDataForCont
     *
     * @throws java.sql.SQLException
     */
    public ExportDataForCont() throws SQLException {
        initComponents();
        this.setTitle("Formato RG90");
        cargarDatosIniciales();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombrePos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        idBoton = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        Combomes = new javax.swing.JComboBox<>();
        Comboano = new javax.swing.JComboBox<>();
        progressotxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha :");

        jLabel2.setText("Año :");

        nombrePos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*.*", "POS01", "POS02", "POS03", "POS04", "POS05", "POS06" }));

        jLabel3.setText("Caja :");

        idBoton.setText("Generar Datos");
        idBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idBotonMouseClicked(evt);
            }
        });
        idBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBotonActionPerformed(evt);
            }
        });

        Combomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombomesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(idBoton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombrePos, 0, 149, Short.MAX_VALUE)
                                    .addComponent(Combomes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(131, 131, 131)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Comboano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(progressotxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(Combomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comboano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBotonActionPerformed

    private void idBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idBotonMouseClicked

        Thread hilo = new Thread() {
            @Override
            @SuppressWarnings("ConvertToTryWithResources")
            public void run() {
                try {
                    // TODO add your handling code here:
                    FileSystemView fsv = FileSystemView.getFileSystemView();
                    File com = fsv.getHomeDirectory();
                    // La ruta real del escritorio
                    String Desktop = com.getPath();
                    System.err.println(Desktop);

                    jProgressBar1.setValue(0);
                    progressotxt.setText("");
                    idBoton.setEnabled(false);
                    Integer contFile = 1;
                    Integer contFileName = 1;
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    Integer ano = Integer.parseInt(Comboano.getSelectedItem().toString());
                    Integer mes = formatMonth(Combomes.getSelectedItem().toString());
                    String pos = nombrePos.getSelectedItem().toString();

                    @SuppressWarnings({"Convert2Diamond", "UnusedAssignment"})
                    List<ViewDatosPagoOnline> datosPago = new ArrayList<ViewDatosPagoOnline>();

                    int i = 1;
                    List<String[]> data = new ArrayList<>();

                    datosPago = vdpjc.findViewDatosPagoDate(ano, mes, pos);
                    Integer cantidaddatos = datosPago.size();
                    jProgressBar1.setMaximum(cantidaddatos);
                    System.out.println("Cantidad de datos para el Jprogressbar:" + cantidaddatos);

                    for (ViewDatosPagoOnline dp : datosPago) {
                        @SuppressWarnings("UnusedAssignment")
                        ViewDatosDetallePagoOnline vddpo = new ViewDatosDetallePagoOnline();
                        vddpo = DetallePagoController.findViewDatosDetallePagoOnline(dp.getIdentificador());
                        @SuppressWarnings("UnusedAssignment")
                        String fechformtt = "";
                        fechformtt = formatoFechaConocido(dp.getFechaPago());
                        String factura = formatearNroFactura(dp.getFactura());
                        String nroRucCliente = formateaRucCliente(dp.getIdCliente());
                        if (!dp.getNombreCliente().equals("MOSTRADOR")) {
                            data.add(new String[]{"1", "11", ""
                                + nroRucCliente + "", "" + dp.getNombreCliente() + "", "109", ""
                                + fechformtt + "", "" + vddpo.getTimbrado() + "", "" + factura + "", ""
                                + dp.getValorPago().longValueExact() + "", "0", "0", "" + dp.getValorPago().longValueExact() + "", "1", "N", "S", "N", "N", "", ""});
                        } else {
                            data.add(new String[]{"1", "15", ""
                                + "x", "SIN NOMBRE", "109", ""
                                + fechformtt + "", "" + vddpo.getTimbrado() + "", "" + factura + "", ""
                                + dp.getValorPago().longValueExact() + "", "0", "0", "" + dp.getValorPago().longValueExact() + "", "1", "N", "S", "N", "N", "", ""});
                        }

                        if (contFile == 5000 || i == cantidaddatos) {
                            @SuppressWarnings("UnusedAssignment")
                            String mess = "";
                            Formatter obj = new Formatter();
                            mess = String.valueOf(obj.format("%02d", Integer.valueOf(mes.toString())));
                            String filename = "" + Desktop + "\\80120488_REG_" + mess + "" + ano + "_V0001" + contFileName + ".csv";
                            File file = new File(filename);
                            // create FileWriter object with file as parameter
                            FileWriter outputfile = new FileWriter(file);
                            // create CSVWriter object filewriter object as parameter
                            CSVWriter writer = new CSVWriter(outputfile, ';',
                                    CSVWriter.NO_QUOTE_CHARACTER,
                                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                    CSVWriter.DEFAULT_LINE_END);
                            // create a List which contains String array
                            System.out.println("Creado archivo");
                            writer.writeAll(data);
                            writer.close();
                            contFileName++;
                            contFile = 1;
                            data.clear();
                        }
//                        System.out.println("Datos: |" + dp.getIdCliente() + "|" + dp.getNombreCliente() + "|" + dp.getFactura() + "|" + dp.getValorPago().longValueExact() + "");
//                        cargarJProgressBar(cantidaddatos, i);
                        jProgressBar1.setValue(i);
                        jProgressBar1.setStringPainted(true);
                        i++;
                        contFile++;

                    }
                    progressotxt.setText("Datos exportados Correctamente ");
                    progressotxt.setForeground(Color.GREEN);
                    System.out.println("Fin de la Exportación");
                    idBoton.setEnabled(true);
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
//                    JOptionPane.showMessageDialog("Fin de la Exportación. Nombre del Archivo:" + filename);
                } catch (ParseException ex) {
                    Logger.getLogger(ExportDataForCont.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ExportDataForCont.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        hilo.start();
    }//GEN-LAST:event_idBotonMouseClicked

    private void CombomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombomesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CombomesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Comboano;
    private javax.swing.JComboBox<String> Combomes;
    private javax.swing.JButton idBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JComboBox<String> nombrePos;
    private javax.swing.JLabel progressotxt;
    // End of variables declaration//GEN-END:variables

    public void cargarDatosIniciales() throws SQLException {

        List<Integer> yearList = vdpjc.listFromYear();
        for (Integer a : yearList) {
            Comboano.addItem(a.toString());
        }
        List<Integer> monthList = vdpjc.listFromMonth();
        for (Integer m : monthList) {
            Combomes.addItem(convertirAMes(Integer.parseInt(m.toString())));
        }

    }

    public String convertirAMes(Integer numero) {
        int mesdeTermino = numero;
        Locale locale = new Locale("es", "ES");
        Month mMonth = Month.of(mesdeTermino);
        String monthName = mMonth.getDisplayName(TextStyle.FULL, locale);
        System.out.println(monthName);
        return monthName;
    }

    public Integer formatMonth(String month) throws ParseException {
        Locale locale = new Locale("es", "ES");
        DateTimeFormatter parse = DateTimeFormatter.ofPattern("MMMM").withLocale(locale);
        TemporalAccessor accessor = parse.parse(month);
        return accessor.get(ChronoField.MONTH_OF_YEAR);
    }

    public String formatoFechaConocido(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaformat = sdf.format(fecha);
        return fechaformat;

    }

    @SuppressWarnings("UnusedAssignment")
    public String formatearNroFactura(String nroFactura) {
        String formated = "";
        String cadena_a, cadena_b, cadena_c = nroFactura;
        cadena_a = cadena_c.substring(9);
        cadena_b = cadena_c.substring(0, cadena_c.length() - cadena_a.length());
        cadena_a = cadena_a.replaceAll(" ", "");
        cadena_b = cadena_b.replace(" ", "");
        Formatter obj = new Formatter();
        formated = String.valueOf(obj.format("%07d", Integer.valueOf(cadena_a)));
        return cadena_b + formated;
    }

    @SuppressWarnings("UnusedAssignment")
    public String formateaRucCliente(String rucCliente) {
        String cadena_a, cadena_b, cadena_c = rucCliente;
        if (cadena_c.contains("-")) {
            cadena_b = cadena_c.replace("-", "");
            cadena_a = cadena_c.substring(0, cadena_b.length() - 1);
        } else {
            cadena_a = cadena_c;
        }
//        System.out.println("Ruc Del Cliente:" + cadena_a);
        return cadena_a;
    }

}
