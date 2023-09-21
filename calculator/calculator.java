package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class calculator {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_result;

    private long number1=0;
    private String operator="";
    private boolean start = true;
    private Model model = new Model();

    @FXML
    void processNumber(ActionEvent event) {
         if(start) {
        	txt_result.setText("");
        	 start = false;
         }
         String value = ((Button)event.getSource()).getText();
         txt_result.setText(txt_result.getText() + value);
    }

    @FXML
    void processOperator(ActionEvent event) {
         String value = ((Button)event.getSource()).getText();
         
         if(!value.equals("=")) {
        	  if(!operator.equals("")) {
        		  return;
        	  }
         
         operator = value;
         number1=Long.parseLong(txt_result.getText());
         txt_result.setText("");
         
    } else {
    	if(operator.equals("")) {
    		return;
    	}
    	
    	long number2 = Long.parseLong(txt_result.getText());
    	float output = model.calculate(number1, number2, operator);
    	txt_result.setText(String.valueOf(output));
    	operator="";
    	start = true;
        }
    }



}
