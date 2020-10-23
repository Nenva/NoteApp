package mgm.u.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val creationDate = current.format(formatter)
            val note = Note(title, content, creationDate)
            noteList.add(note)
        }
    }
}