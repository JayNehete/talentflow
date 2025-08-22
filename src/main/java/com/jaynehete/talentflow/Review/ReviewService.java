package com.jaynehete.talentflow.Review;

import com.jaynehete.talentflow.company.Company;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);
    boolean deleteReview(Long companyId, Long reviewId);

}