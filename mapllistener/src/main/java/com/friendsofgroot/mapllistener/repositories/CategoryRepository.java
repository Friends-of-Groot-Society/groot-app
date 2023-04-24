package com.friendsofgroot.mapllistener.repositories;

import com.friendsofgroot.mapllistener.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
