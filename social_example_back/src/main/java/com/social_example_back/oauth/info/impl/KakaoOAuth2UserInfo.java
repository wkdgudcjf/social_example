package com.social_example_back.oauth.info.impl;

import java.util.Map;

import com.social_example_back.oauth.info.OAuth2UserInfo;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getName() {
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        if (kakaoAccount == null) {
            return null;
        }
        
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");
        if (kakaoProfile == null) {
            return null;
        }

        return (String) kakaoProfile.get("nickname");
    }

    @Override
    public String getEmail() {
    	 Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
         if (kakaoAccount == null) {
             return null;
         }
                  
        return (String) kakaoAccount.get("email");
    }

    @Override
    public String getImageUrl() {
    	Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        if (kakaoAccount == null) {
            return null;
        }
        
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");
        if (kakaoProfile == null) {
            return null;
        }

        return (String) kakaoProfile.get("profile_image_url");
    }
}
