package eu.tutorials.dictionary.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DictionaryViewModel : ViewModel() {
    private lateinit var _letter: MutableLiveData<Char>
    val letter: LiveData<Char> get() = _letter

    fun setLetter(letter: Char){
        _letter.value = letter
    }
}