import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Lina Wen
 * @Date: 2021/7/6 - 07 - 06 - 20:40
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class QR_code {
    public static void main(String[] args) {
        MultiFormatWriter m = new MultiFormatWriter();
        try {
            //String var1, BarcodeFormat var2, int var3, int var4, Map<EncodeHintType, ?> var5
            String var1 = "https://docs.rainmeter.net/manual/getting-started/basic-tutorials/";
            BarcodeFormat var2 = BarcodeFormat.QR_CODE;
            final int w = 1000;
            final int h = 1000;
            Map<EncodeHintType, Comparable<?>> map = new HashMap<>();
            map.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            map.put(EncodeHintType.MARGIN,2);
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix encode=m.encode(var1,var2,w,h,map);
            BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_BGR);
            //生成二维码
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    image.setRGB(x,y,encode.get(x,y)? Color.BLACK.getRGB():Color.WHITE.getRGB());
                }
            }
            try {
                RandomName name = new RandomName();
                File path = new File("d:/java生成的文件/");
                if(!path.mkdirs()) {
                    if (ImageIO.write(image, "png", new File(path, name.getRandomFileName() + ".png"))) {
                        System.out.println("成功");
                    } else {
                        System.out.println("失败");
                    }
                }else {
                    System.out.println("创建路径失败，无法保存");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
