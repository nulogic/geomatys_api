package com.nulogicstudio.geomatys_api;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

@CrossOrigin
@RestController
public class ApiController {

    
    @GetMapping("/")
    public Home home(){
        return new Home();
    }

    @PostMapping(value = "/", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] analyzeImage(@RequestParam int x0, @RequestParam int y0, @RequestParam int w, @RequestParam int h, @RequestParam("file") MultipartFile image){
        try {
            AnalyzedImage im = new AnalyzedImage(x0,y0,w,h,image);
            return im.getByteArray();
        } catch (IOException ex) {       
            // send the approrpiate http code
            return null;
        }
        
    }

    
    
}