package de.chkal.prettytest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.annotation.PrettyMapping;
import com.ocpsoft.pretty.config.PrettyUrlMapping;

// mapping for "/greeting/*"
@PrettyMapping(id = "greeting", pattern = "/greeting/#{greetingBean.name}", viewId = "/greeting.jsf")
// Removed! We get it from faces-config.xml
// @PrettyBean("greetingBean")
public class GreetingBean
{

    private final static Log log = LogFactory.getLog(GreetingBean.class);

    // gets initialized via URL pattern
    private String name;

    // Called on request for /other-page/*
    @PrettyAction
    public void showGreeting()
    {

        PrettyUrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

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