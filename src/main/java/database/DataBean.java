package database;

public class DataBean {
    private String task;
    private String startdate;  
    private String duedate;
    private String urgency;
    private String finished;  


    public DataBean(){
    
    }

    public DataBean(String task,String startdate,String duedate,String urgency,String finished) {
        this.task = task;
        this.startdate = startdate;
        this.duedate = duedate;  
        this.urgency = urgency;
        this.finished = finished;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }


}