package de.chkal.prettytest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@URLMapping(id = "welcome", pattern = "/welcome", viewId = "/welcome-page.jsf")
public class WelcomeBean
{
    private final static Log log = LogFactory.getLog(WelcomeBean.class);

    // Action called on GET request for /welcome
    @URLAction(onPostback = false)
    public void start()
    {
        UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();

        log.info("start() method called by mapping: " + mapping.getId());

    }

}