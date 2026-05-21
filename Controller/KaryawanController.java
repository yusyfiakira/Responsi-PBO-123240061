package Controller;
import View.Karyawan.ViewData;
import javax.swing.JButton;

public class KaryawanController {
    private final ViewData view;
    private final DataDAO dao;
    
    public KaryawanController (ViewData v){
        view.getBtnAdd()
                .addActionListener (e.tambah());
        view.getBtnUpdate()
                .addActionListener(e.update());
        view.getBtnDelete()
                .addActionListener(e.delete());
        view.getBtnClear()
                .addActionListener(e.clear());
        
        view.getTable().getSelectionModel()
                .addListSelectionListener(e.{if(!e.getValueIsAdjusting())
                    fillform();});
    }
    public void loadData(){
         = "SELECT * FROM evaluasi;";
    };
    public void tambah(){};
    public void update(){};
    public void delete(){};
    public void clear(){};
    
}
