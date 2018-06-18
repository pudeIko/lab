package pojava.lab1.zadC;

import java.util.Random;

public class Auto {
    float[] przebieg;
    Auto()
    {
        Random random = new Random();
        przebieg = new float[12];
        for (int i = 0; i < przebieg.length; i++)
        {
            przebieg[i] = (random.nextInt() * 100)^2;
        }
    }
    float srPrzebieg()
    {
        float suma = 0;
        for (int i = 0; i < przebieg.length; i++)
        {
            suma = przebieg[i] + suma;
        }
        float srPrzebieg = suma / przebieg.length;
        return srPrzebieg;
    }

}
