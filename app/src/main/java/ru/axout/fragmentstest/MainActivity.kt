package ru.axout.fragmentstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import ru.axout.fragmentstest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(BlankFragment1.newInstance(), R.id.place_holder1)
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)

        // В observe() передаётся тот, за чьим ЖЦ нам нужно следить.
        // В данном случае это активити MainActivity, т.к. именно в нём находятся все фрагменты.
        // Поэтому передаём this.
        dataModel.messageForActivity.observe(this) {
            binding.textActivity.text = it
        }

        findViewById<Button>(R.id.bt_cancel).setOnClickListener {
            dataModel.messageForActivity.value = "Canceled"
            dataModel.messageForFrag1.value = "Canceled"
            dataModel.messageForFrag2.value = "Canceled"
        }
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}