/* =====================================================================
 * OrsonPDF : a fast, light-weight PDF library for the Java(tm) platform
 * =====================================================================
 * 
 * (C)opyright 2013-2015, by Object Refinery Limited.  All rights reserved.
 *
 * Project Info:  http://www.object-refinery.com/orsonpdf/index.html
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 * 
 * If you do not wish to be bound by the terms of the GPL, an alternative
 * commercial license can be purchased.  For details, please see visit the
 * Orson PDF home page:
 * 
 * http://www.object-refinery.com/orsonpdf/index.html
 * 
 */

package zadanie2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;

/**
 * A demo/test for a pie chart.
 */
public class PDFPieChartDemo1 {
    
    /**
     * Creates a sample dataset.
     * 
     * Source: http://www.bbc.co.uk/news/business-15489523
     *
     * @return A sample dataset.
     */
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Samsung", new Double(27.8));
        dataset.setValue("Others", new Double(55.3));
        dataset.setValue("Nokia", new Double(16.8));
        dataset.setValue("Apple", new Double(17.1));
        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return A chart.
     */
    private static JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
            "Smart Phones Manufactured / Q3 2011", dataset, false, false, 
            false);

        chart.setBackgroundPaint(new GradientPaint(new Point(0, 0), 
                new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));

        // customise the title position and font
        TextTitle t = chart.getTitle();
        t.setHorizontalAlignment(HorizontalAlignment.LEFT);
        t.setPaint(new Color(240, 240, 240));
        t.setFont(new Font("Arial", Font.BOLD, 26));

        PiePlot plot = (PiePlot) chart.getPlot();
       
        plot.setBackgroundPaint(null);
        plot.setInteriorGap(0.04);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setLabelShadowPaint(null);
        
        // use gradients and white borders for the section colours
        plot.setSectionPaint("Others", createGradientPaint(new Color(200, 200, 255), Color.BLUE));
        plot.setSectionPaint("Samsung", createGradientPaint(new Color(255, 200, 200), Color.RED));
        plot.setSectionPaint("Apple", createGradientPaint(new Color(200, 255, 200), Color.GREEN));
        plot.setSectionPaint("Nokia", createGradientPaint(new Color(200, 255, 200), Color.YELLOW));
        plot.setBaseSectionOutlinePaint(Color.WHITE);
        plot.setSectionOutlinesVisible(true);
        BasicStroke bs = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f);
        plot.setBaseSectionOutlineStroke(new BasicStroke(2.0f));

        // customise the section label appearance
        plot.setLabelFont(new Font("Courier New", Font.BOLD, 20));
        plot.setLabelLinkPaint(Color.WHITE);
        plot.setLabelLinkStroke(new BasicStroke(2.0f));
        plot.setLabelOutlineStroke(null);
        plot.setLabelPaint(Color.WHITE);
        plot.setLabelBackgroundPaint(null);
        
        // add a subtitle giving the data source
        TextTitle source = new TextTitle("Source: http://www.bbc.co.uk/news/business-15489523", 
                new Font("Courier New", Font.PLAIN, 12));
        source.setPaint(Color.WHITE);
        source.setPosition(RectangleEdge.BOTTOM);
        source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        chart.addSubtitle(source);
        return chart;

    }

    /**
     * A utility method for creating gradient paints.
     * 
     * @param c1  color 1.
     * @param c2  color 2.
     * 
     * @return A radial gradient paint.
     */
    private static RadialGradientPaint createGradientPaint(Color c1, Color c2) {
        Point2D center = new Point2D.Float(0, 0);
        float radius = 200;
        float[] dist = {0.0f, 1.0f};
        return new RadialGradientPaint(center, radius, dist,
                new Color[] {c1, c2});
    }

    /**
     * Starting point for the demo.
     * 
     * @param args  ignored.
     * 
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        JFreeChart chart = createChart(createDataset());
        PDFDocument pdfDoc = new PDFDocument();
        pdfDoc.setTitle("PDFPieChartDemo1");
        pdfDoc.setAuthor("Object Refinery Limited");
        Page page = pdfDoc.createPage(new Rectangle(612, 468));
        PDFGraphics2D g2 = page.getGraphics2D();
        g2.setRenderingHint(JFreeChart.KEY_SUPPRESS_SHADOW_GENERATION, true);
        chart.draw(g2, new Rectangle(0, 0, 612, 468));
        File f = new File("PDFPieChartDemo1.pdf");
        pdfDoc.writeToFile(f);
    }
}
