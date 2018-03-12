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
import android.widget.Toast

import com.example.hermivaldobraga.atividadesdiarias.R
import com.example.hermivaldobraga.atividadesdiarias.adapter.LineAct
import com.example.hermivaldobraga.atividadesdiarias.listener.OnClickListener
import com.example.hermivaldobraga.atividadesdiarias.model.Nota
import com.labo.kaji.fragmentanimations.SidesAnimation


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
        adapter = LineAct(notas, onClick)
        recycle.adapter = adapter
        recycle.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }



    var onClick = object : OnClickListener {
        override fun click(position: Int) {

            val nota = adapter.getItem(position)
            val transition = fragmentManager.beginTransaction()

            val fragment = CadastroFragment()
            val bundle = Bundle()
            bundle.putString("tvNota", nota.nota)
            bundle.putString("txDescription", nota.description)
            fragment.arguments = bundle

            transition.replace(R.id.frameLayout, fragment)
            transition.commit()

        }

    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        return SidesAnimation.create(SidesAnimation.RIGHT, enter, 1000);
    }
}// Required empty public constructor
