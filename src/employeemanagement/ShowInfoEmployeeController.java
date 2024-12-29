
package employeemanagement;

import static employeemanagement.AddEmpoleeController.EMPLOYEE;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowInfoEmployeeController implements Initializable {

    @FXML
    private ImageView imgPhoto;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblCodeMeli;
    @FXML
    private Label lblDateBirthday;
    @FXML
    private Label lblPosition;
    @FXML
    private Label lblFatherName;
    @FXML
    private Label lblMotherName;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblPostCode;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblDateEmployment;
    @FXML
    private Label lblSalary;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXButton btnBack;
    
    
    DataBase db = new DataBase();
    sabtAhval sb = new sabtAhval();

    @FXML
    private Label T1;
    @FXML
    private Label T2;
    @FXML
    private Label T3;
    @FXML
    private Label T4;
    @FXML
    private Label T5;
    @FXML
    private Label T6;
    @FXML
    private Label T7;
    @FXML
    private Label T8;
    @FXML
    private Label T9;
    @FXML
    private Label T10;
    @FXML
    private Label T11;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EmployeeSearch(ActionEvent event) {
        if (sb.test(txtSearch.getText()) == 1) {
            db.select(txtSearch.getText());
            if (db.success2 == 1) {
                int x = EMPLOYEE.size()-1;
                T1.setVisible(true);
                T2.setVisible(true);T3.setVisible(true);T4.setVisible(true);T5.setVisible(true);T6.setVisible(true);
                T7.setVisible(true);T8.setVisible(true);T9.setVisible(true);T10.setVisible(true);T11.setVisible(true);
                lblFirstName.setText(EMPLOYEE.get(x).getFirstName());
                lblLastName.setText(EMPLOYEE.get(x).getLastName());
                lblCodeMeli.setText(String.valueOf(EMPLOYEE.get(x).getCodemeli()));
                lblDateBirthday.setText(EMPLOYEE.get(x).getDateBirthday());
                lblPosition.setText(EMPLOYEE.get(x).getPosition());
                lblFatherName.setText(EMPLOYEE.get(x).getFatherName());
                lblMotherName.setText(EMPLOYEE.get(x).getMotherName());
                lblAddress.setText(EMPLOYEE.get(x).getAddress());
                lblPostCode.setText(String.valueOf(EMPLOYEE.get(x).getPostCode()));
                lblDateEmployment.setText(EMPLOYEE.get(x).getDateEmployment());
                imgPhoto.setImage(EMPLOYEE.get(x).getImg());
                lblSalary.setText(String.valueOf(EMPLOYEE.get(x).getSalary()));
            }else{
            Image img = new Image("/photo/nouser.png");
            new notification("UnSuccess","کارمندی با این مشخصات وجود ندارد",img);
            }
        }else{
        Image img = new Image("/photo/sabt.png");
        new notification("UnSuccess","عدم تطابق کدملی با ثبت احوال کل کشور",img);
        }
        
        
        
    }

    @FXML
    private void backScene(ActionEvent event) {
        try {
            ChangeScene c1 = new ChangeScene("FXMLDocument.fxml",event);
            } catch (Exception e) {
                Image img = new Image("/photo/dont.png");
                new notification("Incorrect Change Scene","هنگام ورود به صحفه جدید خطایی رخ داد",img);
                System.out.println(e.getMessage());
            }
    }
    
}
