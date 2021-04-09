package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.ArrayList;
import java.util.Random;

public class Rectangle {
    public Vector2 a;
    public Vector2 b;
    public Vector2 c;
    public Vector2 d;

    public Vector2 p;

    public Rectangle(Vector2 a, Vector2 b, Vector2 p) {
        this.a = a;
        this.b = b;
        Line k = new Line(a.x, a.y, b.x, b.y);

        Point s = k.nearPoint(p);

        Vector2 l = new Vector2(s.x, s.y);
        Vector2 lp = p.minus(l);

        this.c = lp.plus(b);
        this.d = lp.plus(a);
        this.p = p;
    }

    public ArrayList<Vector2> intersection(Vector2 v, Vector2 v1) {
        ArrayList<Vector2> lst = new ArrayList<>();

        Line r = new Line(v.x, v.y, v1.x, v1.y);

        double x2 = (-r.C - r.B * a.y) / r.A;
        double x3 = (-r.C - r.B * c.y) / r.A;
        double y2 = (-r.C - r.A * a.x) / r.B;
        double y3 = (-r.C - r.A * c.x) / r.B;


        if (y3 >= a.y && y3 <= b.y || y3 >= b.y && y3 <= c.y || y3 >= c.y && y3 <= d.y || y3 >= d.y && y3 <= a.y)
            lst.add(new Vector2(a.x, y3));
        else if (y2 >= a.y && y2 <= b.y || y2 >= b.y && y2 <= c.y || y2 >= c.y && y2 <= d.y || y2 >= d.y && y2 <= a.y)
            lst.add(new Vector2(a.x, y2));
        else if (x3 >= a.x && x3 <= b.x || x3 >= b.x && x3 <= c.x || x3 >= c.x && x3 <= d.x || x3 >= d.x && x3 <= a.x)
            lst.add(new Vector2(x3, c.y));
        else if (x2 >= a.x && x2 <= b.x || x2 >= b.x && x2 <= c.x || x2 >= c.x && x2 <= d.x || x2 >= d.x && x2 <= a.x)
            lst.add(new Vector2(x2, a.y));

        if (x2 >= a.x && x2 <= b.x || x2 >= b.x && x2 <= c.x || x2 >= c.x && x2 <= d.x || x2 >= d.x && x2 <= a.x)
            lst.add(new Vector2(x2, a.y));
        else if (x3 >= a.x && x3 <= b.x || x3 >= b.x && x3 <= c.x || x3 >= c.x && x3 <= d.x || x3 >= d.x && x3 <= a.x)
            lst.add(new Vector2(x3, c.y));
        else if (y2 >= a.y && y2 <= b.y || y2 >= b.y && y2 <= c.y || y2 >= c.y && y2 <= d.y || y2 >= d.y && y2 <= a.y)
            lst.add(new Vector2(a.x, y2));
        else if (y3 >= a.y && y3 <= b.y || y3 >= b.y && y3 <= c.y || y3 >= c.y && y3 <= d.y || y3 >= d.y && y3 <= a.y)
            lst.add(new Vector2(a.x, y3));

        return lst;
    }


    public static Rectangle getRandomRectangle() {
        Random random = new Random();
        double x = random.nextDouble() * 2 - 1;
        double y = random.nextDouble() * 2 - 1;
        double x1 = random.nextDouble() * 2 - 1;
        double y1 = random.nextDouble() * 2 - 1;
        double x2 = random.nextDouble() * 2 - 1;
        double y2 = random.nextDouble() * 2 - 1;
        return new Rectangle(new Vector2(x, y), new Vector2(x1, y1), new Vector2(x2, y2));
    }

    public void render(GL2 gl) {
        Figures.renderQuads(gl, a, b, c, d, false);
    }
}