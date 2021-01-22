/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeeMafiaWebsite.Database;

import TeeMafiaWebsite.Entity.Blueprint;
import TeeMafiaWebsite.Entity.Part;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.faces.context.FacesContext;
import java.util.List;
/**
 *
 * @author magnu
 */
public class DatabaseController 
{
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/TeeMafia";
    static String username = "root";
    static String password = "";
    
    public static Connection getConnection() 
    {
        try
        {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return connection;
        }
        catch(Exception ex)
        {
            System.out.println(ex);  
        }
        
        return null;
    }
    
    public static boolean getUserID(String _Username,String _Password)
    {
        try
        {
            String sql = "select id,rank from tblUser where username = ? and password = ?";
            
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, _Username);
            pst.setString(2, _Password);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs == null)
            {
                return false;
            }
            
            while(rs.next())
            {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("id", rs.getInt(1));
                System.out.println(rs.getInt(1));  
                context.getExternalContext().getSessionMap().put("username", _Username);
                context.getExternalContext().getSessionMap().put("rank", rs.getInt(2));
                rs.close();
                return true;
            }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);  
        }
        
        return false;
    }
    
    public static List<String> getWeaponRessourcesName()
    {
        List<String> name = new ArrayList<String>();
        try
        {
            
            String sql = "select name from tblweaponparts";
            
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs == null)
            {
                return name;
            }
            
            while(rs.next())
            {
                System.out.println(rs.getString(1));
                name.add(rs.getString(1));               
            }
            rs.close();
            return name;
        }
        catch(Exception ex)
        {
            System.out.println(ex);  
            return name;
        }
        
       
    }
    
    public static List<Blueprint> getAllBlueprints()
    {
        List<Blueprint> blueprints = new ArrayList<Blueprint>();
        
        try
        {
            String sql = "select tblblueprint.name,tblweaponparts.name,tblblueprintpart.amount "
                    +    "from tblblueprintpart "
                    +    "inner join tblblueprint ON tblblueprint.id = tblblueprintpart.BlueprintID "
                    +    "inner JOIN tblweaponparts on tblweaponparts.id = tblblueprintpart.id";
            
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            List<Part> parts = new ArrayList<Part>();
            Blueprint temp = new Blueprint("",parts);
           
            Part tempPart;
                    
            while(rs.next())
            {
                if(temp.getName() == "")
                {
                  temp.setName(rs.getString(1));
                }   
                else if(temp.getName() != rs.getString(1) && temp.getName() != "")
                {   
                    blueprints.add(temp);
                    parts = new ArrayList<Part>();
                    temp = new Blueprint(rs.getString(1), parts);                   
                }
                
                tempPart = new Part(rs.getString(2), rs.getInt(3));
                parts.add(tempPart);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);  
           
        }
         return blueprints;
    }
    
    public static void saveBlueprint(Blueprint _Bluprint)
    {
        String[] returnID = {"id"};
        int BlueprintId = - 1;
      
        String sql = "insert into tblblueprint(name) Values(?)";
        
        try
        {
                
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            
            PreparedStatement pst = connection.prepareStatement(sql,returnID);
            pst.setString(1, _Bluprint.getName());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) 
            {
                BlueprintId = rs.getInt(1);
            }
            rs.close();
               
            if(BlueprintId == -1)
            {
                return;
            }
            
            for(Part part : _Bluprint.getParts())
            {
                sql = "insert into tblBlueprintpart(BlueprintID,WeaponpartId,Amount) values (?,(Select id from tblweaponparts where Name = ?),?)";
                  
                pst = connection.prepareStatement(sql);
                pst.setInt(1, BlueprintId);
                pst.setString(2, part.getName());
                pst.setInt(3, part.getAmount());
      
                pst.executeUpdate();
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);  
            return;
        }
    }
    
    public static void deleteBlueprint(String _Name)
    {
        try
        {
            String sql = "delete  tblblueprint,tblblueprintpart"
                    +    "from tblblueprintpart"
                    +    "inner join tblblueprint ON tblblueprint.id = tblblueprintpart.BlueprintID "
                    +    "where tblblueprint.name = ?";
            
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
             
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, _Name);
            pst.execute();
        }
        catch(Exception ex)
        {
            System.out.println(ex);  
           
        }
      
    }
}
