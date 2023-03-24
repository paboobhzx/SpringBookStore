package com.portfolio.springbootbookstore.service;

import com.portfolio.springbootbookstore.model.PurchaseHistory;
import com.portfolio.springbootbookstore.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItem(Long userId);
}
