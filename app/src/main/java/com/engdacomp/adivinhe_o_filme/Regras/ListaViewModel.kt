package com.example.myapplication.Classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.engdacomp.adivinhe_o_filme.R
import kotlinx.android.synthetic.main.res_item_live.view.*

class regrasDesc (
    var desc : String
)

class listaAdapter (val regrasDesc : List<regrasDesc>)
    : RecyclerView.Adapter<listaAdapter.listaViewHolder>(){

    class listaViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val desc = view.desc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : listaViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.res_item_live,
                parent, false
            )
        val listaViewHolder = listaViewHolder(v)
    return listaViewHolder
    }

    override fun getItemCount(): Int = regrasDesc.size

    override fun onBindViewHolder(holder: listaViewHolder, position: Int) {
        val regrasDesc = regrasDesc[position]
        holder.desc.text = regrasDesc.desc
        }

    }


