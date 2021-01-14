/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.Entity;

import java.io.Serializable;

/**
 *
 * @author magnu
 */

public class Part implements Serializable{

    public Part(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }
    public String name;
    public Integer amount;

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String _Name) {
        this.name = _Name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer _Amount) {
        this.amount = _Amount;
    }
}
