package com.example.damoa.recipe;

// import com.example.damoa.image.Image;

import com.example.damoa.image.Image;
import com.example.damoa.member.Member;
import com.example.damoa.review.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(nullable = false)
    private String recipeAuthorId;

    @Column(nullable = false)
    private String recipeName;

    @Column(nullable = false)
    private String recipeContent;

    @Column(nullable = false)
    private String recipeCalorie;

    @Column(nullable = false)
    private String recipeCookingTime;

    @Column(nullable = false)
    private Integer recipeLevel;

    private Integer recipeLike;

    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private RecipeStatus recipeStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
    @OneToMany(mappedBy = "recipe")
    private List<Review> reviews = new ArrayList<>();
//
//    @OneToMany(mappedBy = "recipe")
//    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
//
    @OneToMany(mappedBy = "recipe")
    private List<Image> images = new ArrayList<>();

    // 생성자

    public Recipe(String recipeName, String recipeAuthorId, String recipeContent, String recipeCalorie, String recipeCookingTime, Integer recipeLevel) {
        this.recipeName = recipeName;
        this.recipeAuthorId = recipeAuthorId;
        this.recipeContent = recipeContent;
        this.recipeCalorie = recipeCalorie;
        this.recipeCookingTime = recipeCookingTime;
        this.recipeLevel = recipeLevel;
    }


    // Getter 및 Setter는 필요에 따라 추가

    public void updateRecipe(String recipeName, String recipeAuthorId, String recipeContent, String recipeCalorie, String recipeCookingTime, Integer recipeLevel) {
        this.recipeName = recipeName;
        this.recipeAuthorId = recipeAuthorId;
        this.recipeContent = recipeContent;
        this.recipeCalorie = recipeCalorie;
        this.recipeCookingTime = recipeCookingTime;
        this.recipeLevel = recipeLevel;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
