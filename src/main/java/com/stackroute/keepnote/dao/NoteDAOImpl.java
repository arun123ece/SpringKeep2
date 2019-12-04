package com.stackroute.keepnote.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	SessionFactory sessionFactory;

	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		
		if(null == note || null == note.getNoteId()) {
			return false;
		}
		sessionFactory.getCurrentSession().save(note);
		return true;
	}
	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		
		//sessionFactory.getCurrentSession().delete(Integer.toString(noteId), Note.class);
		Note note = getNoteById(noteId);
		if(null == note) {
			return false;
		}
		sessionFactory.getCurrentSession().delete(note);
		return true;
	}
	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
		
		String hqlQuery = "FROM Note note order by note.createdAt DESC";
		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		List<Note> result = query.getResultList();
		return result;
	}
	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		
		return sessionFactory.getCurrentSession().get(Note.class, noteId);
	}
	/* Update existing note */

	public boolean UpdateNote(Note note) {
		
		if(null == note || null == note.getNoteId()) {
			return false;
		}
		sessionFactory.getCurrentSession().update(note);
		return true;
	}
}
