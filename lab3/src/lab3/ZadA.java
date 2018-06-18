package lab3;

import java.util.*;

public class ZadA
{
	private static Scanner scanner;

	public static void main(String[] args) 
	{
		scanner = new Scanner(System.in);
		
		System.out.println("Podaj promien kola.");
		double promien = scanner.nextDouble();
		Kolo kolo = new Kolo(promien);
		
		System.out.println("Podaj dlugosci bokow a, b i c.");
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		Trojkat trojkat = new Trojkat(a, b, c);
		
		kolo.obliczObwod();
		kolo.obliczPole();
		
		trojkat.obliczObwod();
		trojkat.obliczPole();
		
		System.out.println("Pole kola wynosi: " + kolo.obliczPole());
		System.out.println("Obwod kola wynosi: " + kolo.obliczObwod());
		System.out.println("Pole trojkata wynosi: " + trojkat.obliczPole());
		System.out.println("Obwod trojkata wynosi: " + trojkat.obliczObwod());		
	}
}
