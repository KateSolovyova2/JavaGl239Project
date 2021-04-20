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

    public static Vector2 isInQuad(Line l, Vector2 a, Vector2 b) {
        Line l1 = new Line(a.x, a.y, b.x, b.y);
        Vector2 p = l1.intersection(l);
        if (p == null)
            return null;
        Vector2 min = new Vector2(Math.min(a.x, b.x), Math.min(a.y, b.y));
        Vector2 max = new Vector2(Math.max(a.x, b.x), Math.max(a.y, b.y));
        if (p.x >= min.x && p.y >= min.y && p.x <= max.x && p.y <= max.y)
            return p;
        else
            return null;
    }

    public ArrayList<Vector2> intersection2(Vector2 v, Vector2 v1) {
        ArrayList<Vector2> lst = new ArrayList<>();

        Line l = new Line(v.x, v.y, v1.x, v1.y);

        Vector2 intersectionPoint = isInQuad(l, a, b);
        if (intersectionPoint != null)
            lst.add(intersectionPoint);

        intersectionPoint = isInQuad(l, b, c);
        if (intersectionPoint != null)
            lst.add(intersectionPoint);

        intersectionPoint = isInQuad(l, c, d);
        if (intersectionPoint != null)
            lst.add(intersectionPoint);

        intersectionPoint = isInQuad(l, d, a);
        if (intersectionPoint != null)
            lst.add(intersectionPoint);

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