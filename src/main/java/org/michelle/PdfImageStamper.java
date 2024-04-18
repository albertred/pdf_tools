package org.michelle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PdfImageStamper {
    private static String FILE_PATH = "D:\\Michelle\\Gov_CoOp_2024\\";
    private static String IMAGE_FILE_NAME = "Michelle-Lu.png";


    private static void stampPdf(String inputPdfFilename, int x, int y) {
        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File(FILE_PATH + inputPdfFilename + ".pdf"));

            document.setAllSecurityToBeRemoved(true);

            // Get the first page of the document
            PDPage page = document.getPage(0);

            // Create a PDImageXObject from the image file
            PDImageXObject image = PDImageXObject.createFromFile(FILE_PATH + IMAGE_FILE_NAME, document);

            // Get the dimensions of the image
            float imageWidth = image.getWidth();
            float imageHeight = image.getHeight();

            // Add the image to the PDF page
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
            contentStream.drawImage(image, x, y, imageWidth, imageHeight);
            contentStream.close();

            // Save the modified PDF document
            document.save(FILE_PATH + "output\\" + inputPdfFilename + "_signed.pdf");

            // Close the document
            document.close();

            System.out.println("file <" + inputPdfFilename + "> stamped successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        stampPdf("Direct Deposit Application Form", 100, 100);
    }
}
