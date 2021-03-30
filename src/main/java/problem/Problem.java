package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static problem.Rectangle.getRandomRectangle;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "На плоскости задано множество точек, и прямоугольник. Множество точек образует\n" +
            "все возможные прямые, которые могут быть построены парами точек множества.\n" +
            "Найти такую прямую (и такие две точки, через которые она проходит), что эта прямая\n" +
            "пересекает указанный прямоугольник, и при этом длина отрезка прямой,\n находящейся внутри прямоугольника, максимальна.\n" +
            "В качестве ответа: выделить найденные две точки";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private Rectangle rectangle;
    Point pointA;
    Point pointB;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x        координата X точки
     * @param y        координата Y точки
     * @param //setVal номер множества
     */
    public void addPoint(double x, double y) {

        Point point = new Point(x, y);
        points.add(point);
    }

    /**
     * Добавить точку
     *
     * @param x        координата X точки
     * @param y        координата Y точки
     * @param //setVal номер множества
     */
    public void setRectangle(double x, double y, double x2, double y2, double x3, double y3) {
        rectangle = new Rectangle(new Vector2(x, y), new Vector2(x2, y2), new Vector2(x3, y3));
    }

    /**
     * Решить задачу
     */
    public void solve() {
        Vector2 v1, v2;
        // перебираем пары точек
        double length = 0;
        double maxlength = 0;
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    //if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
                    // p.isSolution = true;
                    //p2.isSolution = true;
                    Vector2 n = new Vector2(rectangle.point1(new Vector2(p.x, p.y), new Vector2(p2.x, p2.y)));
                    Vector2 c = new Vector2(rectangle.point2(new Vector2(p.x, p.y), new Vector2(p2.x, p2.y)));
                    if (n == c) {
                        length = 0;
                    } else {
                        length = Math.sqrt((n.x - c.x) * (n.x - c.x) + (n.y - c.y) * (n.y - c.y));
                        if (length >= maxlength) {
                            maxlength = length;
                            pointA = new Point(p.x, p.y);
                            pointB = new Point(p2.x, p2.y);
                        }
                    }
                }
            }
        }
    }



    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            rectangle = new Rectangle(new Vector2(x1, y1), new Vector2(x2, y2), new Vector2(x3, y3));
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            out.printf("%.2f %.2f %.2f %.2f %.2f %.2f\n", rectangle.a.x, rectangle.a.y, rectangle.b.x, rectangle.b.y, rectangle.p.x, rectangle.p.y);
            for (Point point : points) {
                out.printf("%.2f %.2f\n", point.x, point.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }


    public void setRandomRectangles() {
        rectangle = Rectangle.getRandomRectangle();
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        rectangle = null;
        pointA = null;
        pointB = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        gl.glColor3d(0, 1, 0);
        if (rectangle != null)
            rectangle.render(gl);
        for (Point p : points)
            p.render(gl);
        gl.glColor3d(1,0,0);
        if(pointA!=null){
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2d(pointA.x,pointA.y);
            gl.glEnd();
        }
        gl.glColor3d(0, 1, 0);
        if(pointB!=null){
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2d(pointB.x,pointB.y);
            gl.glEnd();
        }
    }


}
