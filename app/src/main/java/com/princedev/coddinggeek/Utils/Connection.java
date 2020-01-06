package com.princedev.coddinggeek.Utils;

public class Connection {

    public static NodeJsAPI getAPI(){
        return RetrofitClient.getInstance().create(NodeJsAPI.class);
    }
}
