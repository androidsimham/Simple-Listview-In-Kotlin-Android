package fingoshop.creo_tech.com.samplelistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var txt_name: Button
    lateinit var listview: ListView
    lateinit var edt_text: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_name = findViewById(R.id.textView)
        edt_text = findViewById(R.id.edt_text)
        listview = findViewById(R.id.listview)


        var array = arrayOf("fingoshop", "amezon", "flipcart", "shopcluses", "myntra")

        var stringArrayList = arrayListOf<String>()
        stringArrayList.addAll(array)


        listview.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArrayList)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArrayList)
        listview.setAdapter(adapter)

        txt_name.setOnClickListener({
            if (edt_text.text.toString().length != 0) {
                stringArrayList.add(edt_text.text.toString())
                adapter.notifyDataSetChanged()
            } else {
                edt_text.setError("Please Enter Correct Data")
            }
        })

        listview.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, "you clicked" + stringArrayList[i], Toast.LENGTH_LONG).show()
        }
    }
}
