/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.helper;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.red;
=======
import static java.awt.Color.pink;
>>>>>>> Stashed changes
=======
import static java.awt.Color.pink;
>>>>>>> Stashed changes
import static java.awt.Color.white;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Laptop
 */
public class utilityHelper {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
        public static boolean checkNullText2(JTextArea txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    /*
    1-10 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkUserNV(JTextField txt){
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{1,15}";
        if(id.matches(rgx)){
            return true;
        }else{
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(),txt.getName() + " UserName phải có 1-15 kí tự \n chữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }
   //gồm 10 số 
    //các đầu 3 số của nhà mạng
    public static boolean checkSDT(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
=======
=======
>>>>>>> Stashed changes
    /*
    1-10 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkUserNV(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{1,15}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải có 1-15 kí tự \n chữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }
     //pass từ 3-16 kí tự
    public static boolean checkPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 2 && txt.getPassword().length < 17) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải có từ 3-16 kí tự.");
            return false;
        }
    }
    //gồm các ký tự chữ đấu cách
    //từ 3-25 kí tự
    public static boolean checkName(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + "  phải là tên tiếng việt hoặc không đấu \n từ 3-25 kí tự");
            return false;
        }
    }
     public static boolean checkNameDoiTac(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            MsgBox.alert(txt.getRootPane(), txt.getName() + " SDT phải gồm 10 số\nđúng các đầu số của nhà mạng.");
            return false;
        }
    }
    //gồm các ký tự chữ đấu cách
    //từ 3-25 kí tự
    public static boolean checkName(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
=======
=======
>>>>>>> Stashed changes
            MsgBox.alert(txt.getRootPane(), txt.getName() + "phải là tên tiếng việt từ 3-25 kí tự");
            return false;
        }
    }
     /*
    đúng 4 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkMaDoitac(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{4}";
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            MsgBox.alert(txt.getRootPane(), txt.getName() + " Name phải là tên tiếng việt hoặc không đấu \n từ 3-25 kí tự");
            return false;
        }
    }
     public static boolean checkNameDoiTac(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
=======
=======
>>>>>>> Stashed changes
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải có đúng 4 kí tự \n chữ thường, chữ hoa hoặc số");
            return false;
        }
    }
       //gồm 10 số 
    //các đầu 3 số của nhà mạng
    public static boolean checkSDT(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            MsgBox.alert(txt.getRootPane(), txt.getName() + " Tên đối tác phải là tên tiếng việt \n từ 3-25 kí tự");
=======
            MsgBox.alert(txt.getRootPane(), txt.getName() + "  phải gồm 10 số \n đúng các đầu số của nhà mạng.");
>>>>>>> Stashed changes
=======
            MsgBox.alert(txt.getRootPane(), txt.getName() + "  phải gồm 10 số \n đúng các đầu số của nhà mạng.");
>>>>>>> Stashed changes
            return false;
        }
    }
     public static boolean checkEmail(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " Email không đúng định dạng");
            return false;
        }
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
     public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
=======
         public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
>>>>>>> Stashed changes
=======
         public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
>>>>>>> Stashed changes
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    /*
    đúng 5 kí tự
    a-z, A-Z, 0-9
     */
    public static boolean checkMaDoiTac(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{4}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " Mã Đối Tác phải có đúng 4 kí tự \n chữ thường, chữ hoa hoặc số");
=======
=======
>>>>>>> Stashed changes

    public static boolean checkNullText2(JTextArea txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
        public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
            return false;
        }
    }
}
