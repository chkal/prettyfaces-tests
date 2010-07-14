package de.chkal.prettytest;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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
    @URLQueryParameter("name")
    @URLValidator(validator="#{welcomeBean.validateName}")
    private String name;

    
    public void validateName(FacesContext arg0, UIComponent arg1, Object arg2) 
    {
       
       for(String country : Locale.getISOLanguages()) {
          if(country.equals( value.toString() )) {
             return;
          }
       }
       throw new ValidatorException( new FacesMessage("failed") )
       
       System.out.println("---Validating---");
       System.out.println("---Validating---");
       System.out.println("---Validating---");
       System.out.println("---Validating---");
       System.out.println("---Validating---");
       if(arg2.toString().length() < 3) {
          throw new ValidatorException( new FacesMessage("Not allowed"));
       }
       
    }
    
    // Action called on GET request for /welcome
    @URLAction(onPostback = false)
    public void start()
    {
       System.out.println("-----====------");
       
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