package com.stackroute.keepnote.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

@Entity
public class Note {

	@Id
	private Integer noteId;
	private String noteTitle;
	private String noteContent;
	private String noteStatus;
	private LocalDateTime createdAt;

	public Note() {
	}
	public Note(Integer noteId, String noteTitle, String noteContent, String noteStatus, LocalDateTime createdAt) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.createdAt = createdAt;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getNoteStatus() {
		return noteStatus;
	}
	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime localdatetime) {
		this.createdAt = localdatetime;
	}
	/* Override the toString() method */
	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteStatus="
				+ noteStatus + ", createdAt=" + createdAt + "]";
	}
}