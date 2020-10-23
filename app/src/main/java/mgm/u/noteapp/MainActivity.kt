package mgm.u.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row_notes.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var noteList = mutableListOf<Note>()

        val adapter = NotesAdapter(noteList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonCreate.setOnClickListener {
            val title = editTitleNote.text.toString()
            val content = editContentNote.text.toString()
            val note = Note(title, content)
            noteList.add(note)
        }
    }
}