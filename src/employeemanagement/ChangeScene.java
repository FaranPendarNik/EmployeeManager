
package employeemanagement;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeScene  {
    
    
    public ChangeScene(String Address , ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(Address));
        
        Scene scene = new Scene(root);
        
        Stage pageNew = (Stage) ((Node)event.getSource()).getScene().getWindow();
        pageNew.setScene(scene);
        pageNew.show();
    }
    
}
