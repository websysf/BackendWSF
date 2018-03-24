package com.websysf.api;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@WebServlet(
    name = "Firebase",
    urlPatterns = {"/firebase"}
)
public class Firebase extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello Firebase!\r\n");
    
    
    
    
    FileInputStream serviceAccount =
    		  new FileInputStream("path/to/serviceAccountKey.json");

    		FirebaseOptions options = new FirebaseOptions.Builder()
    		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    		  .setDatabaseUrl("https://backendwsfb.firebaseio.com")
    		  .build();

    		FirebaseApp.initializeApp(options);
    

  }
}