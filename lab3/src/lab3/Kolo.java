package lab3;

public class Kolo implements Figura 
{
	private double promien;
	public Kolo(double promien1) {
		promien = promien1;
	}

	@Override
	public double obliczObwod() {
		double obwodKola = 2 * PI * promien;
		return obwodKola;
	}

	@Override
	public double obliczPole() {
		double poleKola = PI * promien * promien;
		return poleKola;
	}
}
