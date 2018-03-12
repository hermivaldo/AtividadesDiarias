package com.example.hermivaldobraga.atividadesdiarias.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.view.animation.Animation

import com.example.hermivaldobraga.atividadesdiarias.R
import com.labo.kaji.fragmentanimations.CubeAnimation
import com.labo.kaji.fragmentanimations.SidesAnimation


/**
 * A simple [Fragment] subclass.
 */
class CadastroFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        setRetainInstance(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_cadastro, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        return SidesAnimation.create(SidesAnimation.RIGHT, enter, 1000);
    }

}// Required empty public constructor
