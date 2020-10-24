package mgm.u.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row_notes.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class MainActivity : AppCompatActivity() {

    var noteList = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = NotesAdapter(noteList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonAdd.setOnClickListener {
            intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        }
    }

}