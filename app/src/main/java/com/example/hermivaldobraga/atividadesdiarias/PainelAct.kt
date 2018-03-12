package com.example.hermivaldobraga.atividadesdiarias

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.hermivaldobraga.atividadesdiarias.fragments.CadastroFragment
import com.example.hermivaldobraga.atividadesdiarias.fragments.ListaFragment
import kotlinx.android.synthetic.main.activity_painel.*

class PainelAct : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                changeFragment(ListaFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                changeFragment(CadastroFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    public fun changeFragment(fragment: Fragment){

        var transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.frameLayout, fragment)
        transition.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        Toast.makeText(this, "Novo texto", Toast.LENGTH_LONG).show()

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_painel)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        changeFragment(ListaFragment())
    }
}
