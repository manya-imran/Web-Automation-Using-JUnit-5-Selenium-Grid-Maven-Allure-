package testautomatinau;


import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {

        BaseTest test = new BaseTest();
        try{
            test.setUp();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }
}