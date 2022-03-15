package Entity.creature;

public class Cordinate {
    int x;
    int y;
    int stage;
    int papax;
    int papay;
    public Cordinate(int x,int y,int stage){
        this.x=x;
        this.y=y;
        this.stage=stage;
    }

    public int getStage() {
        return stage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void addLInk(int a,int b){
        this.papax=a;
        this.papay=b;
    }

    public int getPapax() {
        return papax;
    }

    public int getPapay() {
        return papay;
    }
}
