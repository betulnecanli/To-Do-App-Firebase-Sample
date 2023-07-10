package com.betulnecanli.todoappfirebasesample.scenes.main.personal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class PersonalViewModel : ViewModel(){

    private val storageRef: StorageReference = FirebaseStorage.getInstance().reference

    fun uploadImage(imageName: String, imageBytes: ByteArray) {
        val imageRef = storageRef.child("profile_images/$imageName")
        val uploadTask: UploadTask = imageRef.putBytes(imageBytes)

        uploadTask.addOnSuccessListener {
            // Image upload successful

        }.addOnFailureListener {
            // Image upload failed
            // Do something, e.g., show an error message
        }
    }
}