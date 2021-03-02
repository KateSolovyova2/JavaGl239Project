

package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Figures {

    public static void renderPoint(GL2 gl, Vector2 pos, float size) {
        gl.glColor3d(1,1,0);
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 posa, Vector2 posb, float width) {
        gl.glColor3d(0.3,0,0.2);
        gl.glLineWidth(width);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(posa.x, posa.y);
        gl.glVertex2d(posb.x, posb.y);
        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, Vector2 posa, Vector2 posb, Vector2 posc, boolean filled) {
        gl.glColor3d(0.5,1,0);
        if(filled == true) {
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glVertex2d(posa.x, posa.y);
            gl.glVertex2d(posb.x, posb.y);
            gl.glVertex2d(posc.x, posc.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posa.x, posa.y);
            gl.glVertex2d(posb.x, posb.y);
            gl.glEnd();
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posb.x, posb.y);
            gl.glVertex2d(posc.x, posc.y);
            gl.glEnd();
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posc.x, posc.y);
            gl.glVertex2d(posa.x, posa.y);
            gl.glEnd();
        }
    }

    public static void renderQuads(GL2 gl, Vector2 posa, Vector2 posb, Vector2 posc, Vector2 posd, boolean filled) {
        gl.glColor3d(0,1,0.3);
        if (filled == true) {
            gl.glBegin(GL2GL3.GL_QUADS);
            gl.glVertex2d(posa.x, posa.y);
            gl.glVertex2d(posb.x, posb.y);
            gl.glVertex2d(posc.x, posc.y);
            gl.glVertex2d(posd.x, posd.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posa.x, posa.y);
            gl.glVertex2d(posb.x, posb.y);
            gl.glEnd();
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posb.x, posb.y);
            gl.glVertex2d(posc.x, posc.y);
            gl.glEnd();
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posc.x, posc.y);
            gl.glVertex2d(posd.x, posd.y);
            gl.glEnd();
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(posd.x, posd.y);
            gl.glVertex2d(posa.x, posa.y);
            gl.glEnd();
        }
    }

    public static void renderCircle(GL2 gl, Vector2 posa, double rad, boolean filled) {
        int n = 360;
        gl.glColor3d(1,0,1);
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glVertex2d(posa.x, posa.y);
        for (int i = 0; i <= n; i++) {
           double angle = (2 * Math.PI) / n * i;
            double  x = rad * Math.cos(angle)+posa.x;
            double  y = rad * Math.sin(angle)+posa.y;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();


    }
}
