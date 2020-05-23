/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.FloodDetection.Dao.ResidentDao;
import com.FloodDetection.bean.ResidentBean;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author sujan boudel
 */
public class DeleteMenu {

    JLabel jlabel1 = new JLabel("Enter ID of Resident to Delete");

    JTextField field1 = new JTextField();

    public DeleteMenu() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(jlabel1);
        panel.add(field1);
        String id;
        ResidentDao a = new ResidentDao();
        ResidentBean rb = new ResidentBean();
        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Resident",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            id = field1.getText();
            try {
                Integer.parseInt(field1.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter Valid ID!");
                return;
            }
            if(a.deleteResident(id)==1){
            JOptionPane.showMessageDialog(null, "Record Deleted!");}
            else{  JOptionPane.showMessageDialog(null, "Record Not Found!");}
        }

    }
}
