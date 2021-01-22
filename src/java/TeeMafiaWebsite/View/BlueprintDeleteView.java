/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.View;

import TeeMafiaWebsite.Controller.BlueprintController;
import TeeMafiaWebsite.Database.DatabaseController;
import TeeMafiaWebsite.Entity.Blueprint;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author magnu
 */
@ManagedBean(name = "BlueprintDeleteView")
@SessionScoped

public class BlueprintDeleteView 
{
    List<Blueprint> listBlueprints;

    public List<Blueprint> getListBlueprints() {
        return listBlueprints;
    }

    public void setListBlueprints(List<Blueprint> listBlueprints) {
        this.listBlueprints = listBlueprints;
    }

    public Blueprint getSelectedBlueprint() {
        return selectedBlueprint;
    }

    public void setSelectedBlueprint(Blueprint selectedBlueprint) {
        this.selectedBlueprint = selectedBlueprint;
    }
    Blueprint selectedBlueprint;
    
    @PostConstruct
    public void init()
    {
        listBlueprints = DatabaseController.getAllBlueprints();
    }
    
    public void deleteSelectedBlueprint()
    {
        listBlueprints.remove(selectedBlueprint);
    }

    
}
