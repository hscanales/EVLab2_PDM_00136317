package tech.visuallatam.evaluado2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tech.visuallatam.evaluado2.fragmentos.Botones
import tech.visuallatam.evaluado2.fragmentos.ContentFragment


class MainActivity() : AppCompatActivity(), Botones.OnSelectOption {

    var imagenes : ArrayList<Int> = ArrayList()
    var actual : Int? = null


    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                if (actual == R.drawable.a) {
                    R.drawable.c

                } else if(actual == R.drawable.b) {
                    R.drawable.a

                }else{
                    R.drawable.b
                }

            }
            2 -> {
                if (actual == R.drawable.a) {
                    R.drawable.b

                } else if(actual == R.drawable.b) {
                    R.drawable.c

                }else{
                    R.drawable.a
                }
            }

            else -> {
                imagenes.last()
            }
        }
        actual = content

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, ContentFragment.newInstance(content))
                .addToBackStack("Co")
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagenes.add(R.drawable.a)
        imagenes.add(R.drawable.b)
        imagenes.add(R.drawable.c)

        var barFragment = Botones.newInstace(
                "Op1",
                "Op2"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, barFragment)
                    .commit()
        }
    }
}
