package ie.globalcom;

public class Main {

    public void findClass(String nameClass ){

            switch(nameClass){

            case "ie.globalcom.Bell":new Bell().getSound();break;
            case "ie.globalcom.Bulb":new Bulb().getSound();break;
            case "ie.globalcom.Valve":new Valve().getSound();break;
            case "ie.globalcom.Burner":new Burner().getSound();break;
            case "ie.globalcom.Computer":new Computer().getSound();break;
            case "ie.globalcom.Amplifier":new Amplifier().getSound();break;
            case "ie.globalcom.RobotCleaner":new RobotCleaner().getSound();break;
            }

    }
}
