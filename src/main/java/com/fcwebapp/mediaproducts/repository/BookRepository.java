package com.fcwebapp.mediaproducts.repository;

import com.fcwebapp.mediaproducts.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {

}
