import java.applet.Applet;
import java.awt.*;

public class HelloWorldApplet extends Applet {
   private static final long serialVersionUID = 1L;

   public void paint(Graphics g) {
      g.drawString("hello world", 80, 100);

   }
}