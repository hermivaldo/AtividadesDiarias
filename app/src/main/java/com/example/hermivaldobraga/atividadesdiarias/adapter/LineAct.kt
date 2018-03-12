package com.example.hermivaldobraga.atividadesdiarias.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hermivaldobraga.atividadesdiarias.R
import com.example.hermivaldobraga.atividadesdiarias.fragments.CadastroFragment
import com.example.hermivaldobraga.atividadesdiarias.fragments.ListaFragment
import com.example.hermivaldobraga.atividadesdiarias.model.Nota


/**
 * Created by hermivaldobraga on 12/03/2018.
 */
class LineAct(notas: List<Nota>, listaFragment: ListaFragment) : RecyclerView.Adapter<LineAct.Line>(){

    private var notas: List<Nota>
    private var listaFragment: ListaFragment
    init {
        this.listaFragment = listaFragment
        this.notas = notas
    }

    override fun getItemCount(): Int {
       return notas.size
    }

    override fun onBindViewHolder(holder: Line?, position: Int) {
        val nota = notas.get(position)
        holder!!.title.text = nota.nota
        holder!!.description.text = nota.description

    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Line {
        return Line(LayoutInflater.from(parent!!.context)
                .inflate(R.layout.layout_lista_atividades, parent, false), listaFragment)
    }


    class Line : RecyclerView.ViewHolder, View.OnClickListener {

        override fun onClick(v: View?) {
            val textViewNota = v!!.findViewById<TextView>(R.id.tvNota)
            val textViewDescription = v!!.findViewById<TextView>(R.id.tvDescription)

            val transition = this.listaFragment.fragmentManager.beginTransaction()

            val fragment = CadastroFragment()
            val bundle = Bundle()
            bundle.putString("tvNota", textViewNota.text.toString())
            bundle.putString("txDescription", textViewDescription.text.toString())
            fragment.arguments = bundle
            transition.replace(R.id.frameLayout, fragment)
            transition.commit()
        }

        lateinit var title: TextView
        lateinit var description: TextView
        lateinit var listaFragment: ListaFragment

        constructor(itemView: View?, listaFragment: ListaFragment) : super(itemView) {
            title = itemView!!.findViewById(R.id.tvNota)
            description = itemView!!.findViewById(R.id.tvDescription)
            this.listaFragment = listaFragment
            itemView.setOnClickListener(this)
        }


    }

}

