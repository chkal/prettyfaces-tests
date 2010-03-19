package de.chkal.prettytest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.annotation.PrettyMapping;

// mapping for /other-page/*
@PrettyMapping(id = "someOtherBean", pattern = "/other-page/#{someOtherBean.name}", 
        viewId = "/some-other-page.jsf")
//@PrettyBean("someOtherBean") // Optional! We get the real bean name from faces-config.xml
public class SomeOtherBean
{

    private final static Log log = LogFactory.getLog(SomeOtherBean.class);

    // gets initialized via URL pattern
    private String name;

    // Called on request for /other-page/*
    @PrettyAction
    public void someAction()
    {
        log.info("someAction() called from mapping: " + 
                PrettyContext.getCurrentInstance().getCurrentMapping().getId());
        log.info("Bean got name: "+name);
    }

    // A foreign action. It references the mapping in WelcomeBean
    @PrettyAction(mappingId = "welcome", onPostback=false)
    public void otherActionForWelcomeMapping()
    {
        log.info("otherActionForWelcomeMapping() called from mapping: " + 
                PrettyContext.getCurrentInstance().getCurrentMapping().getId());
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