package com.engdacomp.adivinhe_o_filme.Jogo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JogoViewModel : ViewModel(){
    private val _filmeAtual = MutableLiveData<String>()
    val filmeAtual: LiveData<String>
        get() = _filmeAtual

    private var _pontuacao = MutableLiveData<Int>()
    val pontuacao: LiveData<Int>
        get() = _pontuacao

    private lateinit var listaFilmes: MutableList<String>

    private val _eventEndGame = MutableLiveData<Boolean>()
    val eventEndGame: LiveData<Boolean>
        get() = _eventEndGame


    init{
        _eventEndGame.value = false
        Log.i("JogoViewModel", "JogoViewModel criado!")
        resetarLista()
        proximoFilme()
        _pontuacao.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("JogoViewModel", "JogoViewModel destruído!")
    }

    fun pular() {
        _pontuacao.value = (_pontuacao.value)?.minus(1)
        proximoFilme()
    }

    fun correto() {
        _pontuacao.value = (_pontuacao.value)?.plus(1)
        proximoFilme()
    }

    private fun proximoFilme() {
        if (listaFilmes.isEmpty()){
            _eventEndGame.value = true
        } else {
            _filmeAtual.value = listaFilmes.removeAt(0)
        }
    }

    private fun resetarLista() {
        listaFilmes = mutableListOf(
            "Homem-Aranha: De Volta ao Lar",
            "Orgulho e Preconceito",
            "La La Land",
            "Mãe!",
            "Midsommar",
            "007 - Operação Skyfall",
            "A Chegada",
            "Moana",
            "Frozen - Uma Aventura Congelante",
            "Blade Runner",
            "Mad Max",
            "Cisne Negro",
            "Kill Bill",
            "Batman V Superman",
            "Harry Potter e a Câmara Secreta",
            "Matrix: Reloaded",
            "Malévola",
            "X-Men: Dias de um Futuro Esquecido",
            "Os Incríveis",
            "Amanhecer: Parte 2"
        )
        listaFilmes.shuffle()
    }

    fun jogoTerminado() {
        _eventEndGame.value = false
    }
}
