package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {
    
    private String selectedItem;

    public String getSelectedItem() {        
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;       
    }
    
    public void create(DataBean data) throws SQLException, Exception {		
        Connection conn = Database.getInstance().getSqliteConnection();		
        PreparedStatement p = conn.prepareStatement("insert into todo (task,startdate,duedate,urgency,finished) values (?,?,?,?,?)");	
        p.setString(1, data.getTask());
        p.setString(2, data.getStartdate());  
        p.setString(3, data.getDuedate());
        p.setString(4, data.getUrgency());
        p.setString(5, data.getFinished()); 
        p.executeUpdate();		
        p.close();		
    }

    public List<DataBean> readAll() throws SQLException, Exception {        
        List<DataBean> todolist = new ArrayList<>();        
        Connection conn = Database.getInstance().getSqliteConnection();
        PreparedStatement p = conn.prepareStatement("select * from todo");		
        ResultSet result = p.executeQuery();		
            while(result.next()) {
                DataBean entry = new DataBean();
                entry.setTask(result.getString("task"));
                entry.setStartdate(result.getString("startdate"));
                entry.setDuedate(result.getString("duedate"));
                entry.setUrgency(result.getString("urgency"));
                entry.setFinished(result.getString("finished"));
                todolist.add(entry);
            }		
            result.close();
            p.close();                
            return todolist;   
    }
 
    public DataBean readOne() throws SQLException, Exception{
        DataBean entry = null;
        Connection conn = Database.getInstance().getSqliteConnection();		
            PreparedStatement p = conn.prepareStatement("select * from todo where task=?");
            p.setString(1, selectedItem);		
            ResultSet result = p.executeQuery();		
            while(result.next()) {                
            String task = result.getString("task");
            String startdate = result.getString("startdate");
            String duedate = result.getString("duedate");
            String urgency = result.getString("urgency");
            String finished = result.getString("finished");
            entry = new DataBean(task,startdate,duedate,urgency,finished);
            }		
            result.close();
            p.close();                
            return entry;             
        }
    
    
    public void update(DataBean data) throws SQLException, Exception {		
        Connection conn = Database.getInstance().getSqliteConnection();		
        PreparedStatement p = conn.prepareStatement("update todo set startdate = ?,duedate = ?,urgency = ?,finished = ? where task ?");	
        p.setString(1, data.getStartdate());  
        p.setString(2, data.getDuedate());
        p.setString(3, data.getUrgency());
        p.setString(4, data.getFinished()); 
        p.setString(5, data.getTask());
        p.executeUpdate();		
        p.close();		
    }
        
        
    public void delete() throws SQLException, Exception {		
        Connection conn = Database.getInstance().getSqliteConnection();		
        PreparedStatement p = conn.prepareStatement("delete from todo where");		
        p.executeUpdate();		
        p.close();		
    }

}
