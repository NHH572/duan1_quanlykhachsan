/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Minh Triet
 */
public class test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(date);
    }

}
