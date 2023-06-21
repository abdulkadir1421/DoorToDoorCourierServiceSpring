package com.example.HomeToHomeSpring.controller;

import com.example.HomeToHomeSpring.dto.JwtResponse;
import com.example.HomeToHomeSpring.model.PictureModel;
import com.example.HomeToHomeSpring.repository.PictureRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

@RequestMapping("/image")
public class PictureUploadController {
    @Autowired
    PictureRepositiry pictureRepositiry;


    private final String FOLDER_PATH = "C://Users/B1/Desktop/download_images/";

    @PostMapping("/upload")

    public ResponseEntity<?> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

        System.out.println("Original Image Byte Size - " + file.getBytes().length);

        PictureModel img = new PictureModel(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
//        PictureModel img  =new PictureModel();


//        try {
//            if (file.isEmpty()) {
//                // if the file is empty then
//                System.out.println("file i s empty");
//
//            } else {
//
//                String filePath = FOLDER_PATH + file.getOriginalFilename();
//                img = new PictureModel(file.getOriginalFilename(),filePath, file.getContentType(), compressBytes(file.getBytes()));
////                user.setImage(file.getOriginalFilename());
////                File saveFile = new ClassPathResource("static/image").getFile();
////                Path path= Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
////                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
//
//
//                file.transferTo(new File(filePath));
//
//                System.out.println("image is uploaded");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        pictureRepositiry.save(img);
        return ResponseEntity.ok("Success");

    }

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);

        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }
    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {

                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }
}
