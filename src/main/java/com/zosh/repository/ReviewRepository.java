package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
