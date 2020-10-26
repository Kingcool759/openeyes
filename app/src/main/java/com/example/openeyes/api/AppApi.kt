package com.example.openeyes.api

/**
 * @data on 2020/9/27 2:34 PM
 * @auther
 * @describe
 */
object AppApi {
     //基础URL
     const val BaseURL = "http://baobab.kaiyanapp.com/"

     //首页-发现
     const val home_faxian_List = "api/v7/index/tab/discovery?udid=e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&size=1080X2400&deviceModel=TEL-AN00a&first_channel=huawei&last_channel=huawei&system_version_code=29 HTTP/1.1"
     //首页-推荐
     const val home_tuijian_List = "api/v5/index/tab/feed?date=1603414800000&num=2&udid=e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&size=1080X2400&deviceModel=TEL-AN00a&first_channel=huawei&last_channel=huawei&system_version_code=29 HTTP/1.1"
     //首页-日报
     const val home_ribao_List = "api/v5/index/tab/feed?udid=e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&size=1080X2400&deviceModel=TEL-AN00a&first_channel=huawei&last_channel=huawei&system_version_code=29 HTTP/1.1"

     //社区-推荐
     const val shequ_tuijian_List = "api/v7/community/tab/rec?refreshCount=0&udid=e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&size=1080X2400&deviceModel=TEL-AN00a&first_channel=huawei&last_channel=huawei&system_version_code=29 HTTP/1.1"
     //社区-推荐
     const val shequ_guanzhu_List = "api/v6/community/tab/follow?start=10&num=10&newest=false&udid=e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&size=1080X2400&deviceModel=TEL-AN00a&first_channel=huawei&last_channel=huawei&system_version_code=29 HTTP/1.1"

     //通知-推送
     const val message_tuisong_List = "api/v3/messages?udid=e3baaab6f0484b5188ccc05cbec33ba51b92f208&vc=6030101&vn=6.3.10&size=1080X2400&deviceModel=TEL-AN00a&first_channel=huawei&last_channel=huawei&system_version_code=29 HTTP/1.1"
}