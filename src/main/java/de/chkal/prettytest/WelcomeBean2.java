package de.chkal.prettytest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.PrettyAction;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

// No annotations here
public class WelcomeBean2 {

  private final static Log log = LogFactory.getLog(WelcomeBean2.class);

  // A foreign action. It references the mapping in WelcomeBean
  @PrettyAction(mappingId = "welcome", onPostback = false)
  public void otherAction() {
    
    UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();
    
    log.info("otherAction() called from mapping: "+mapping.getId());
    
  }

}