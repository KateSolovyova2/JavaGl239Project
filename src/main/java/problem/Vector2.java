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

}