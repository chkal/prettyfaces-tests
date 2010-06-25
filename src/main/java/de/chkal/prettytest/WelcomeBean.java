package de.chkal.prettytest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLQueryParameter;
import com.ocpsoft.pretty.faces.annotation.URLValidator;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "welcome", pattern = "/welcome", viewId = "/welcome-page.jsf")
public class WelcomeBean
{
    private final static Log log = LogFactory.getLog(WelcomeBean.class);

    // Query parameter my be used to initialize this value
    @URLQueryParameter(value = "name")
    @URLValidator(validatorIds="myValidator")
    private String name;

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