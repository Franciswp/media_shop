package com.fcwebapp.mediaproducts.repository;

import com.fcwebapp.mediaproducts.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReviewRepository extends JpaRepository<Review,Long> {
}
