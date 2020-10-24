package mgm.u.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CreateNoteActivity : MainActivity() {

    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        buttonCreate.setOnClickListener {
            val title = editTitleNote.text.toString()
            val content = editContentNote.text.toString()
            val creationDate = current.format(formatter)
            val note = Note(title, content, creationDate)
            noteList.add(note)
            transitionToMainActivity()
        }
    }

    private fun transitionToMainActivity() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}