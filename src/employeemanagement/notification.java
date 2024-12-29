
package employeemanagement;

import java.util.Random;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.util.*;
import org.controlsfx.control.Notifications;

public class notification {
    private String title;
    private String text;
    private Image img;
    
    public notification(String title, String text, Image img) {
        this.title = title;
        this.text = text;
        this.img = img;      
        Notifications ntf = Notifications.create()
        .title(title)
        .text(text)
        .position(Pos.BOTTOM_RIGHT)
        .graphic(new ImageView(img))        
        .hideAfter(Duration.seconds(8));
        ntf.show();
    }
}
