package com.engdacomp.adivinhe_o_filme.Jogo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.engdacomp.adivinhe_o_filme.R
import com.engdacomp.adivinhe_o_filme.databinding.JogoFragmentBinding


class JogoFragment : Fragment() {

    private lateinit var binding: JogoFragmentBinding
    private lateinit var viewModel: JogoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.jogo_fragment,container,false)

        viewModel = ViewModelProvider(this).get(JogoViewModel::class.java)

        binding.corretoButton.setOnClickListener{
            viewModel.correto()
        }
        binding.pularButton.setOnClickListener {
            viewModel.pular()
        }

        viewModel.pontuacao.observe(viewLifecycleOwner, Observer { novaPontuacao ->
            binding.pontuacaoText.text = novaPontuacao.toString()
        })

        viewModel.filmeAtual.observe(viewLifecycleOwner, Observer { novoFilme ->
            binding.filmeText.text = novoFilme
        })

        viewModel.eventEndGame.observe(viewLifecycleOwner,Observer{ jaTerminou ->
            if (jaTerminou){
                endGame()
                viewModel.jogoTerminado()
            }
        })

        return binding.root
    }

    private fun endGame(){
        val action = JogoFragmentDirections.actionJogoFragmentToPontuacaoFragment()
        val pontuacaoAtual = viewModel.pontuacao.value ?: 0
        action.setPontuacao(pontuacaoAtual)
        findNavController(this).navigate(action)
    }
}