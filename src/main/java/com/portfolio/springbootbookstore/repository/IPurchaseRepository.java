package com.portfolio.springbootbookstore.repository;

import com.portfolio.springbootbookstore.model.PurchaseHistory;
import com.portfolio.springbootbookstore.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseRepository extends JpaRepository<PurchaseHistory,Long> {
    //query meaning: it selects title, price and purchase time on purchase history and runs a left Join, to show only items from the first table (purchase history) that have an intersection on the table Book selecting the book id
    //instead od dto, using projection
    @Query("select b.title as title, ph.price as price, ph.purchaseTime as purchaseTime from PurchaseHistory ph left join Book b on b.id = ph.bookId where ph.userId = : userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
