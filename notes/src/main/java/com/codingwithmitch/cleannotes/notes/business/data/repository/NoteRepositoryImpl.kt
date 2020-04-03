package com.codingwithmitch.cleannotes.notes.business.data.repository

import com.codingwithmitch.cleannotes.notes.business.data.datasource.NoteCacheDataSource
import com.codingwithmitch.cleannotes.notes.business.domain.model.Note
import com.codingwithmitch.cleannotes.notes.business.domain.repository.NoteRepository
import com.codingwithmitch.cleannotes.core.di.scopes.FeatureScope
import javax.inject.Inject

@FeatureScope
class NoteRepositoryImpl
@Inject
constructor(
    private val noteCacheDataSource: NoteCacheDataSource
): NoteRepository{

    override suspend fun insertNewNote(title: String, body: String): Long {
        return noteCacheDataSource.insertNewNote(title, body)
    }

    override suspend fun deleteNote(primaryKey: Int): Int {
        return noteCacheDataSource.deleteNote(primaryKey)
    }

    override suspend fun updateNote(note: Note, newTitle: String?, newBody: String?): Int {
        return noteCacheDataSource.updateNote(note, newTitle, newBody)
    }

    override suspend fun searchNotes(
        query: String,
        filterAndOrder: String,
        page: Int
    ): List<Note> {
        return noteCacheDataSource.searchNotes(
            query = query,
            filterAndOrder = filterAndOrder,
            page = page
        )
    }


}
















