/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.Controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import TeeMafiaWebsite.Database.DatabaseController;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.PrimeFacesContext;
/**
 *
 * @author Magnus Koch
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable
{
    private String username;   
    private String password;
    private Integer id;
    
    public void LoginController()
    {
       try
       {
            if(DatabaseController.getUserID(username, password) == true)
            {
                FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
}
