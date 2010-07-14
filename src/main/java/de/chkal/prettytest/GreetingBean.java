package de.chkal.prettytest;

import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLValidator;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "greeting", 
      pattern = "/greeting/#{greetingBean.name}", 
      viewId = "/greeting.jsf", 
      validation={ 
         @URLValidator(index=0, validator="#{welcomeBean.validateName}")
      }
)
public class GreetingBean
{

    private final static Log log = LogFactory.getLog(GreetingBean.class);

    // gets initialized via URL pattern
    private Pattern name;

    // Called on request for /other-page/*
    @URLAction
    public void showGreeting()
    {

        UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

        log.info("showGreeting() called from mapping: " + mapping.getId());

        log.info("Bean got name: " + name);
        
        if(name.equals("test")) {
           throw new IllegalStateException("Expected exception!");
        }

    }

    public Pattern getName()
    {
        return name;
    }

    public void setName(Pattern name)
    {
        this.name = name;
    }

}