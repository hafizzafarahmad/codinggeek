package com.princedev.coddinggeek.Utils;

import com.princedev.coddinggeek.Model.Language;
import com.princedev.coddinggeek.Model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NodeJsAPI {

    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(@Field("email") String email,
                                  @Field("name") String name,
                                  @Field("password") String password,
                                  @Field("gender") String gender,
                                  @Field("country") String country,
                                  @Field("occupation") String occupation,
                                  @Field("bod") String bod);


    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email") String email,
                                 @Field("password") String password);

    @GET("language")
    Observable<List<Language>> getDataLanguage();

}
