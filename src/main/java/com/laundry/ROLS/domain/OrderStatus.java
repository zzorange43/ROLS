package com.laundry.ROLS.domain;

public enum OrderStatus {
    RECEIVED,       //접수됨
    IN_PROGRESS,    //세탁 진행 중
    READY,          //완료, 찾아가기 전
    DELIVERED,      //고객에게 전달 완료
    CANCELLED       //취소됨
}
