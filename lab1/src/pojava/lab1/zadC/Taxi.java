package pojava.lab1.zadC;

import java.util.Random;

public class Taxi extends Auto {

    float[] zarobki;
    Taxi()
    {
        Random random = new Random();
        zarobki = new float[12];
        for (int i = 0; i < zarobki.length; i++)
        {
            zarobki[i] = (random.nextInt() * 100)^2;
        }
    }
    float srZarobki()
    {
        float suma = 0;
        for (int i = 0; i < zarobki.length; i++)
        {
            suma = suma + zarobki[i];
        }
        float srZarobki = suma / zarobki.length;
        return srZarobki;
    }

    public static void main(String[] args)
    {
        Taxi taxi = new Taxi();

        System.out.println(taxi.srPrzebieg());
        System.out.println(taxi.srZarobki());

    }
}
