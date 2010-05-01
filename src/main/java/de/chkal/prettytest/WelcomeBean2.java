package de.chkal.prettytest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.config.PrettyUrlMapping;

@ManagedBean
@RequestScoped
public class WelcomeBean2 {

  private final static Log log = LogFactory.getLog(WelcomeBean2.class);

  // A foreign action. It references the mapping in WelcomeBean
  @PrettyAction(mappingId = "welcome", onPostback = false)
  public void otherAction() {
    
    PrettyUrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();
    
    log.info("otherAction() called from mapping: "+mapping.getId());
    
  }

}