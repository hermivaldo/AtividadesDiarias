package com.example.hermivaldobraga.atividadesdiarias.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hermivaldobraga.atividadesdiarias.R
import com.example.hermivaldobraga.atividadesdiarias.listener.OnClickListener
import com.example.hermivaldobraga.atividadesdiarias.model.Nota

class LineAct(notas: List<Nota>, val onClick: OnClickListener) : RecyclerView.Adapter<LineAct.Line>(){

    private var notas: List<Nota>

    init {
        this.notas = notas

    }

    override fun getItemCount(): Int {
       return notas.size
    }

    override fun onBindViewHolder(holder: Line?, position: Int) {
        val nota = notas.get(position)
        holder!!.title.text = nota.nota
        holder!!.description.text = nota.description

        holder!!.itemView.setOnClickListener {
            onClick.click(position)
        }

    }

    fun getItem(position: Int): Nota {
        return this.notas[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Line {
        return Line(LayoutInflater.from(parent!!.context)
                .inflate(R.layout.layout_lista_atividades, parent, false))
    }


    class Line : RecyclerView.ViewHolder, View.OnClickListener {

        override fun onClick(v: View?) {
           /**/


        }

        lateinit var title: TextView
        lateinit var description: TextView

        constructor(itemView: View?) : super(itemView) {
            title = itemView!!.findViewById(R.id.tvNota)
            description = itemView!!.findViewById(R.id.tvDescription)

        }


    }

}

