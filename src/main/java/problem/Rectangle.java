package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Rectangle {
    public Vector2 a;
    public Vector2 b;
    public Vector2 c;
    public Vector2 d;

    public Rectangle(Vector2 n, Vector2 n1, Vector2 n2) {
        this.a = n;
        this.b = n1;
        Line k = new Line(n.x, n.y, n1.x, n1.y);
        Point s = k.nearPoint(n2);
        this.c = new Vector2(n2.x - s.x + b.x, n2.y - s.y + b.y);
        this.d = new Vector2(n2.x + s.x - a.x, n2.x + s.x + a.x);
    }

    public void render(GL2 gl) {
        Figures.renderQuads(gl, a, b, c, d, false);
    }
}