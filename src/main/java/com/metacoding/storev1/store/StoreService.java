package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void 상품등록(String name, int stock, int price) {
        storeRepository.save(name, stock, price);
    }

    public List<Store> 상품목록() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    public Store 상세보기(int id) {
        Store store = storeRepository.findByid(id);
        return store;
    }

    // 3번
    @Transactional // insert, delete, uptate시에 사용 : 함수 종료시 commit 됨.
    public void 상품삭제(int id) {

        storeRepository.deleteById(id);
    }
}
