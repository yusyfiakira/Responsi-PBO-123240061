//tambahin controller dan actionListener
package View.Karyawan;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.DatabaseConnection;
import com.sun.jdi.connect.spi.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

private DatabaseConnection(){};

public class ViewData extends JFrame {
    String URL = "jdbc:mysql://localhost:3306/employee_db";
    String USER = "root";
    String PASS = "";
    try {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewData.class.getName()).log(Level.SEVERE, null, ex);
        }
    Connection conn = DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException e){e.printStackTrace();}
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM evaluasi");
    while (rs.next()){
        int id = rs.getInt("id");
        String nama = rs.getString("nama");
        String divisi = rs.getString("divisi");
        double nilai_target = rs.getDoule("nilai_target");
        double nilai_disiplin = rs.getDoule("nilai_disiplin");
        double nilai_inovasi = rs.getDoule("nilai_inovasi");
        double nilai_akhir = rs.getDoule("nilai_akhir");
        String status = rs.getString("status");
    }
    public JTable table;
    public JTextField tfId, tfNama, tfTarget, tfDisiplin, tfInovasi;
    public JComboBox<String> cbDivisi;
    public JButton btnAdd, btnUpdate, btnDelete, btnClear;

    public ViewData() {
        setTitle("Sistem Evaluasi Kinerja Karyawan");
        setSize(850, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 550, 350);
        add(scrollPane);

        JLabel lNama = new JLabel("Nama Karyawan:");
        lNama.setBounds(600, 20, 150, 20);
        add(lNama);
        tfNama = new JTextField();
        tfNama.setBounds(600, 40, 200, 25);
        add(tfNama);

        JLabel lDivisi = new JLabel("Divisi:");
        lDivisi.setBounds(600, 70, 150, 20);
        add(lDivisi);
        cbDivisi = new JComboBox<>(new String[]{"Divisi Teknis", "Divisi Pemasaran"});
        cbDivisi.setBounds(600, 90, 200, 25);
        add(cbDivisi);

        JLabel lTarget = new JLabel("Nilai Target:");
        lTarget.setBounds(600, 120, 150, 20);
        add(lTarget);
        tfTarget = new JTextField();
        tfTarget.setBounds(600, 140, 200, 25);
        add(tfTarget);

        JLabel lDisiplin = new JLabel("Nilai Kedisiplinan:");
        lDisiplin.setBounds(600, 170, 150, 20);
        add(lDisiplin);
        tfDisiplin = new JTextField();
        tfDisiplin.setBounds(600, 190, 200, 25);
        add(tfDisiplin);

        JLabel lInovasi = new JLabel("Nilai Inovasi:");
        lInovasi.setBounds(600, 220, 150, 20);
        add(lInovasi);
        tfInovasi = new JTextField();
        tfInovasi.setBounds(600, 240, 200, 25);
        add(tfInovasi);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(600, 280, 90, 25);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(710, 280, 90, 25);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(600, 315, 90, 25);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(710, 315, 90, 25);
        add(btnClear);

        tfId = new JTextField(); // Hidden Field

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfId.setText(table.getValueAt(row, 0).toString());
                tfNama.setText(table.getValueAt(row, 1).toString());
                cbDivisi.setSelectedItem(table.getValueAt(row, 2).toString());
                tfTarget.setText(table.getValueAt(row, 3).toString());
                tfDisiplin.setText(table.getValueAt(row, 4).toString());
                tfInovasi.setText(table.getValueAt(row, 5).toString());
            }
        });

        setVisible(true);
    }
}