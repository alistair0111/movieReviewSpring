package com.movieratings.movie.controller;



import com.gfg.imdbdemo.service.response.MovieResponse;
import com.movieratings.movie.service.AdminService;
import com.movieratings.movie.service.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest){

        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);
    }


}







/**

Person {

    name;
    age;
    email;
    phonenumber;
    ..

    Person(String name,int age...)

    1. create a new Person()
            p.setName();
            p.setAge();

   2. new Person(String name..)



 MobilePhone{

 String os;
 String modelNumber;

 }

 MobilePhoneBuilder{

   phone= new MobilePhone();
   public  withOS(MobilePhone phone,String Os)
 {
    phone.setOs(os);
 }

 public withModelNumber(MobilePhone phone,String modelNumber){
 phone.setModelNumber(modelNumber);
 }

 }

 new PhoneBuilder().withOs("android").withModelNumber("s20").withStylus("samsung pen");
 new PhoneBuilder().withOs("android").withModelNumber("s20").withRearCamera("40Mp");


}
*/




















