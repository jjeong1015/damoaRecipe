package com.example.damoa.image;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ImageDTO {

    private Long imageId;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private ImageStatus imageStatus;

    private MultipartFile f[] = new MultipartFile[5];

    public ImageDTO(String image1, String image2, String image3, String image4, String image5) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
    }
}
