
package employeemanagement;
import static employeemanagement.AddEmpoleeController.EMPLOYEE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtCodeMeli;
    @FXML
    private TextField txtPassword;

    
    DataBase db = new DataBase();
    String password = "taraamahmoudi";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {  
        db.select(txtCodeMeli.getText());
        if (db.success2==1 && txtPassword.getText().equals(password)) {
            try {
            new notification(EMPLOYEE.get(0).getPosition(),String.format("%s عزیز با موفقیت وارد شدید",EMPLOYEE.get(0).getFirstName()),EMPLOYEE.get(0).getImg());    
            ChangeScene c1 = new ChangeScene("FXMLDocument.fxml",event);
            } catch (Exception e) {
                Image img = new Image("/photo/dont.png");
                new notification("Incorrect Change Scene","هنگام ورود به صحفه جدید خطایی رخ داد",img);
            }
        }else{
            Image img = new Image("/photo/wrong.png");
            new notification("UnSuccess","نام کاربری یا رمز عبور صحیح نمی باشد",img);
        }
   
    }
    
}
