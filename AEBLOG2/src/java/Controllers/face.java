/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Conection.DBconnection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="face")
public class face {
    DBconnection con;

    public DBconnection getCon() {
        return con;
    }

    public void setCon(DBconnection con) {
        this.con = con;
    }
    
}
