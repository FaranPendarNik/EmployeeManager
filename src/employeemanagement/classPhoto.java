
package employeemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Arrays;
import javafx.scene.image.Image;
import javax.swing.JFileChooser;

public class classPhoto {
    
    byte Ar[] = null;
    static String path = "";
    
        public Image setProfile(){
            String pathPhoto = null;
                JFileChooser choose = new JFileChooser();
                choose.setDialogTitle("profile");       
                int select = choose.showSaveDialog(null);
                if (select == JFileChooser.OPEN_DIALOG) {
                File fileType = choose.getSelectedFile();  //get File Type
                pathPhoto = fileType.getAbsolutePath();
                path = pathPhoto;
                }
                try {
                    File testPhoto = new File(pathPhoto);
                    FileInputStream st = new FileInputStream (pathPhoto);
                    Image img = new Image(st);
                    Ar = Files.readAllBytes(testPhoto.toPath());
                    return img;   
                } catch (Exception e) {
                    Image img = new Image("/photo/dont.png");
                    new notification("Incorrect Get Photo",e.getMessage(),img);
                }
            return null;
        }


        public byte[] getPhoto(){
           
            return Ar;
           
        }
        
 
        public String getPath(){
           
            return path;
           
        }        

    
}

