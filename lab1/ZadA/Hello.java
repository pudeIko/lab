package pojava.lab1.zadA;

public class Hello {

    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Blad! Nie podano argumentu");

        }

        else
        {
            System.out.println("Witaj");

            int myInt = Integer.parseInt(args[0]);
            for (int i = 0; i < myInt; i++)
            {
                System.out.println(i+1);
            }
        }
    }

}
