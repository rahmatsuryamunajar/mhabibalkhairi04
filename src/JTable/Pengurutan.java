package JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pengurutan {
    private JTextField textAngka1;
    private JTextField textAngka2;
    private JButton Buttonurut;
    private JTable table1;
    private JPanel rootPanel;
    private DefaultTableModel tableModel;
    private boolean added = false;

    public JPanel getrootPanel1() {
        return rootPanel;
    }
    public Pengurutan() {
        this.initComponents();
        Buttonurut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)
                        table1.getModel();
                String jumlah2 = textAngka2.getText();
                int jumlah = Integer.parseInt(textAngka1.getText());
                String angka = textAngka2.getText();

                if (textAngka1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "jumlah angka tidak diketahui",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (angka.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Angka belum diinput",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
                if (!added) {
                    for (int i = 0; i < jumlah; i++) {
                        model.addRow(new Object[]{});
                    }
                    added = true;
                } else {
                    model.addRow(new Object[]{jumlah2, angka});
                    //clear textfield
                    textAngka1.setText("");
                    textAngka2.setText("");
                }
                int a = 0;
                for (int i : Urutan.getascen(angka, jumlah)) {
                    model.setValueAt(i, a, 0);
                    a++;
                }
                int b = 0;
                for (int i : Urutan.getdescen(angka, jumlah)) {
                    model.setValueAt(i, b, 1);
                    b++;
                }
            }
        });
    }


    private void initComponents() {
        Object[] tableColom = {
                "Ascending",
                "Descending"
        };
        Object[][] initData = {

        };
        tableModel = new DefaultTableModel(initData, tableColom);
        //set table model
        table1.setModel(tableModel);
        //menampilkan sorting di setiap kolom
        table1.setAutoCreateRowSorter(true);
        //hidupkan single selection
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

}

