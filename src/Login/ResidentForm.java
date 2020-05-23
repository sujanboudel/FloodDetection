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
public class ResidentForm {

    JLabel jlabel1 = new JLabel("First Name:");
    JLabel jlabel2 = new JLabel("Last Name:");
    JLabel jlabel3 = new JLabel("Phone:");
    JLabel jlabel4 = new JLabel("Suburb:");

    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();

    public ResidentForm() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(jlabel1);
        panel.add(field1);
        panel.add(jlabel2);
        panel.add(field2);
        panel.add(jlabel3);
        panel.add(field3);
        panel.add(jlabel4);
        panel.add(field4);
        int result = JOptionPane.showConfirmDialog(null, panel, "Add new resident",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ResidentDao a = new ResidentDao();
            ResidentBean nr = new ResidentBean();
            nr.setFirstName(field1.getText());
            nr.setLastName(field2.getText());
            nr.setPhone(field3.getText());
            nr.setSuburb(field4.getText());
            a.addResident(nr);
            JOptionPane.showMessageDialog(null, "Record Added Successfully");
        }
    }
}
