package de.chkal.prettytest;

import java.util.Enumeration;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.annotation.PrettyBean;
import com.ocpsoft.pretty.annotation.PrettyMapping;
import com.ocpsoft.pretty.annotation.PrettyQueryParam;
import com.ocpsoft.pretty.config.PrettyUrlMapping;

@Named
@RequestScoped
@PrettyBean("welcomeBean")
@PrettyMapping(id = "welcome", pattern = "/welcome", viewId = "/welcome-page.jsf")
public class WelcomeBean
{
    private final static Log log = LogFactory.getLog(WelcomeBean.class);

    // Query parameter my be used to initialize this value
    @PrettyQueryParam(value = "name")
    private String name;

    @SuppressWarnings("unchecked")
    @PrettyAction
    public void debugServletContext() {
        
        log.info("----------------------");
        
        ServletContext sc = 
            (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        Enumeration<String> enums = sc.getAttributeNames();
        while (enums.hasMoreElements())
        {
            String key = enums.nextElement();
            System.out.println("---> "+key+" = "+sc.getAttribute(key));
        }
        
        log.info("----------------------");
        
    }
    
    // Action called on GET request for /welcome
    @PrettyAction(onPostback = false)
    public void start()
    {
        PrettyUrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

        log.info("start() method called by mapping: " + mapping.getId());

        if (name != null)
        {
            log.info("Name inputText was initialized with: " + name);
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}