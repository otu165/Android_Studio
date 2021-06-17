package com.example.courtcounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

// SavedStateHandle : UI 상태 복구
class MainViewModel(private val handle: SavedStateHandle) : ViewModel() {
    private var score = handle.get<Int>("count") ?: 0
        set(value) {
            field = value  // backing field, field 값을 읽고 쓸 수 있다.
            liveData.value = value  // LiveData 의 값 변경 -> DataBinding 에 의해 UI 갱신됨
            handle.set("count", value)
        }

    var liveData = MutableLiveData<Int>()  // score 값 tracking 함

    init {
        liveData.value = 0
    }

    fun addScore() = score++
}