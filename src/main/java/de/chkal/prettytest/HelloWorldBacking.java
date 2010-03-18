package de.chkal.prettytest;

import com.ocpsoft.pretty.annotation.PrettyAction;
import com.ocpsoft.pretty.annotation.PrettyMapping;
import com.ocpsoft.pretty.annotation.PrettyQueryParam;

@PrettyMapping(id = "helloWorld", pattern = "/go", viewId = "/helloWorld.jsf")
public class HelloWorldBacking
{

    @PrettyQueryParam(value = "name")
    private String name;

    @PrettyAction
    public void start()
    {
        System.out.println("----------------------");
    }

    /**
     * default empty constructor
     */
    public HelloWorldBacking()
    {}

    // -------------------getter & setter
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Method that is backed to a submit button of a form.
     */
    public String send()
    {
        // do real logic
        return ("success");
    }
}