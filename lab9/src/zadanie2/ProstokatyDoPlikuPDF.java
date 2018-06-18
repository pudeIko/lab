package zadanie2;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;

import zadanie2.Prostokat;

public class ProstokatyDoPlikuPDF {

	
	static Random r = new Random();
	
	public static void main(String[] args) {
		
		// Tworzenie nowej klasy reprezentujacej dokument PDF
        PDFDocument pdfDoc = new PDFDocument();
        
        // opcjonalne ustawianie tytulu i autora PDF:
        pdfDoc.setTitle("Zapis prostokatow do pliku PDF");
        pdfDoc.setAuthor("Imie i nazwisko autora");
     
        
        // dodawanie nowej strony do klasy reprezentujacej PDF
        Page page = pdfDoc.createPage(new Rectangle(794, 1123));
        // 794px x 1123px odpowiada mniej wiecej A4 z rozdzielczoscia 96 dpi 
                
        // Tworzenie obiektu PDFGraphics2d (dziedziczacego z Graphics2D)
        // powiazanego z dodana strona:
        PDFGraphics2D g2 = page.getGraphics2D();
        
        // Tworzenie listy 200 losowych prostokatow - analogicznych jak w zadaniu 2 z Lab 7
        List<Prostokat> prostakaty = new ArrayList<Prostokat>();		
		for (int i = 1; i<200 ; i++) 
			prostakaty.add( new Prostokat(r.nextInt(750), r.nextInt(1100), r.nextInt(100), r.nextInt(100), new Color ((int) r.nextLong(), true) ));
		
		// pętla wykorzystujaca metode paint stworzona w klasie Prostakat do rysowania
		// w obiekcie graficznycm powiazanym z PDFDocument
		for (Prostokat pr : prostakaty) {
			pr.paint( g2 );
		}		
		
		// dodanie do listy kolejnych 200 losowych prostokatow		
		for (int i = 1; i<200 ; i++) 
			prostakaty.add( new Prostokat(r.nextInt(750), r.nextInt(1100), r.nextInt(100), r.nextInt(100), new Color ((int) r.nextLong(), true) ));
		
		// utworzenie drugiej strony i dodanie grafiki
	    Page page2 = pdfDoc.createPage(new Rectangle(794, 1123));
	    PDFGraphics2D g2page2 = page2.getGraphics2D();
	    for (Prostokat pr : prostakaty) {
			pr.paint( g2page2 );
		}    
		
		// Tworzenie pustego pliku 
		File file = new File("ProstokatyDoPDF.pdf");
		// zapis do pliku zawartosci dodanej do obiektu pdfDoc
		pdfDoc.writeToFile(file);
		
		System.out.println("Prostokaty zapisano do pliku: " + file.getAbsolutePath());		
	}

}
