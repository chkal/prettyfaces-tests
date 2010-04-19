package de.chkal.prettytest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.config.PrettyUrlMapping;

@Component
@Scope("request")
public class WelcomeBean2 {

  private final static Log log = LogFactory.getLog(WelcomeBean2.class);

  // A foreign action. It references the mapping in WelcomeBean
  @PrettyAction(mappingId = "welcome", onPostback = false)
  public void otherAction() {
    
    PrettyUrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();
    
    log.info("otherAction() called from mapping: "+mapping.getId());
    
  }

}