/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.Entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author magnu
 */
public class Blueprint  implements Serializable {

    private String name;
    private List<Part> parts;
    
    public Blueprint(String name, List<Part> parts) {
        this.name = name;
        this.parts = parts;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
    
}
