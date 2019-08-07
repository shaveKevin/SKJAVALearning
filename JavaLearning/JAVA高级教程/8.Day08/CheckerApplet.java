import java.applet.Applet;

public class CheckerApplet extends Applet {
   int squareSize = 50;

   public void init() {
      String squareSizeParam = getParameter("squareSize");
      parseSquareSize(squareSizeParam);
      String colorParam = getParameter("color");
      Color fg = parseColor(colorParam);
      setBackground(Color.black);
      setForeground(fg);
   }

   private void parseSquareSize(String param) {
      if (param == null)
         return;
      try {
         squareSize = Integer.parseInt(param);
      } catch (Exception e) {
         // 保留默认值
      }
   }

   private Color parseColor(String param) {
   }

   public void paint(Graphics g) {
   }

}
