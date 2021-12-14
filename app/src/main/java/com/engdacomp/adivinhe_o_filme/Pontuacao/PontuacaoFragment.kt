package com.engdacomp.adivinhe_o_filme.Pontuacao

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.engdacomp.adivinhe_o_filme.R
import com.engdacomp.adivinhe_o_filme.databinding.PontuacaoFragmentBinding
import java.io.File
import android.widget.Toast

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK

import android.graphics.Bitmap

import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.lang.Exception


class PontuacaoFragment : Fragment() {

    internal lateinit var cImg: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: PontuacaoFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.pontuacao_fragment, container, false)

        val pontuacaoFragmentArgs by navArgs<PontuacaoFragmentArgs>()
        binding.pontuacaoText.text = pontuacaoFragmentArgs.pontuacao.toString()
        binding.jogarNovamenteButton.setOnClickListener { jogarDeNovo() }
        binding.mimicaButton.setOnClickListener { mimica() }

        return binding.root
    }

    private fun mimica() {
        val implicit = Intent(Intent.ACTION_VIEW, Uri.parse("https://pt.wikipedia.org/wiki/M%C3%ADmica"))
        startActivity(implicit)
    }

    private fun jogarDeNovo() {
    findNavController().navigate(PontuacaoFragmentDirections.actionPontuacaoFragmentToJogoFragment())
    }

}