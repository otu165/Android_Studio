package com.example.jetpackprac.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Database 의 행을 이룰 데이터 클래스
 *
 */

@Entity
data class Text (
    var text : String // val 이 아니라 반드시 var 로 선언해야 함, val 은 getter / setter 없음!
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0 // primary type 은 반드시 선언과 동시에 초기화 해주어야 함
}