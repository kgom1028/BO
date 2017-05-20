package com.kgom.binaryoptions.doc;

/**
 * Created by KJS on 9/7/2016.
 */
public class UserInfo {
    public static UserInfo _instance;
    public int selectedLanguage;
    public int selectedUrl; // 0:english,1:russian,2:french, 3:spanish 4:german
    public static UserInfo getInstance()
    {
        if(_instance == null)
        {
            _instance = new UserInfo();
        }
        return _instance;
    }

    public UserInfo()
    {
        selectedLanguage = 0;
        selectedUrl = 0;
    }



}
