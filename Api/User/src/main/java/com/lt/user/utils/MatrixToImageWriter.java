package com.lt.user.utils;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/5 15:54
 */

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import java.util.Hashtable;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import org.apache.commons.codec.binary.Base64;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

/**
 * 生成二维码
 *
 * @param content
 * @return
 * @throws Exception
 */
/**
 * 生成二维码与转换二维码为base64字符串
 */
public class MatrixToImageWriter {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;


    public static InputStream createQrcodeImage(String content) throws Exception {
        int width = 200; // 二维码图片宽度
        int height = 200; // 二维码图片高度
        String format = "jpg";// 二维码的图片格式
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, width, height, hints);
        BufferedImage image= MatrixToImageWriter.toBufferedImage(bitMatrix);
        InputStream is=MatrixToImageWriter.toInputStream(image);
        return is;

    }

    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(InputStream inputStream) {
        byte[] data = null;
        try {
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
//        BASE64Encoder encoder = new BASE64Encoder();
////        return encoder.encode(data);
        return  Base64.encodeBase64String(data);
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static InputStream toInputStream(BufferedImage image) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        ImageIO.write(image, "jpg", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format "
                    + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format,
                                     OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }



    public static void main(String[] args) throws Exception {
        try{
            String text = "http://www.baidu.com"; // 二维码内容
            int width = 200; // 二维码图片宽度
            int height = 200; // 二维码图片高度
            String format = "jpg";// 二维码的图片格式

            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码

            BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
                    BarcodeFormat.QR_CODE, width, height, hints);
            BufferedImage image= MatrixToImageWriter.toBufferedImage(bitMatrix);
            InputStream is=MatrixToImageWriter.toInputStream(image);
            // 生成二维码保存电脑路径
            File outputFile = new File("E://new.jpg");
            MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        } catch (Exception e) {
            System.out.println("异常=="+e.getMessage());
            e.printStackTrace();
        }
    }



}
