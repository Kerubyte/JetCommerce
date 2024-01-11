package com.kerubyte.jetcommerce.common.data

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.kerubyte.jetcommerce.common.domain.data.DatabaseInteractor
import javax.inject.Inject

class DatabaseInteractorImpl
@Inject
constructor(
    private val firestore: FirebaseFirestore
) : DatabaseInteractor {
    override suspend fun getWholeCollection(collection: String): Task<QuerySnapshot> {
        return firestore.collection(collection).get()
    }

    override suspend fun getSingleDocument(
        collection: String,
        documentUid: Int
    ): Task<DocumentSnapshot> {
        return firestore.collection(collection).document(documentUid.toString()).get()
    }

    override suspend fun getItemsFromCollection(
        collection: String,
        itemsUid: List<String>
    ): Task<QuerySnapshot> {
        TODO("Not yet implemented")
    }

    override suspend fun setDocumentInCollection(
        collection: String,
        documentUid: String,
        data: Any
    ): Task<Void> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFieldInDocument(
        collection: String,
        documentUid: String,
        itemUid: String
    ): Task<Void> {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFieldInDocument(
        collection: String,
        documentUid: String,
        itemUid: String
    ): Task<Void> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFieldInDocument(
        collection: String,
        documentUid: String
    ): Task<Void> {
        TODO("Not yet implemented")
    }

    override suspend fun updateDocument(
        collection: String,
        documentUid: String,
        data: Map<String, String>
    ): Task<Void> {
        TODO("Not yet implemented")
    }

    override suspend fun createDocumentInCollection(
        collection: String,
        documentUid: String,
        data: Map<String, Any>,
        customUid: String
    ): Task<Void> {
        TODO("Not yet implemented")
    }
}