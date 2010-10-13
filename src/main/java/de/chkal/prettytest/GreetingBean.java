package de.chkal.prettytest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "greeting", 
      pattern = "/greeting/#{greetingBean.name}", 
      viewId = "/greeting.jsf"
)
public class GreetingBean
{

    private final static Log log = LogFactory.getLog(GreetingBean.class);

    @Pattern(regexp = "[a-z]{4}")
    private String name;

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}