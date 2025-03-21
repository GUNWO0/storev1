package com.metacoding.storev1.store;

import java.util.List;

import javax.management.RuntimeErrorException;

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
        // 1. 상품 있어?
        Store store = storeRepository.findByid(id);

        // 2. 없으면 예외 터트리기
        if (store == null)
            throw new RuntimeException("상품없어");

        // 3. 삭제
        storeRepository.deleteById(id); // write (DML = insert, delete, update)
    }

    @Transactional
    public void 상품수정(Integer id, String name, String stock, String price) {
        // 1. 상품조회

        Store store = storeRepository.findByid(id);

        // 2. 없으면 예외 터트리기
        if (store == null)
            throw new RuntimeException("상품없어");

        // 3. 상품 수정
        storeRepository.updateById(id, name, stock, price);

    }
}
