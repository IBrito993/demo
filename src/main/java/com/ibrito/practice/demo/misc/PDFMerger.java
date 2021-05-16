package com.ibrito.practice.demo.misc;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFMerger {
    public static void main(String[] args) {
        String pdf1Path = "C:\\Dev\\DOC\\ContratoTCS.pdf";  // Reemplaza con la ruta de tu primer PDF
        String pdf2Path = "C:\\Dev\\DOC\\anexoTCS.pdf";  // Reemplaza con la ruta de tu segundo PDF
        String outputPath = "C:\\Dev\\DOC\\nuevo_documento.pdf";  // Reemplaza con la ruta del nuevo PDF fusionado

        try {
            mergePDFs(pdf1Path, pdf2Path, outputPath);
            System.out.println("La fusión de PDFs se completó con éxito. El nuevo archivo se guardó en: " + outputPath);
        } catch (IOException  e) {
            System.err.println("Se produjo un error al fusionar los PDFs: " + e.getMessage());
        }

        String jpgFolderPath = "/ruta/del/directorio/con/imagenes";  // Reemplaza con la ruta del directorio de imágenes
        String outputPdfPath = "resultado.pdf";  // Reemplaza con la ruta del PDF de salida

        try {
            convertJpgToPdf(jpgFolderPath, outputPdfPath);
            System.out.println("La conversión de JPG a PDF se completó con éxito. El nuevo archivo se guardó en: " + outputPdfPath);
        } catch (IOException | DocumentException e) {
            System.err.println("Se produjo un error al convertir las imágenes a PDF: " + e.getMessage());
        }

    }

    private static void mergePDFs(String pdf1Path, String pdf2Path, String outputPath) throws IOException {
        try (PDDocument pdf1 = PDDocument.load(new java.io.File(pdf1Path));
             PDDocument pdf2 = PDDocument.load(new java.io.File(pdf2Path));
             PDDocument resultPDF = new PDDocument()) {

            // Agregar todas las páginas del primer PDF al nuevo PDF
            PDPageTree pages1 = pdf1.getDocumentCatalog().getPages();
            for (PDPage page : pages1) {
                resultPDF.addPage(page);
            }

            // Agregar todas las páginas del segundo PDF al nuevo PDF
            PDPageTree pages2 = pdf2.getDocumentCatalog().getPages();
            for (PDPage page : pages2) {
                resultPDF.addPage(page);
            }

            // Guardar el resultado en un nuevo archivo
            resultPDF.save(outputPath);
        }
    }

    private static void convertJpgToPdf(String jpgFolderPath, String outputPdfPath) throws IOException, DocumentException {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
            File folder = new File(jpgFolderPath);
            File[] jpgFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg"));

            if (jpgFiles != null) {
                for (File jpgFile : jpgFiles) {
                    Image img = Image.getInstance(jpgFile.getAbsolutePath());
                    document.add(img);
                }
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
