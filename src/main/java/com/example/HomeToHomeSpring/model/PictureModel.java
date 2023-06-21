package com.example.HomeToHomeSpring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image_table")
public class PictureModel {



    @Id

    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "name")

    private String name;

    @Column(name = "type")

    private String type;

        //image bytes can have large lengths so we specify a value

        //which is more than the default length for picByte column

    @Column(name = "picByte", length = 1000)


    private byte[] picByte;


    public PictureModel(String originalFilename, String contentType, byte[] compressBytes) {
    }
}
