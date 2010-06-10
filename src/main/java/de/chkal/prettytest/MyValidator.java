package de.chkal.prettytest;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MyValidator implements Validator
{

   @Override
   public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException
   {
      if(arg2.toString().length() < 3) {
         throw new ValidatorException( new FacesMessage("Not allowed"));
      }
      
   }

}
