package com.example.harrypotter.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.domain.GetCharacterByIdUseCase
import com.example.harrypotter.domain.GetCharacterUseCase
import com.example.harrypotter.domain.items.CharacterItem
import com.example.harrypotter.domain.items.SpecificCharacterItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HarryPotterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
//    private val getCharactersInHouse: GetCharactersInHouse,
): ViewModel() {

    private val  _characters = MutableLiveData<List<CharacterItem>>()
    //expose to the outside world
    val characters: LiveData<List<CharacterItem>> get() = _characters

    private val  _character = MutableLiveData<SpecificCharacterItem>()
    //expose to the outside world
    val character: LiveData<SpecificCharacterItem> get() = _character


    /*TODO implement charactersHouse*/
//    private val  _charactersHouse = MutableLiveData<List<CharacterItem>>()
//    val charactersHouse: LiveData<List<CharacterItem>> get() = _characters

    init {
        getCharacters()
    }

    //Use kotlin coroutines to asynchronously fetch data from a remote datasource
    // and update state viewModel
    private fun getCharacters() {
        //launch new coroutine in viewmodelScope
        viewModelScope.launch {

                //fetch list of characters from a remote data source
                _characters.value = getCharacterUseCase()
        }

    }

//    fun getCharactersById(id: Int) {
//        //Coroutine is a lightweight thread that can suspend its execution
//        //uses ViewModelScope.launch to launch a coroutine
//        viewModelScope.launch {
//
//            try {
//
//                val character = getCharacterByIdUseCase(id)
//                _character.value = character
//
//            } catch (_: Exception) {}
//
//        }
//
//    }

}