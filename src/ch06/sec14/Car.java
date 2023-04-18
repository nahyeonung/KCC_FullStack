package ch06.sec14;

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        if(speed < 0 ){
            this.speed = 0;
            return;
        } else {
            this.speed = speed;
        }
    }

    public boolean isStop() {
        return this.stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if(stop == true) this.speed = 0;
    }

    //speed 필드의 getter/setter 선언
}
