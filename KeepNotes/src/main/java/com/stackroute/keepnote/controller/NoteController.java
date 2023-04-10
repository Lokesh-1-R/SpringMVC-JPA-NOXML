package com.stackroute.keepnote.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.keepnote.dao.NoteDAO;
import com.stackroute.keepnote.model.Note;

@Controller
public class NoteController {

	@Autowired
	private NoteDAO dao;

	public NoteController(NoteDAO dao) {
		super();
		this.dao = dao;
	}


	@RequestMapping("/")
	public String getAllNotes(ModelMap modelMap) {
		modelMap.addAttribute("noteList", dao.getAllNotes());
		return "index";
	}

	
	@RequestMapping("/add")
	public String addNote(ModelMap modelMap, @RequestParam String noteTitle, @RequestParam String noteContent, @RequestParam String noteStatus) {
		
		if(noteTitle.isEmpty() || noteContent.isEmpty() || noteStatus.isEmpty()){
			modelMap.addAttribute("errorMessage", "Fields should not be empty");
			return "index";
		} else {
			Note note = new Note();
			note.setNoteTitle(noteTitle);
			note.setNoteContent(noteContent);
			note.setNoteStatus(noteStatus);
			note.setCreatedAt(LocalDateTime.now());
			dao.saveNote(note);
			modelMap.addAttribute("noteList", dao.getAllNotes());
			return "redirect:/";
		}
		
	}

	@RequestMapping("/delete")
	public String deleteNote(ModelMap modelMap, @RequestParam int noteId) {
		dao.deleteNote(noteId);
		modelMap.addAttribute("noteList", dao.getAllNotes());
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String updateNote(ModelMap modelMap, @RequestParam int noteId, @RequestParam String noteTitle, @RequestParam String noteContent, @RequestParam String noteStatus) {
		Note note = new Note();
		note.setNoteId(noteId);
		note.setNoteContent(noteContent);
		note.setNoteStatus(noteStatus);
		note.setNoteTitle(noteTitle);
		note.setCreatedAt(LocalDateTime.now());
		dao.UpdateNote(note);
		modelMap.addAttribute("noteList", dao.getAllNotes());
		return "redirect:/";
	}
	
	@RequestMapping("/updateNote")
	public String update(ModelMap modelMap,@RequestParam int noteId) {
		modelMap.addAttribute("note", dao.getNoteById(noteId));
		return "update";
		
	}
}