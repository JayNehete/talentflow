package com.jaynehete.talentflow.Review;

import com.jaynehete.talentflow.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.getAllReviews(id), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if(isReviewSaved) {
            return new ResponseEntity<>("Successfully added review", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Review is not saved", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long comapyId, @PathVariable Long reviewId, @RequestBody Review review){
        boolean isReviewUpdated = reviewService.updateReview(comapyId, reviewId, review);
        if(isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReview(@PathVariable Long comapyId, @PathVariable Long reviewId, @RequestBody Review review){
        boolean isReviewDeleted = reviewService.deleteReview(comapyId, reviewId);
        if(isReviewDeleted)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated", HttpStatus.NOT_FOUND);
    }
}
