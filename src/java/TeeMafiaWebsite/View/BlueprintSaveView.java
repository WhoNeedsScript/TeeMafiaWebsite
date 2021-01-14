/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.View;

import TeeMafiaWebsite.Controller.BlueprintController;
import TeeMafiaWebsite.Database.DatabaseController;
import TeeMafiaWebsite.Entity.Part;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author magnu
 */
@ManagedBean(name = "BlueprintSaveView")
@SessionScoped

public class BlueprintSaveView {
    private List<String> dropDownPartname;
    private List<Part> parts;

    private String blueprintName;


    private String partName;
    private Integer partAmount;
   
    
    public String getBlueprintName() {
        return blueprintName;
    }

    public void setBlueprintName(String blueprintName) {
        this.blueprintName = blueprintName;
    }
    
    public List<Part> getParts() {
        return parts;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getPartAmount() {
        return partAmount;
    }

    public void setPartAmount(Integer partAmount) {
        this.partAmount = partAmount;
    }
    
    public List<String> getDropDownPartname() {
        return dropDownPartname;
    }
    
     @PostConstruct
    public void init()
    {
        dropDownPartname = DatabaseController.getWeaponRessourcesName();
    }
    
    public void addPart()
    {
        if(parts == null)
        {
             parts = new ArrayList<>();
        }
        
        Part part = new Part(partName,partAmount);
        parts.add(part);
    }
    
    public void deleteAllParts()
    {
        parts.clear();
    }
   
}
