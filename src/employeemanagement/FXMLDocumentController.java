
package employeemanagement;
import static employeemanagement.AddEmpoleeController.EMPLOYEE;
import com.jfoenix.controls.JFXButton;
import java.net.*;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton btnEmpoleeManager;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXButton btnPension;
    @FXML
    private JFXButton btnUpdateSalary;
    
    
    @FXML
    private JFXButton btnBack;
    @FXML
    private MenuBar menuBar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    


    @FXML
    private void Search(ActionEvent event) {
        if (EMPLOYEE.get(0).getAccess().equals("Admin")) {
            try {
            ChangeScene toSearch = new ChangeScene("showInfoEmployee.fxml",event);
            } catch (Exception e) {
                Image img = new Image("/photo/dont.png");
                new notification("Incorrect Change Scene",e.getMessage(),img);
            }
        }else{
            Image img = new Image("/photo/access.png");
            new notification("Access",String.format("%s عزیز سطح دسترسی شما محدود است",EMPLOYEE.get(0).getFirstName()),img);
        }
        
    }

    @FXML
    private void Pension(ActionEvent event) {
    }

    @FXML
    private void UpdateSalary(ActionEvent event) {
    }

    @FXML
    private void AddEmployee(ActionEvent event){
        if (EMPLOYEE.get(0).getAccess().equals("Admin")) {
            try {
            ChangeScene c1 = new ChangeScene("AddEmpolee.fxml",event);
            } catch (Exception e) {
                Image img = new Image("/photo/dont.png");
                new notification("Incorrect Change Scene","هنگام ورود به صحفه جدید خطایی رخ داد",img);
                System.out.println(e.getMessage());
            }
        }else{
            Image img = new Image("/photo/access.png");
            new notification("Access",String.format("%s عزیز سطح دسترسی شما محدود است",EMPLOYEE.get(0).getFirstName()),img);
        }
    }

    @FXML
    private void backScene(ActionEvent event) {
        try {
            ChangeScene c1 = new ChangeScene("Login.fxml",event);
            } catch (Exception e) {
                Image img = new Image("/photo/dont.png");
                new notification("Incorrect Change Scene",e.getMessage(),img);
            }
    }

    
}
