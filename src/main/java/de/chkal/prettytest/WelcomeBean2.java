package de.chkal.prettytest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import com.ocpsoft.pretty.PrettyContext;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.config.mapping.UrlMapping;

@ManagedBean(name="welcomeBean3")
@RequestScoped
public class WelcomeBean2 {

  private final static Logger log = Logger.getLogger(WelcomeBean2.class);

  // A foreign action. It references the mapping in WelcomeBean
  @URLAction(mappingId = "welcome", onPostback = false)
  public void otherAction() {
    
    UrlMapping mapping = PrettyContext.getCurrentInstance().getCurrentMapping();
    
    log.info("otherAction() called from mapping: "+mapping.getId());
    
  }

}