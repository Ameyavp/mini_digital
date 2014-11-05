/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
/**
 *
 * @author ameya
 */
public class PDFDevelopment extends javax.swing.JFrame {
  
    /**
     * Creates new form PDFDevelopment
     */
    public PDFDevelopment() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PDFDevelopment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDFDevelopment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDFDevelopment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFDevelopment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new PDFDevelopment().setVisible(true);
                  
            }
        });
        try {
	            OutputStream file = new FileOutputStream(new File("SamplePDF.pdf"));
	            Document document = new Document();
	            PdfWriter.getInstance(document, file);

	            document.open();
	          //  document.add(new Paragraph("First iText PDF"));
	          //  document.add(new Paragraph(new Date().toString()));

	            document.addAuthor("Ameya");
	            document.addCreationDate();
	            document.addCreator("JavaBeat");
	            document.addTitle("Transaction");
                    
                    Chunk chunk=new Chunk("Sender's Name: ");
		    chunk.setUnderline(+1f,-2f);//1st co-ordinate is for line width,2nd is space between
		    Chunk chunk1=new Chunk("Php4s.com");
		    chunk1.setUnderline(+4f,-8f);
		   // chunk1.setBackground(new BaseColor (17, 46, 193));  
                    	document.add(chunk);
                        document.add(chunk1);
                        
	            //Create Paragraph
	      //      Paragraph paragraph = new Paragraph("Title 1",new Font(Font.FontFamily.TIMES_ROMAN, 18,
	           // 	      Font.BOLD));
                      Paragraph paragraph = new Paragraph();
	            //New line
	            paragraph.add(new Paragraph(" "));
	            //paragraph.add("Test Paragraph");
	            paragraph.add(new Paragraph(" "));
	            document.add(paragraph);

	            //Create a table in PDF
	            PdfPTable pdfTable = new PdfPTable(3);
	        //    PdfPCell cell1 = new PdfPCell(new Phrase("Table Header 1"));
	            PdfPCell cell1 = new PdfPCell();
	        //    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	          //  pdfTable.addCell(cell1);

	            //cell1 = new PdfPCell(new Phrase("Table Header 2"));
	            //cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	           // pdfTable.addCell(cell1);

	            //cell1 = new PdfPCell(new Phrase("Table Header 3"));
	            //cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            //pdfTable.addCell(cell1);
	            //pdfTable.setHeaderRows(1);

	            pdfTable.addCell("Sender");
	            pdfTable.addCell("Row 1 Col 2");
	            pdfTable.addCell("Row 1 Col 3");

	            pdfTable.addCell("Receipient's name: ");
	            pdfTable.addCell("Row 2 Col 2");
	            pdfTable.addCell("Row 2 Col 3");

	            document.add(pdfTable);

	            document.close();
	            file.close();
                    
                        

                    
                    String currentDir = System.getProperty("user.dir");   
                    currentDir = currentDir+"/SamplePDF.pdf";  
                    System.out.println("Current dir using System:" +currentDir);  
                    File file_read = new File(currentDir );
                    if (file_read.exists()) {
                        Desktop desktop = Desktop.getDesktop();
                        if (desktop.isSupported(Desktop.Action.OPEN)) {
                           // if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(file_read);
                        } else {
				System.out.println("Awt Desktop is not supported!");
                        }
                    } else {    
 
			System.out.println("File is not exists");
 
                    }
 
		    System.out.println("Done");
 
  	  }

	  catch (Exception e) {

	            e.printStackTrace();
	        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}