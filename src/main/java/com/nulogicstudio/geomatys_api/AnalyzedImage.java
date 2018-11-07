package com.nulogicstudio.geomatys_api;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.springframework.web.multipart.MultipartFile;

public class AnalyzedImage {
    private final int[] roi = new int[4];
    private BufferedImage newImage;

    public AnalyzedImage(int x0, int y0, int width, int height, MultipartFile im) throws IOException {
        roi[0] = x0;
        roi[1] = y0;
        roi[2] = width;
        roi[3] = height;
        BufferedImage startImage = ImageIO.read(im.getInputStream());
        newImage = startImage.getSubimage(x0, y0, width, height);        
    }
    
    public int getHeight(){
        return newImage.getHeight();
    }

    public int getWidth(){
        return newImage.getWidth();
    }

    public int getType(){
        return newImage.getType();
    }

    public byte[] getByteArray() throws IOException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(newImage, "png", baos);
        byte[] res  = baos.toByteArray();
        baos.close();
        return res;
    }

}