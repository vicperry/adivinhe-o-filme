package com.engdacomp.adivinhe_o_filme.Regras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.engdacomp.adivinhe_o_filme.R
import com.example.myapplication.Classes.listaAdapter
import com.example.myapplication.Classes.regrasDesc
import kotlinx.android.synthetic.main.fragment_regras.*

class RegrasFragment : Fragment() {
      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_regras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var regrasDesc = mutableListOf(
            regrasDesc("Antes de inicar o jogo, aponte a tela para um amigo."),
            regrasDesc("Ao dar play, seu amigo fará mimicas do filme que aparecer na tela."),
            regrasDesc("Tente adivinhar o título do filme. Ao acertar o título do filme, você ganha um ponto."),
            regrasDesc("Ao pular, você perde um ponto."),
            regrasDesc("O jogo termina quando todos os 20 filmes forem exibidos."),
            regrasDesc("Troque de lugar com seu amigo e veja quem acerta mais."),
            )

        var listaAdapter = listaAdapter(regrasDesc)
        recyclerview.adapter = listaAdapter
        recyclerview.layoutManager = LinearLayoutManager(context)

    }

}