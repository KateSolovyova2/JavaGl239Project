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

    public ArrayList<Vector2> intersection2(Vector2 v, Vector2 v1) {
        ArrayList<Vector2> lst = new ArrayList<>();

        Line l = new Line(v.x, v.y, v1.x, v1.y);



        Line l1 = new Line(a.x,a.y,b.x,b.y);
        Vector2 pp1 = new Vector2(l1.intersection(l));
        if(pp1!=null && ((pp1.x>=a.x && pp1.x<=b.x) || (pp1.x>=b.x && pp1.x<=a.x) && (pp1.y>=a.y && pp1.y<=b.y) || (pp1.y>=b.y && pp1.y<=a.y))) {
            lst.add(new Vector2(pp1.x, pp1.y));
        }

        Line l2 = new Line(b.x,b.y,c.x,c.y);
        Vector2 pp2 = new Vector2(l2.intersection(l));
        if(pp1!=null && ((pp2.x>=c.x && pp2.x<=b.x) || (pp2.x>=b.x && pp2.x<=c.x) && (pp2.y>=c.y && pp2.y<=b.y) || (pp2.y>=b.y && pp2.y<=c.y))) {
            lst.add(new Vector2(pp2.x, pp2.y));
        }
        Line l3 = new Line(d.x,d.y,c.x,c.y);
        Vector2 pp3 = new Vector2(l3.intersection(l));
        if(pp1!=null && ((pp3.x>=c.x && pp3.x<=d.x) || (pp3.x>=d.x && pp3.x<=c.x) && (pp3.y>=c.y && pp3.y<=d.y) || (pp3.y>=d.y && pp3.y<=c.y))) {
            lst.add(new Vector2(pp3.x, pp3.y));
        }

        Line l4 = new Line(d.x,d.y,a.x,a.y);
        Vector2 pp4 = new Vector2(l4.intersection(l));
        if(pp1!=null && ((pp3.x>=a.x && pp3.x<=d.x) || (pp3.x>=d.x && pp3.x<=a.x) && (pp3.y>=a.y && pp3.y<=d.y) || (pp3.y>=d.y && pp3.y<=a.y))) {
            lst.add(new Vector2(pp4.x, pp4.y));
        }

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