/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contsmartparking;

import java.sql.SQLException;

/**
 *
 * @author gemacron
 */
public class ContSmartParking {
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ExportDataForCont expdfc = new ExportDataForCont();
        expdfc.setVisible(true);
    }
    
}
