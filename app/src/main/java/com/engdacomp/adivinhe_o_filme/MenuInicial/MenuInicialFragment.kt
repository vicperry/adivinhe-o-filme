package com.engdacomp.adivinhe_o_filme.MenuInicial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.engdacomp.adivinhe_o_filme.R
import com.engdacomp.adivinhe_o_filme.databinding.MenuInicialFragmentBinding

class MenuInicialFragment : Fragment() {
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: MenuInicialFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.menu_inicial_fragment,container, false)

        binding.jogarButton.setOnClickListener {
            findNavController().navigate(MenuInicialFragmentDirections.actionMenuInicialFragmentToJogoFragment())
        }

        binding.regrasButton.setOnClickListener{
            findNavController().navigate(MenuInicialFragmentDirections.actionMenuInicialFragmentToRegrasFragment())
        }

        return binding.root

    }
}

