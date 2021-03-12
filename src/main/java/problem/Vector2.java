package problem;

class Vector2
{
    public double x;
    public double y;

    public Vector2(){
        x=1;
        y=0;
    }
    public String toString() {
        String str = String.format("%.2f",x);
        String str2 = String.format("%.2f",y);
        return "(" +str+ ","+ str2+")";
    }
    public Vector2(double x, double y){
        this.x=x;
        this.y=y;
    }
    public Vector2(Vector2 v){
        this.x=v.x;
        this.y=v.y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public double len(){
        return Math.sqrt(x*x+y*y);
    }
    public Vector2 x(double k){
        x=x*k;
        y=y*k;
        return new Vector2(x,y);
    }
    public Vector2 plus(Vector2 v){
        return new Vector2(v.x+x,v.y+y);
    }
    public Vector2 minus(Vector2 v){
        return new Vector2(x-v.x,y-v.y);
    }
    public Vector2 sum(Vector2 v){
        double m=v.x+x;
        double n=v.y+y;
        return new Vector2(m,n);
    }
    public static Vector2 sum(Vector2 v, Vector2 d){
        double m=v.x+d.x;
        double n=v.y+d.y;
        return new Vector2(m,n);
    }
    public Vector2 mult(double k){
        double m=k*x;
        double n=k*y;
        return new Vector2(m,n);
    }
    public double mult(Vector2 v){
        double m=x*v.x;
        double n=y*v.y;
        return m+n;
    }
    public static double mult(Vector2 v, Vector2 d){
        double m=d.x*v.x;
        double n=d.y*v.y;
        return m+n;
    }
    public static Vector2 mult(Vector2 v, double k){
        double m=k*v.x;
        double n=k*v.y;
        return new Vector2(m,n);
    }
    public Vector2 normalize(){

        double l =Math.sqrt(x*x+y*y);
        if(l==0) return new Vector2(0.00, 0.00); else
            x =x/l;
        y =y/l;
        return new Vector2(x,y);
    }
    public Vector2 norm(){
        double l =Math.sqrt(x*x+y*y);
        if(l==0) return new Vector2(0.00, 0.00); else

            x=x/l;
        y=y/l;
        return new Vector2(x,y);
    }
    public Vector2 rotate(double angle){
        double g=x;
        x=x*Math.cos(angle)-y*Math.sin(angle);
        y=g * Math.sin(angle) + y * Math.cos(angle);
        return new Vector2(x,y);
    }
    public Vector2 rotated(double k){
        double m, n;
        m=x * Math.cos(k) - y * Math.sin(k);
        n=x * Math.sin(k) + y * Math.cos(k);
        return new Vector2(m,n);
    }

    public int getQuarte(){
        if(x==0 || y==0)return 0;
        if(x>0 && y>0) return 1;
        if(x<0 && y>0) return 2;
        if(x<0 && y<0) return 3;
        else return 4;
    }
    public boolean equals(Vector2 v){
        if(x==v.x && y==v.y) return true;
        else return false;
    }

    public Vector2 ort(){
        double x1, y1;
        if(y==0){  y=x/Math.sqrt(x*x+y*y); x=0;
            return new Vector2(0,x/Math.sqrt(x*x+y*y));
        }else{
            x1=-x;
            y1=y;
            double l =Math.sqrt(x1*x1+y1*y1);
            if(l==0){ return new Vector2(0.00, 0.00);} else{
                x1 =x1/l;
                y1 =y1/l;
                return new Vector2(x1,y1);
            }
        }
    }
    public double phi(){
        if(x==0 && y>0) return Math.PI/2;
        if(x==0 && y<0) return -Math.PI/2;
        if(y==0) return 0;
        if(y>0 && x>0) return Math.asin(y/Math.sqrt(x*x+y*y));
        if(y<0 && x<0) return Math.asin(y/Math.sqrt(x*x+y*y));
        if(y<0 && x>0) return Math.asin(y/Math.sqrt(x*x+y*y));
        return Math.PI-Math.asin(y/Math.sqrt(x*x+y*y));
    }

}