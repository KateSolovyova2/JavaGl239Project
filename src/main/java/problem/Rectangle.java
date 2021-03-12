package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Rectangle {
    public Vector2 a;
    public Vector2 b;
    public Vector2 c;
    public Vector2 d;

    public Rectangle(Vector2 a, Vector2 b, Vector2 p) {
        this.a = a;
        this.b = b;
        Line k = new Line(a.x, a.y, b.x, b.y);

        Point s = k.nearPoint(p);

        Vector2 l= new Vector2(s.x, s.y);
        Vector2 lp= p.minus(l);

        this.c = lp.plus(b);
        this.d = lp.plus(a);
    }
     public static Rectangle getRandomRectangle(){
        Random random = new Random();
        double x = random.nextDouble()*2-1;
                double y = random.nextDouble()*2-1;


     }
    public void render(GL2 gl) {
        Figures.renderQuads(gl, a, b, c, d, false);
    }
}