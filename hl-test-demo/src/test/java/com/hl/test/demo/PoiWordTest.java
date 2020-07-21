package com.hl.test.demo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

import java.io.*;
import java.util.List;

/**
 * @author Hailin
 * @date 2020/7/20
 */
public class PoiWordTest {

    public static void main(String[] args) throws Exception {
        // File photo = new File("/Users/Hailin/Desktop/temp/timg.jpeg");
        // FileInputStream in = new FileInputStream(photo);
        // // BufferedImage image = ImageIO.read(in);
        // File file = new File("/Users/Hailin/Desktop/temp/123.doc");
        // OPCPackage open = OPCPackage.open(file);
        InputStream is = new FileInputStream("/Users/Hailin/Desktop/temp/12345.docx");
        XWPFDocument document = new XWPFDocument(is);
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        XWPFParagraph paragraph = paragraphs.get(0);
        insertPicture(document, "/Users/Hailin/Desktop/temp/timg.jpeg", paragraph.createRun().getCTR()
                .addNewDrawing().addNewInline(), 100, 100);
        document.write(new FileOutputStream(new File("/Users/Hailin/Desktop/temp/555.doc")));
        // XWPFParagraph paragraph = doc.createParagraph();
        // XWPFRun run = paragraph.createRun();
        // run.addPicture(in, org.apache.poi.xwpf.usermodel.Document.PICTURE_TYPE_PNG, "",
        //         Units.pixelToEMU(image.getWidth()), Units.pixelToEMU(image.getHeight()));        // doc.addPictureData(new FileInputStream(photo), XWPFDocument.PICTURE_TYPE_JPEG);
        // doc.write(new FileOutputStream(new File("/Users/Hailin/Desktop/temp/555.doc")));
        // XWPFParagraph pic = doc.createParagraph();
        // new XWPFRun()
        // doc.create
        // doc.createPicture(document.createParagraph(),document.getAllPictures().size()-1, 400, 400,"    ");

    }

    /**
     * insert Picture
     * @param document
     * @param filePath
     * @param inline
     * @param width
     * @param height
     * @throws InvalidFormatException
     * @throws FileNotFoundException
     */
    private static void insertPicture(XWPFDocument document, String filePath,
                                      CTInline inline, int width,
                                      int height) throws InvalidFormatException,
            FileNotFoundException {
        document.addPictureData(new FileInputStream(filePath),XWPFDocument.PICTURE_TYPE_PNG);
        int id = document.getAllPictures().size() - 1;
        final int EMU = 9525;
        width *= EMU;
        height *= EMU;
        String blipId =
                document.getAllPictures().get(id).getPackageRelationship().getId();
        String picXml = getPicXml(blipId, width, height);
        XmlToken xmlToken = null;
        try {
            xmlToken = XmlToken.Factory.parse(picXml);
        } catch (XmlException xe) {
            xe.printStackTrace();
        }
        inline.set(xmlToken);
        inline.setDistT(0);
        inline.setDistB(0);
        inline.setDistL(0);
        inline.setDistR(0);
        CTPositiveSize2D extent = inline.addNewExtent();
        extent.setCx(width);
        extent.setCy(height);
        CTNonVisualDrawingProps docPr = inline.addNewDocPr();
        docPr.setId(id);
        docPr.setName("IMG_" + id);
        docPr.setDescr("IMG_" + id);
    }

    /**
     * get the xml of the picture
     * @param blipId
     * @param width
     * @param height
     * @return
     */
    private static String getPicXml(String blipId, int width, int height) {
        String picXml =
                "" + "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">" +
                        "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                        "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
                        "         <pic:nvPicPr>" + "            <pic:cNvPr id=\"" + 0 +
                        "\" name=\"Generated\"/>" + "            <pic:cNvPicPr/>" +
                        "         </pic:nvPicPr>" + "         <pic:blipFill>" +
                        "            <a:blip r:embed=\"" + blipId +
                        "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>" +
                        "            <a:stretch>" + "               <a:fillRect/>" +
                        "            </a:stretch>" + "         </pic:blipFill>" +
                        "         <pic:spPr>" + "            <a:xfrm>" +
                        "               <a:off x=\"0\" y=\"0\"/>" +
                        "               <a:ext cx=\"" + width + "\" cy=\"" + height +
                        "\"/>" + "            </a:xfrm>" +
                        "            <a:prstGeom prst=\"rect\">" +
                        "               <a:avLst/>" + "            </a:prstGeom>" +
                        "         </pic:spPr>" + "      </pic:pic>" +
                        "   </a:graphicData>" + "</a:graphic>";
        return picXml;
    }
}
