package application;
import java.sql.*;
import javax.swing.JOptionPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class users {

	//Database Connection String
	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Hari?characterEncoding=utf8";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<userModel> getUserList(){
		ObservableList<userModel> userList = FXCollections.observableArrayList();
		String sql = "SELECT ID, NAME, AGE,CITY from users";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			userModel user;
			while(rs.next()) {
				user = new userModel(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("CITY"));
				userList.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	//Show User Details
	public void loadData() {
		ObservableList<userModel> list = getUserList();
		colID.setCellValueFactory(new PropertyValueFactory<userModel, Integer>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<userModel, String>("name"));
		colAge.setCellValueFactory(new PropertyValueFactory<userModel, Integer>("age"));
		colCity.setCellValueFactory(new PropertyValueFactory<userModel, String>("city"));
		table.setItems(list);
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<userModel, Integer> colAge;

    @FXML
    private TableColumn<userModel, String> colCity;

    @FXML
    private TableColumn<userModel, Integer> colID;

    @FXML
    private TableColumn<userModel, String> colName;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblID;

    @FXML
    private Label lblName;

    @FXML
    private TableView<userModel> table;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    void btnClearClicked(ActionEvent event) {
           txtID.setText("");
           txtName.setText("");
           txtAge.setText("");
           txtCity.setText("");
    }

    @FXML
    void btnDeleteClicked(ActionEvent event) {
         //Deleted details 
    	      String id = txtID.getText();
    	      if(!txtID.getText().isEmpty()) {
    	    	  int result = JOptionPane.showConfirmDialog(null,"Sure? You want to Delete?", "Delete",
    	    	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	      
    	      if(result == JOptionPane.YES_OPTION) {
    	    	  try {
    	    		  String sql = "delete from users where ID=?";
    	    		  pst = con.prepareStatement(sql);
    	    		  pst.setString(1, id);
    	    		  pst.executeUpdate();
    	    		  JOptionPane.showMessageDialog(null, "Data Deleted Success");
    	    		  btnClearClicked(event);
    	    		  loadData();
    	    	  }catch(SQLException e1) {
    	    		  e1.printStackTrace();
    	    	  }
    	       }
    	      }
    }

    @FXML
    void btnSaveClicked(ActionEvent event) {
          //Save Details
    	   String name = txtName.getText();
    	   String age = txtAge.getText();
    	   String city = txtCity.getText();
    	   
    	   
    	   if(name == null || name.isEmpty() || name.trim().isEmpty()) {
    		   JOptionPane.showMessageDialog(null, "Pleasse Enter Name");
    		   txtName.requestFocus();
    		   return;
    	   }
    	   if(age == null || age.isEmpty() || age.trim().isEmpty()) {
    		   JOptionPane.showMessageDialog(null, "Pleasse Enter age");
    		   txtAge.requestFocus();
    		   return;
    	   }
    	   if(city == null || city.isEmpty() || city.trim().isEmpty()) {
    		   JOptionPane.showMessageDialog(null, "Pleasse Enter city");
    		   txtCity.requestFocus();
    		   return;
    	   }
    	   if(txtID.getText().isEmpty()) {
    		   try {
    			   String sql = "insert into users (NAME, AGE, CITY) values (?,?,?)";
    			   pst = con.prepareStatement(sql);
    			   pst.setString(1, name);
    			   pst.setString(2, age);
    			   pst.setString(3, city);
    			   pst.executeUpdate();
    			   JOptionPane.showMessageDialog(null, "Data insert Success");
    			   btnClearClicked(event);
    			   loadData();
    		   }catch(Exception e) {
    			   e.printStackTrace();
    		   }
    	   }
    }

    @FXML
    void btnUpdateClicked(ActionEvent event) {
        //Data update
       String name = txtName.getText();
   	   String age = txtAge.getText();
   	   String city = txtCity.getText();
       String id = txtID.getText();
   	   
   	   if(name == null || name.isEmpty() || name.trim().isEmpty()) {
   		   JOptionPane.showMessageDialog(null, "Pleasse Enter Name");
   		   txtName.requestFocus();
   		   return;
   	   }
   	   if(age == null || age.isEmpty() || age.trim().isEmpty()) {
   		   JOptionPane.showMessageDialog(null, "Pleasse Enter age");
   		   txtAge.requestFocus();
   		   return;
   	   }
   	   if(city == null || city.isEmpty() || city.trim().isEmpty()) {
   		   JOptionPane.showMessageDialog(null, "Pleasse Enter city");
   		   txtCity.requestFocus();
   		   return;
   	   }
   	   if(!txtID.getText().isEmpty()) {
   		   try {
   			   String sql = "update users set NAME =?, AGE =?, CITY=? where ID=?";
   			   pst = con.prepareStatement(sql);
   			   pst.setString(1, name);
   			   pst.setString(2, age);
   			   pst.setString(3, city);
   			   pst.setString(4, id);
   			   pst.executeUpdate();
   			   JOptionPane.showMessageDialog(null, "Data Update Success");
   			   btnClearClicked(event);
   			   loadData();
   		   }catch(Exception e) {
   			   e.printStackTrace();
   		   }
   	   }
    }

    @FXML
    void tableClicked(MouseEvent event) {
             userModel user = table.getSelectionModel().getSelectedItem();
             txtID.setText(String.valueOf(user.getId()));
             txtName.setText(user.getName());
             txtAge.setText(String.valueOf(user.getAge()));
             txtCity.setText(user.getCity());
    }

    @FXML
    void initialize() {
    	 Connect();
    	 loadData();
    }

}
