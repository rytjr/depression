package com.example.myapplication

// 날씨 정보를 담는 데이터 클래스
class DataModel (
    var sky : String,          // 하능 상태
    var temp : String,    // 기온
    var fcstTime : String    // 예보시각
    ) {
    constructor() : this("","","")
}