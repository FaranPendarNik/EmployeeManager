
package employeemanagement;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AddEmpoleeController implements Initializable {

    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtCodeMeli;
    @FXML
    private DatePicker pickerBirthday;
    @FXML
    private JFXRadioButton togMen;
    @FXML
    private JFXRadioButton togWomen;
    @FXML
    private TextField txtPosition;
    @FXML
    private TextField txtMother;
    @FXML
    private TextField txtFather;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPostCode;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnClear;
    @FXML
    private DatePicker txtDateEmployment;
    @FXML
    private TextField txtSalary;
    @FXML
    private JFXToggleButton toggleRelationShip;
    @FXML
    private JFXButton btnGetPhoto;
    @FXML
    private ImageView IVphoto;
    @FXML
    private JFXToggleButton togAccess;

    static ArrayList<employee>EMPLOYEE=new ArrayList<>();
    employee em = new employee();
    classPhoto cp = new classPhoto();
    DataBase db = new DataBase();
    sabtAhval sa = new sabtAhval();
    @FXML
    private JFXButton btnBack;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        
    }    

    @FXML
    private void toggleMen(ActionEvent event) {
        if (togMen.isSelected()) {
            togWomen.setSelected(false);
        }
    }

    @FXML
    private void toggleWomen(ActionEvent event) {
        if (togWomen.isSelected()) {
            togMen.setSelected(false);
        }
    }

    @FXML
    private void GetPhoto(ActionEvent event)  {
        btnGetPhoto.setText("");
        IVphoto.setImage(cp.setProfile());  
    }

    @FXML
    private void save(ActionEvent event) {
            db.select(txtCodeMeli.getText());
            if (db.success2 == 1) {
            int x = EMPLOYEE.size()-1;
            new notification("کارمند تکراری",String.format("این کارمند با نام %s در سمت %s در سامانه وجود دارد.",EMPLOYEE.get(x).getFirstName(),EMPLOYEE.get(x).getPosition()),EMPLOYEE.get(x).getImg());    
            }else {
            em.setFirstName(txtFirstName.getText());
            em.setLastName(txtLastName.getText());
            if (sa.test(txtCodeMeli.getText()) == 1) {
            em.setCodemeli(Long.parseLong(txtCodeMeli.getText()));
            em.setDateBirthday(pickerBirthday.getEditor().getText());
            if (togMen.isSelected()) {
                em.setSex("Men");
            }else{
                em.setSex("Women");
            }
            em.setPosition(txtPosition.getText());
            em.setFatherName(txtFather.getText());
            em.setMotherName(txtMother.getText());
            em.setMobile(Long.parseLong(txtMobile.getText()));
            em.setAddress(txtAddress.getText());
            em.setPostCode(Long.parseLong(txtPostCode.getText()));
            em.setDateEmployment(txtDateEmployment.getEditor().getText());
            em.setSalary(Long.parseLong(txtSalary.getText()));
            if (toggleRelationShip.isSelected()) {
                em.setRelationship("Married");
            }else{
                em.setRelationship("Single");
            }
            //em.setImg(cp.getPhoto());
            if (togAccess.isSelected()) {
            em.setAccess("Admin");
            }else{
            em.setAccess("Employee");
            }
            EMPLOYEE.add(em);
            db.Insert();
            }else{
            Image img = new Image("/photo/sabt.png");
            new notification("UnSuccess","عدم تطابق کدملی با ثبت احوال کل کشور",img);
            }
            if (db.success==1) {
            this.Clear(event);
            Image img = new Image("/photo/success.png");
            new notification("Success","ثبت نام کاربر جدید با موفقیت انجام شد",img);
            }
            }
            
            
    }

    @FXML
    private void Clear(ActionEvent event) {
            txtFirstName.clear();
            txtLastName.clear();
            txtCodeMeli.clear();
            pickerBirthday.getEditor().clear();
            togMen.setSelected(false);
            togWomen.setSelected(false);
            txtPosition.clear();
            txtFather.clear();
            txtMother.clear();
            txtMobile.clear();
            txtAddress.clear();
            txtPostCode.clear();
            txtDateEmployment.getEditor().clear();
            txtSalary.clear();
            toggleRelationShip.setSelected(true);
            IVphoto.setImage(null);
            togAccess.setSelected(true);
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
