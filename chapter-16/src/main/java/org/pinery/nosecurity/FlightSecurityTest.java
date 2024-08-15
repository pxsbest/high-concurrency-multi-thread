package org.pinery.nosecurity;

/**
 * 测试类
 **/
public class FlightSecurityTest {

    //旅客线程
    static class Passengers extends Thread{
        private final FlightSecurity flightSecurity;
        //身份证
        private final String idCard;
        //登机牌
        private final String boardingPass;

        public Passengers(FlightSecurity flightSecurity, String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }

        @Override
        public void run() {
            while (true) {
                //旅客不断过安检
                flightSecurity.pass(boardingPass,idCard);
            }
        }
    }

    public static void main(String[] args) {
        FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity,"A123456","AF123456").start();
        new Passengers(flightSecurity,"B123456","BF123456").start();
        new Passengers(flightSecurity,"C123456","CF123456").start();
    }
}
