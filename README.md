# 
#  <h1 align="center">🔥 ToDo App Firebase Sample</h1>

<p align="center">ToDo App Firebase Sample is a simple yet powerful task management application that demonstrates the implementation of Firebase libraries for authentication and other essential functionalities. This repository serves as a comprehensive guide for developers looking to integrate Firebase services into their own applications.</p><br>







#  <h2 align="center">🖼 Preview</h2>

![](https://github.com/betulnecanli/ToDoAppFirebaseSample/blob/master/ss/ezgif-5-ccb9e9e1a4.png?raw=true)  | ![](https://github.com/betulnecanli/ToDoAppFirebaseSample/blob/master/ss/ezgif-5-724855afcb.png?raw=true)  | ![](https://github.com/betulnecanli/ToDoAppFirebaseSample/blob/master/ss/ezgif-5-45ed006cac.png?raw=true)

<h2 align="center">Features⭐</h2>

- User Authentication: The app incorporates Firebase Authentication to enable secure user registration and login processes. It showcases various authentication methods such as email/password, Google sign-in, and more.
- Task Management: Users can create, edit, and delete tasks in the app. The app leverages Firebase Realtime Database or Cloud Firestore for real-time data synchronization across devices.



<h2 align="center">Architecture ☁</h2>

This app follows the MVVM (Model-View-ViewModel) architecture pattern. The components of the app are organized as follows:

- Model: The data source for the app is the PokeAPI, which provides information about Pokemon characters in JSON format. The app uses Retrofit to make network requests to the PokeAPI and Gson to deserialize the JSON responses into Java objects.

- View: The views in the app are implemented using Android's XML layout files. The main activity (MainActivity) contains a RecyclerView that displays a list of Pokemon characters, and a search bar that allows users to filter the list by name. Clicking on a character in the list navigates the user to the CharacterDetailActivity, which displays detailed information about the selected character.

- ViewModel: The CharacterViewModel class acts as an intermediary between the model and the view. It retrieves data from the model and exposes it to the view through observable data fields. It also provides methods for filtering the character list based on user input.


<h2 align="center">Getting Started 🚀</h2>

To run this app, you'll need to have Android Studio installed. Follow these steps to get started:

 - Clone this repository: git clone https://github.com/betulnecanli/ToDoAppFirebaseSample
 - Open the project in Android Studio.
 - Build and run the app.

<h2 align="center">📚 Tech Stack </h2>

- ViewBinding
- Firebase(Authentication, Storage)
- Navigation Components
- Flow
- Coroutines



# License
```xml
Designed and developed by 2023 Betül Necanlı 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


