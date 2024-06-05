package vizitkar;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
/**
 * @author Crunchify.com
 * Simple QR Code Generator Example - Create QR codes for free.
 */
public class QRCodeGenerator {
	public static void main(String[] args) {
		try {
			createQR("https://feit.uniza.sk","QRCode.png",512, Color.BLACK, Color.WHITE);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
    public static void createQR(String myCodeText,String filePath, int size, Color bgColor, Color qrColor)throws IOException {
    	String crunchifyFileType = "png";
        File crunchifyFile = new File(filePath);
        try {
            Map<EncodeHintType, Object> crunchifyHintType = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            crunchifyHintType.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            crunchifyHintType.put(EncodeHintType.MARGIN, 1); /* default = 4 */
            Object put = crunchifyHintType.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            QRCodeWriter mYQRCodeWriter = new QRCodeWriter(); // throws com.google.zxing.WriterException
            BitMatrix crunchifyBitMatrix = mYQRCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size,
                    size, crunchifyHintType);
            int CrunchifyWidth = crunchifyBitMatrix.getWidth();
            BufferedImage crunchifyImage = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                    BufferedImage.TYPE_INT_RGB);
            crunchifyImage.createGraphics();
            Graphics2D crunchifyGraphics = (Graphics2D) crunchifyImage.getGraphics();
            crunchifyGraphics.setColor(bgColor);
            crunchifyGraphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
            crunchifyGraphics.setColor(qrColor);
            for (int i = 0; i < CrunchifyWidth; i++) {
                for (int j = 0; j < CrunchifyWidth; j++) {
                    if (crunchifyBitMatrix.get(i, j)) {
                        crunchifyGraphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(crunchifyImage, crunchifyFileType, crunchifyFile);
        } catch (WriterException e) {
            System.out.println("\nSorry.. Something went wrong...\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

