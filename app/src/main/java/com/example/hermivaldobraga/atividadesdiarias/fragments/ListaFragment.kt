package com.example.hermivaldobraga.atividadesdiarias.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation

import com.example.hermivaldobraga.atividadesdiarias.R
import com.example.hermivaldobraga.atividadesdiarias.adapter.LineAct
import com.example.hermivaldobraga.atividadesdiarias.model.Nota
import com.labo.kaji.fragmentanimations.CubeAnimation
import com.labo.kaji.fragmentanimations.SidesAnimation
import kotlinx.android.synthetic.main.fragment_lista.*


/**
 * A simple [Fragment] subclass.
 */
class ListaFragment : Fragment() {


    lateinit var recycle: RecyclerView
    lateinit var adapter: LineAct


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val inflate = inflater!!.inflate(R.layout.fragment_lista, container, false)
        recycle = inflate.findViewById(R.id.rcListActivity)
        setupReciclyView()
        return inflate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        setRetainInstance(true)


    }

    fun setupReciclyView(){
        recycle.layoutManager = LinearLayoutManager(context)
        var nota = Nota("Primeira nota de teste","Apenas um texto qualquer")
        var notas = ArrayList<Nota>()
        notas.add(nota)
        adapter = LineAct(notas)
        recycle.adapter = adapter

        recycle.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


    }




    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        return SidesAnimation.create(SidesAnimation.RIGHT, enter, 1000);
    }
}// Required empty public constructor
