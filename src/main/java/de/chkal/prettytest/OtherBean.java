package de.chkal.prettytest;

import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.annotation.PrettyBean;

@PrettyBean("helloWorld")
public class OtherBean
{

    @PrettyAction(mappingId = "helloWorld")
    public void goForIt()
    {
        System.out.println("---=====---CLICK-------------");
    }

}