package de.chkal.prettytest;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLQueryParameter;

@Named
@RequestScoped
@URLMapping(id = "qrCode", pattern = "/qr", viewId = "/greeting.jsf")
public class CodeBean
{
   @URLQueryParameter("t")
   private String text;

   @URLAction
   public void start()  
   {
      try {


         FacesContext context = FacesContext.getCurrentInstance();
         HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
         response.setContentType("image/png");

         BitmapCanvasProvider canvas = new BitmapCanvasProvider(
               response.getOutputStream(), "image/png", 300, 
               BufferedImage.TYPE_BYTE_BINARY, false, 0);

         DataMatrixBean dmb = new DataMatrixBean();
         dmb.generateBarcode(canvas, text);
         
         canvas.finish();
         context.responseComplete();
         
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      
   }

   public String getText()
   {
      return text;
   }

   public void setText(String text)
   {
      this.text = text;
   }

}