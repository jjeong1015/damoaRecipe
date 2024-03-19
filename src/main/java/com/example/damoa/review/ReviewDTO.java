package com.example.damoa.review;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewDTO {
    private Long reviewId;

    private String reviewAuthorId;

    private String reviewContent;

    private Integer reviewRating;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private ReviewStatus reviewStatus;

    public ReviewDTO(Integer reviewRating, String reviewContent) {
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
    }

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "recipe_id")
//    private Recipe recipe;
}
