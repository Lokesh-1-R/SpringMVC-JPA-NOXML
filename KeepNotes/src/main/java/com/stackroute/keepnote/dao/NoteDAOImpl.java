package com.stackroute.keepnote.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.keepnote.model.Note;

@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

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

	public boolean saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.save(note);
		session.flush();
		return true;

	}
	
	public boolean deleteNote(int noteId) {
		if(getNoteById(noteId)==null) {
			return false;
		}else {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getNoteById(noteId));
		session.flush();
		return true;

	}
	}
	public List<Note> getAllNotes() {
		String hqlQuery = "FROM Note note ORDER BY note.createdAt DESC";
		Query query = getSessionFactory().getCurrentSession().createQuery(hqlQuery);
		List result = query.getResultList();
		return result;
		

	}

		public Note getNoteById(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		Note note =session.get(Note.class, noteId);
		session.flush();
		return note;

	}
public boolean UpdateNote(Note note) {
		if(getNoteById(note.getNoteId())==null) {
			return false;
		}else {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().update(note);
		sessionFactory.getCurrentSession().flush();
		return true;
		}

	}

}
