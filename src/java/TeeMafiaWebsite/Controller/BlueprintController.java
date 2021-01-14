/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.Controller;

import TeeMafiaWebsite.Database.DatabaseController;
import TeeMafiaWebsite.Entity.Blueprint;
import TeeMafiaWebsite.Entity.Part;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author magnu
 */
@ManagedBean(name = "BlueprintsController")
@SessionScoped
public  class BlueprintController  implements Serializable{
  
    public static void delete(String _BlueprintName)
    {
        DatabaseController.deleteBlueprint(_BlueprintName);
    }

    
    public static void saveBlueprint(String _BlueprintName,List<Part> _Parts)
    {
        Blueprint blueprint = new Blueprint(_BlueprintName, _Parts);
        DatabaseController.saveBlueprint(blueprint); 
    }
}
