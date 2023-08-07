package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
