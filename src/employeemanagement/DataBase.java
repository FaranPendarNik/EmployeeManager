
package employeemanagement;
import static employeemanagement.AddEmpoleeController.EMPLOYEE;
import static employeemanagement.classPhoto.path;
import java.io.*;
import java.sql.*;
import javafx.scene.image.Image;
public class DataBase {
    
    String url = "jdbc:mysql://localhost:3306/";
    String user = "";
    String password = "";
    int success ;
    int success2 ;
    public void select(String codeMeli){
            employee em = new employee();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);          
            PreparedStatement state = con.prepareStatement("select * from faran.employee where CodeMeli = ?");
            state.setString(1,codeMeli);
            ResultSet rs = state.executeQuery();
            while(rs.next()){
            em.setFirstName(rs.getString(1));
            em.setLastName(rs.getString(2));
            em.setCodemeli(rs.getLong(3));
            em.setDateBirthday(rs.getString(4));
            em.setSex(rs.getString(5));
            em.setPosition(rs.getString(6));
            em.setFatherName(rs.getString(7));
            em.setMotherName(rs.getString(8));
            em.setMobile(rs.getLong(9));
            em.setAddress(rs.getString(10));
            em.setPostCode(rs.getLong(11));
            em.setDateEmployment(rs.getString(12));
            em.setSalary(rs.getLong(13));
            em.setRelationship(rs.getString(14));
            InputStream inputStream = rs.getBinaryStream(15);
            Image img = new Image(inputStream);
            em.setImg(img);
            em.setAccess(rs.getString(16));
            success2 = 1;
            } 
            rs.close();
            state.close();
            con.close(); 
        } catch (Exception e) {
            Image img = new Image("/photo/404.png");
            notification notif = new notification("Error connecting to database","هنگام اتصال به دیتابیس خطایی رخ داد", img);
            System.out.println(e.getMessage());
        }
        EMPLOYEE.add(em);
    }
 
    
    public void Insert(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement state = con.prepareStatement("INSERT INTO faran.employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            state.setString(1,EMPLOYEE.get(0).getFirstName());
            state.setString(2,EMPLOYEE.get(0).getLastName());
            state.setLong(3,EMPLOYEE.get(0).getCodemeli());
            state.setString(4,EMPLOYEE.get(0).getDateBirthday());
            state.setString(5,EMPLOYEE.get(0).getSex());
            state.setString(6,EMPLOYEE.get(0).getPosition());
            state.setString(7,EMPLOYEE.get(0).getFatherName());
            state.setString(8,EMPLOYEE.get(0).getMotherName());
            state.setLong(9,EMPLOYEE.get(0).getMobile());
            state.setString(10,EMPLOYEE.get(0).getAddress());
            state.setLong(11,EMPLOYEE.get(0).getPostCode());
            state.setString(12,EMPLOYEE.get(0).getDateEmployment());
            state.setLong(13,EMPLOYEE.get(0).getSalary());
            state.setString(14,EMPLOYEE.get(0).getRelationship());
            InputStream st = new FileInputStream (path);
            state.setBlob(15,st);
            state.setString(16,EMPLOYEE.get(0).getAccess());
            state.execute();
            success = 1;
            state.close();
            con.close();
        } catch (Exception e) {
            Image img = new Image("/photo/404.png");
            notification notif = new notification("Error connecting to database","هنگام اتصال به دیتابیس خطایی رخ داد", img);
            System.out.println(e.getMessage());
        }
        EMPLOYEE.clear();
    }
    
    
    
}
