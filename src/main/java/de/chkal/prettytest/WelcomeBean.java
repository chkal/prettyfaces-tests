package de.chkal.prettytest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

@Named
@RequestScoped
@URLMapping(id = "emailImage", pattern = "/users/email/#{welcomeBean.username}.png", 
      viewId = "/greeting.jsf")
public class WelcomeBean
{

  private String username;

   @URLAction
   public void start() 
   {
      try
      {
      
         String email = "test@bla.org";
         byte[] imageData = createImage(150, 50, email);
         
         FacesContext context = FacesContext.getCurrentInstance();
         HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
      
         response.setContentType("image/png");
         response.getOutputStream().write(imageData);
         
         context.responseComplete();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      
      
   }
   
   public byte[] createImage(int width, int height, String s) {
      
      try {

         // create image to draw to
         BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
         Graphics2D graphics = image.createGraphics();
         graphics.setPaint(Color.LIGHT_GRAY);
         graphics.fillRect(0, 0, width, height);
         
         // write the text to the center of the image
         int stringWidth = graphics.getFontMetrics().stringWidth(s);
         int stringHeight = graphics.getFontMetrics().getAscent();
         graphics.setPaint(Color.black);
         graphics.rotate(0.08);
         graphics.drawString(s, (width - stringWidth) / 2, height / 2 + stringHeight / 4);
         
         // create PNG
         ByteArrayOutputStream buffer = new ByteArrayOutputStream();
         ImageIO.write(image, "png", buffer);
         return buffer.toByteArray();
         
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
 
      
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }


}