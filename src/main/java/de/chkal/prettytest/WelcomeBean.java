package de.chkal.prettytest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.PrettyAction;
import com.ocpsoft.pretty.faces.annotation.PrettyMapping;
import com.ocpsoft.pretty.faces.annotation.PrettyQueryParam;
import com.ocpsoft.pretty.faces.annotation.PrettyValidation;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@ManagedBean
@RequestScoped
@PrettyMapping(id = "welcome", pattern = "/welcome", viewId = "/welcome-page.jsf")
public class WelcomeBean
{
    private final static Log log = LogFactory.getLog(WelcomeBean.class);

    // Query parameter my be used to initialize this value
    @PrettyQueryParam(value = "name")
    @PrettyValidation(validatorIds="myValidator")
    private String name;

    // Action called on GET request for /welcome
    @PrettyAction(onPostback = false)
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