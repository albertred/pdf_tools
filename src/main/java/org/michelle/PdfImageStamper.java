package org.michelle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PdfImageStamper {
    private static String FILE_PATH = "D:\\Michelle\\Gov_CoOp_2024\\";
    private static String SIGNATURE_FILE_NAME = "Michelle-Lu.png";
    private static String DATE_FILE_NAME = "date.png";
    private static String CHECK_MARK = "checkmark.png";

    private static void stampPdf(String inputPdfFilename, String outputPdfFilename, int pageIndex, float scale, int x, int y, String imageName) {
        try {
            // Load the PDF document
            PDDocument document = PDDocument.load(new File(FILE_PATH + inputPdfFilename + ".pdf"));

            document.setAllSecurityToBeRemoved(true);

            // Get the first page of the document
            PDPage page = document.getPage(pageIndex);

            // Create a PDImageXObject from the image file
            PDImageXObject image = PDImageXObject.createFromFile(FILE_PATH + imageName, document);

            // Calculate new dimensions (50% of original)
            float scaledWidth = image.getWidth() * scale;
            float scaledHeight = image.getHeight() * scale;


            // Add the image to the PDF page
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
            contentStream.drawImage(image, x, y, scaledWidth, scaledHeight);
            contentStream.close();

            // Save the modified PDF document
            document.save(FILE_PATH + outputPdfFilename + ".pdf");

            // Close the document
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main_bak(String[] args) {
        stampPdf("plain_filled_pdfs\\Direct Deposit Application Form-Michelle Lu", "signed\\Direct Deposit Application Form-Michelle Lu", 1, 0.5f, 150, 67, SIGNATURE_FILE_NAME);
        stampPdf("signed\\Direct Deposit Application Form-Michelle Lu", "signed\\Direct Deposit Application Form-Michelle Lu", 1, 0.4f, 370, 67, DATE_FILE_NAME);
        stampPdf("signed\\Direct Deposit Application Form-Michelle Lu", "signed\\Direct Deposit Application Form-Michelle Lu", 1, 0.06f, 80 , 94, CHECK_MARK);


        stampPdf("plain_filled_pdfs\\Michelle Lu - HireFxTm-OPSEU-COOP-Student Induction Package",
                "signed\\Michelle Lu - HireFxTm-OPSEU-COOP-Student Induction Package",
                5, 0.5f, 120, 200, SIGNATURE_FILE_NAME);
        stampPdf("signed\\Michelle Lu - HireFxTm-OPSEU-COOP-Student Induction Package",
                "signed\\Michelle Lu - HireFxTm-OPSEU-COOP-Student Induction Package",
                8, 0.5f, 150, 660, SIGNATURE_FILE_NAME);
        stampPdf("signed\\Michelle Lu - HireFxTm-OPSEU-COOP-Student Induction Package",
                "signed\\Michelle Lu - HireFxTm-OPSEU-COOP-Student Induction Package",
                8, 0.4f, 380, 660, DATE_FILE_NAME);


        stampPdf("plain_filled_pdfs\\OPSEU-Pension-Consent-form-Michelle Lu",
                "signed\\OPSEU-Pension-Consent-form-Michelle Lu",
                0, 0.5f, 250, 343, SIGNATURE_FILE_NAME);
        stampPdf("signed\\OPSEU-Pension-Consent-form-Michelle Lu",
                "signed\\OPSEU-Pension-Consent-form-Michelle Lu",
                0, 0.4f, 400, 343, DATE_FILE_NAME);



        stampPdf("plain_filled_pdfs\\td1-fill-24e- Michelle Lu",
                "signed\\td1-fill-24e- Michelle Lu",
                1, 0.5f, 150, 80, SIGNATURE_FILE_NAME);
        stampPdf("signed\\td1-fill-24e- Michelle Lu",
                "signed\\td1-fill-24e- Michelle Lu",
                1, 0.5f, 495, 79, DATE_FILE_NAME);


        stampPdf("plain_filled_pdfs\\td1on-fill-24e-Michelle Lu",
                "signed\\td1on-fill-24e-Michelle Lu",
                1, 0.5f, 150, 299, SIGNATURE_FILE_NAME);
        stampPdf("signed\\td1on-fill-24e-Michelle Lu",
                "signed\\td1on-fill-24e-Michelle Lu",
                1, 0.5f, 505, 298, DATE_FILE_NAME);


        stampPdf("plain_filled_pdfs\\passport",
                "signed\\passport",
                0, 0.5f, 150, 10, SIGNATURE_FILE_NAME);
        stampPdf("signed\\passport",
                "signed\\passport",
                0, 0.5f, 305, 10, DATE_FILE_NAME);


        stampPdf("plain_filled_pdfs\\sin",
                "signed\\sin",
                0, 0.5f, 480, 300, SIGNATURE_FILE_NAME);
        stampPdf("signed\\sin",
                "signed\\sin",
                0, 0.5f, 480, 250, DATE_FILE_NAME);


        stampPdf("plain_filled_pdfs\\Offer Letter Michelle Lu May 6, 2024(JX)",
                "signed\\Offer Letter Michelle Lu May 6, 2024(JX)",
                6, 0.5f, 135, 395, SIGNATURE_FILE_NAME);
        stampPdf("signed\\Offer Letter Michelle Lu May 6, 2024(JX)",
                "signed\\Offer Letter Michelle Lu May 6, 2024(JX)",
                6, 0.5f, 360, 395, DATE_FILE_NAME);

    }
}
