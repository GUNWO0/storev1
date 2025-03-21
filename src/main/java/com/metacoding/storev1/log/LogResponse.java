package com.metacoding.storev1.log;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO : Data Transfer Object - 화면에 필요한 데이터만 있는 오브젝트
public class LogResponse {

    @AllArgsConstructor
    @Data // getter, setter, toString
    public static class ListPage {
        private int Id;
        private String name;
        private int qty;
        private int totalPrice;
        private String buyer;

        // @Override
        // public String toString() {
        // return "ListPage [Id=" + Id + ", name=" + name + ", qty=" + qty + ",
        // totalPrice=" + totalPrice + ", buyer="
        // + buyer + "]";
        // }

    }
}
