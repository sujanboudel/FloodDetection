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
public class UpdateMenu {

    JLabel jlabel1 = new JLabel("Enter Resident ID");

    JTextField field1 = new JTextField();

    public ResidentBean UpdateResidentMenu() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(jlabel1);
        panel.add(field1);
        String id;
        ResidentDao a = new ResidentDao();
        ResidentBean rb = null;
        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Resident Detail",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {

            try {
                Integer.parseInt(field1.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter Valid ID!");
                return null;
            }
            id = field1.getText();
            if (!"".equals(id)) {
                rb = a.getResident(id);
            } else {
                JOptionPane.showMessageDialog(null, "Enter Valid ID!");
                return null;
            }
            if (rb.getPhone()== null) {
                JOptionPane.showMessageDialog(null, "No Record Found!");
                return null;
            } else {
                JOptionPane.showMessageDialog(null, "Record Found!");
                return rb;
            }
        }
        return null;
    }
}
