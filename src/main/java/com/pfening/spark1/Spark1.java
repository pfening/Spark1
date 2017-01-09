package com.pfening.spark1;

import database.DataBean;
import database.DataDAO;
import database.Database;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;


/**
 *
 * @author PFENIGA1
 */
public class Spark1 {
        public static void main(String[] args) throws Exception {
        
        port(9090);
        staticFileLocation("/public");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Spark1.class, "/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
        
        
        DataDAO d=new DataDAO(); 

        get("/todo", (request, response) -> {
            response.type("text/html");                       
            Database.getInstance().SqliteConnect();
            Map<String, Object> attributes = new HashMap<>();                     
            attributes.put("tasks",d.readAll());               
            Database.getInstance().SqliteDisconnect();
            
        return freeMarkerEngine.render(new ModelAndView(attributes, "result.ftl"));
        });

    }
}
