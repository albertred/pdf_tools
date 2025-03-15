package org.michelle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.util.Matrix;

import java.io.File;
import java.io.IOException;

public class PdfShifter {

    public static void shiftPdfContent(String inputFilePath, String outputFilePath, float yOffset) throws IOException {
        try (PDDocument document = PDDocument.load(new File(inputFilePath))) {
            for (PDPage page : document.getPages()) {
                // Create a new content stream for the existing page
                try (PDPageContentStream contentStream = new PDPageContentStream(document, page,
                        PDPageContentStream.AppendMode.PREPEND, true, true)) {

                    // Shift the content down using a transformation matrix
                    contentStream.transform(new Matrix(1, 0, 0, 1, 0, -yOffset));
                }
            }

            // Save the modified document
            document.save(outputFilePath);
            System.out.println("PDF shifted and saved to: " + outputFilePath);
        }
    }

    public static void main(String[] args) {
        String inputFile = "D:\\Tao\\Lynn\\T4 Summary Information.pdf";
        String outputFile = "D:\\Tao\\Lynn\\T4 Summary Information shifted.pdf";
        float yOffset = 102;

        try {
            shiftPdfContent(inputFile, outputFile, yOffset);
            System.out.println("PDF shifted successfully.");
        } catch (IOException e) {
            System.err.println("Error shifting PDF: " + e.getMessage());
        }
    }
}