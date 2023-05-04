/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFCdiBeans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Vijay Rana
 */
@Named(value = "homeCdi")
@SessionScoped
public class homeCdi implements Serializable {

    /**
     * Creates a new instance of homeCdi
     */
    public homeCdi() {
    }

    String fname, lname;
    @Future
    Date date1;

    public String getFname() {
        fname = "Aayurshi";
        return fname;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        lname = "Rana";
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void goToAbout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("about.jsf");
        } catch (IOException ex) {
            Logger.getLogger(homeCdi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

}
