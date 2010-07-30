package de.chkal.prettytest;

import java.util.Enumeration;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLQueryParameter;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@Named
@RequestScoped
@URLMapping(id = "welcome", pattern = "/welcome", viewId = "/welcome-page.jsf")
public class WelcomeBean
{
    private final static Log log = LogFactory.getLog(WelcomeBean.class);

    // Query parameter my be used to initialize this value
    @URLQueryParameter(value = "name")
    private String name;

    @SuppressWarnings("unchecked")
    @URLAction
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
    @URLAction(onPostback = false)
    public void start()
    {
        UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

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