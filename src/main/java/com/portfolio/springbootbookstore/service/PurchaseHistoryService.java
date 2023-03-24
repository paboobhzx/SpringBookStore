package com.portfolio.springbootbookstore.service;

import com.portfolio.springbootbookstore.model.PurchaseHistory;
import com.portfolio.springbootbookstore.repository.IPurchaseRepository;
import com.portfolio.springbootbookstore.repository.projection.IPurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {
    IPurchaseRepository purchaseRepository;

    public PurchaseHistoryService(IPurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchaseHistory);
    }
    @Override
    public List<IPurchaseItem> findPurchasedItem(Long userId){
        return purchaseRepository.findAllPurchasesOfUser(userId);
    }
}
