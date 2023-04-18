package ch06.sec12.hyundai;


import ch06.sec12.hankook.SnowTire;
import ch06.sec12.kumho.AllSeasonTire;
public class Car {
    //import하지 않았을 때 
    ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
    ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
    //import했을 때
    SnowTire tire3 = new SnowTire();
    AllSeasonTire tire4 = new AllSeasonTire();
}
