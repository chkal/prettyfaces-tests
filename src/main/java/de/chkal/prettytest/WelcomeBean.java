package de.chkal.prettytest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLQueryParameter;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

// Define the mapping
@URLMapping(id = "welcome", pattern = "/welcome", viewId = "/welcome-page.jsf")
// optional @PrettyBean annotation! Could be removed!
//@PrettyBean("welcomeBean")
public class WelcomeBean
{
    private final static Log log = LogFactory.getLog(WelcomeBean.class);

    // Query parameter my be used to initialize this value
    @URLQueryParameter(value = "name")
    private String name;

    // Query parameter my be used to initialize this value
    @URLQueryParameter(value = "other")
    private String other;
    
    public String getOther() {
      return other;
    }

    public void setOther(String other) {
      this.other = other;
    }

    // Action called on GET request for /welcome
    @URLAction(onPostback = false)
    public void start()
    {
        UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

        log.info("start() method called by mapping: " + mapping.getId());

        log.info("Name inputText was initialized with: " + name);
        log.info("Other inputText was initialized with: " + other);
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