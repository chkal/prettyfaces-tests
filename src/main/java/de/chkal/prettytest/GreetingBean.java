package de.chkal.prettytest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@Named
@RequestScoped
@URLMapping(id = "greeting", pattern = "/greeting/#{greetingBean.name}", viewId = "/greeting.jsf")
public class GreetingBean
{

    private final static Log log = LogFactory.getLog(GreetingBean.class);

    // gets initialized via URL pattern
    private String name;

    // Called on request for /other-page/*
    @URLAction
    public void showGreeting()
    {

        UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

        log.info("showGreeting() called from mapping: " + mapping.getId());

        log.info("Bean got name: " + name);

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