package ru.axout.fragmentstest;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {

    /*
    "by lazy" говорит, что при создании класса DataModel впервые создаётся то,
    что находится после фигурных скобок.
    При повторном создании класса DataModel будет использоваться то,
    что уже было создано после фигурных скобок.
     */
    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageForFrag1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageForFrag2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
