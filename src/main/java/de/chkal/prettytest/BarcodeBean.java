package de.chkal.prettytest;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "barcode", viewId = "/META-INF/MANIFEST.MF",
    pattern = "/barcode/#{ /[0-9]+/ barcodeBean.value }.png")
public class BarcodeBean {
  
  private String value;

  @URLAction
  public void start() throws IOException
  {
    
    System.out.println("........");

    // prepare to send PNG data to
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletResponse response = 
      (HttpServletResponse) context.getExternalContext().getResponse();
    response.setContentType("image/png");

    // setup CanvasProvider for rendering to a bitmap 
    BitmapCanvasProvider canvas = new BitmapCanvasProvider(
        response.getOutputStream(), "image/png", 150, 
        BufferedImage.TYPE_BYTE_BINARY, false, 0);

    // build barcode bean and render it
    Interleaved2Of5Bean barcode = new Interleaved2Of5Bean();
    barcode.generateBarcode(canvas, value);

    // cleanup
    canvas.finish();
    context.responseComplete();

  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

}