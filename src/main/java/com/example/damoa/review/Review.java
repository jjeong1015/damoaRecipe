package com.example.damoa.review;

import com.example.damoa.member.Member;
import com.example.damoa.recipe.Recipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(nullable = false)
    private String reviewAuthorId;

    @Column
    private String reviewContent;

    @Column(nullable = false)
    private Integer reviewRating;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }


    public Review(Integer reviewRating, String reviewContent /*, Member member, Recipe recipe, Category category */) {
        this.reviewRating = reviewRating;
        this.reviewContent = reviewContent;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.reviewStatus = reviewStatus;
//        this.member = member;
//        this.recipe = recipe;
        //this.category = category;
    }
}
