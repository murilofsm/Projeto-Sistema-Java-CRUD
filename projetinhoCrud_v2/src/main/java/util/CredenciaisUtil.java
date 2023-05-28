package util;

public class CredenciaisUtil {
    public static Boolean confirmaSim(String resp){

        String[] vetSim ={"s","S","Sim","sim","sIm","siM","SIM"};
        for (String s : vetSim) {
            if (s.equals(resp)) {
                return true;
            }
        }
        return false;
    }
}
