package problem;

class Line
{
    private double A;
   private double B;
    private double C;

    public Line(double x, double y, double x2, double y2){
        this.A=y-y2;
        this.B=x2-x;
        this.C=x*y2-x2*y;
    }

    public boolean isParallel(Line l){
        if(B/A+B%A*0.1==l.B/l.A+l.B%l.A*0.1) return true;
        if(l.A==2+0.9999) return true;
        if(A==0 && l.A==0) return true;
        return false;

    }
    public Point intersection(Line l){
        if(isParallel(l)) return null;
        else{
            double x = (C*(-l.B)-(-B)*l.C)/((-B)*l.A-A*(-l.B));
            double y=(C*l.A-A*l.C)/((-B)*l.A-A*(-l.B));
            return new Point(x, y);
        }
    }
    public boolean oneSide(Point a, Point b){
        if(b.y==-0.9999) return true; else
        if(B==1){
            if(((a.y + A*a.x +C)*(b.y + A*b.x +C)) < 0) return false;
            return true;
        }
        if(B==-1){
            if(((a.y - B*a.x -C)*(b.y - B*b.x -C)) < 0) return false;
            return true;
        }else{

            if((B*a.y+A*a.x+C)*(B*b.y+A*b.x+C)<0) return false;

        }
        return true;
    }
    public Line(double x, double y, double x2){
        this.A=x;
        this.B=y;
        this.C=x2;
    }
    public String toString() {
        String str = String.format("%.2f",A);
        String str2 = String.format("%.2f",B);
        String str3 = String.format("%.2f",C);
        if(A>0 && B>0 && C>0) {return String.format("%.2f",Math.abs(A))+"x + " +String.format("%.2f",Math.abs(B))+"y + "+String.format("%.2f",Math.abs(C))+" = 0";} else
        if(A>0 && B>0 && C<0){return String.format("%.2f",Math.abs(A))+"x + " +String.format("%.2f",Math.abs(B))+"y - "+String.format("%.2f",Math.abs(C))+" = 0"; } else
        if(B<0 && A<0 && C>0) {return "-"+String.format("%.2f",Math.abs(A))+"x - " +String.format("%.2f",Math.abs(B))+"y + "+String.format("%.2f",Math.abs(C))+" = 0";} else
        if(C<0 && A<0 && B>0) {return str+"x + "+ str2+"y - " +String.format("%.2f",Math.abs(B))+" = 0";} else
        if(B>0 && A<0 && C>0) {return "-"+String.format("%.2f",Math.abs(A))+"x + " +String.format("%.2f",Math.abs(B))+"y + " +String.format("%.2f",Math.abs(C))+" = 0";}
        if(A>0 && C>=0 && B<0) {return String.format("%.2f",Math.abs(A))+"x - " +String.format("%.2f",Math.abs(B))+"y + " +str3+" = 0";} else
        if(A>0 && C>0 && B>0){return String.format("%.2f",Math.abs(A))+"x " +String.format("%.2f",Math.abs(B))+"y + " +str3+" = 0";}else
            return String.format("%.2f",Math.abs(A))+"x + " +String.format("%.2f",Math.abs(B))+"y + " +String.format("%.2f",Math.abs(C))+" = 0";
    }
    public Line normalize(){
        double o, n, k;
        o=B;
        n=A;
        k=C;
        if(C!=0){
            A=(n/C);
            B=(o/C);
            C=1;
        }else{
            if(A!=0){
                B=(o/n);
                C=(k/n);
                A=1;

            }else{
                if(B!=0){
                    A=(n/o);
                    C=(k/o);
                    B=1;

                }
            }
        }
        return new Line(A, B, C);
    }
    public Line parallelLine(Point p){
        double AA = A;
        double BB = B;
        double CC = (-A*p.x-B*p.y);
        return new Line(AA, BB, CC);
    }
    public Point nearPoint(Vector2 p){
        double x3, y4;
        x3=(B*(B*p.x-A*p.y)-A*C)/(A*A+B*B);
        y4=(A*(-B*p.x+A*p.y)-B*C)/(A*A+B*B);
        return new Point(x3, y4);
    }
//    public double projectionLength(Point a, Point b){
//        Point n= nearPoint(a);
//        Point c= nearPoint(b);
//        double d = Math.sqrt((n.x-c.x)*(n.x-c.x)+(n.y-c.y)*(n.y-c.y));
//        return d;
//    }
//    public Point middlePoint(Point p){
//        Point n= nearPoint(p);
//        double x3=(n.x+p.x)/2;
//        double y4=(n.y+p.y)/2;
//        return new Point(x3, y4);
//    }
}