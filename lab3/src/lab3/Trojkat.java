package lab3;

public class Trojkat implements Figura 
{	
	private double a, b, c;
	public Trojkat(double a1, double b1, double c1) 
	{
		a = a1;
		b = b1;
		c = c1;
	}

	@Override
	public double obliczObwod() 
	{
		double obwodTrojkata = a + b + c;
		return obwodTrojkata; 
	}

	@Override
	public double obliczPole() 
	{
		double p = 0.5 * obliczObwod();
		double poleTrojkata = Math.sqrt(p * (p -a) * (p - b) * (p -c));
		return poleTrojkata;
	}
}
