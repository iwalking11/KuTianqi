package com.gaopinwei.kutianqi.request.entitys;

import java.util.List;

/**
 * 天气信息实体类
 *
 */
public class WeatherEntity {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"cityInfo":{"c1":"101120401","c10":"2","c11":"0534","c12":"253000","c15":"23","c16":"AZ9531","c17":"+8","c2":"dezhou","c3":"德州","c4":"dezhou","c5":"德州","c6":"shandong","c7":"山东","c8":"china","c9":"中国","latitude":37.446,"longitude":116.279},"f1":{"air_press":"1028 hPa","alarmList":[{"city":"","issueContent":"继续发布霾黄色预警信号:目前，鲁西北、鲁中和鲁南地区已出现中度以上霾天气，其中德州、聊城、济南、莱芜、淄博和菏泽6市已达到重度霾，部分地区能见度低于1000米。预计今天白天到明天，上述地区中度以上的霾天气仍将持续。为此，山东省气象台于11月11日06时00分继续发布霾黄色 预警信号。\r\n","issueTime":"2015-11-11 06:00:00","province":"山东省","signalLevel":"黄色","signalType":"霾"}],"day":"20151111","day_air_temperature":"9","day_weather":"阴","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","day_wind_direction":"东风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天阴沉，有点凉。","title":"较舒适"},"glass":{"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"推荐您在室内进行低强度运动。","title":"较不宜"},"travel":{"desc":"气温稍低感觉略凉，不过也是个好天气。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}},"jiangshui":"25%","night_air_temperature":"4","night_weather":"多云","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"东北风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"01","weekday":3,"ziwaixian":"最弱"},"f2":{"day":"20151112","day_air_temperature":"10","day_weather":"多云","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","day_wind_direction":"东风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天晴，早晚偏凉，午后舒适。","title":"较舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"气温较低，推荐您进行室内运动。","title":"较适宜"},"travel":{"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}},"night_air_temperature":"6","night_weather":"阴","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"东风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"02","weekday":4},"f3":{"day":"20151113","day_air_temperature":"10","day_weather":"小雨","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","day_wind_direction":"东风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天降雨，有些凉意。","title":"较舒适"},"glass":{"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"},"travel":{"desc":"较弱降水和微风将伴您共赴旅程。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}},"night_air_temperature":"4","night_weather":"多云","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"北风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"01","weekday":5},"f4":{"day":"20151114","day_air_temperature":"10","day_weather":"多云","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","day_wind_direction":"南风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天不冷不热，风力不大。","title":"舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"温较低，推荐您进行室内运动。","title":"较适宜"},"travel":{"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}},"night_air_temperature":"6","night_weather":"多云","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"南风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"01","weekday":6},"f5":{"day":"20151115","day_air_temperature":"10","day_weather":"阴","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","day_wind_direction":"南风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天阴沉，有点凉。","title":"较舒适"},"glass":{"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"推荐您在室内进行低强度运动。","title":"较不宜"},"travel":{"desc":"温度适宜，可尽情享受大自然风光。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}},"night_air_temperature":"6","night_weather":"小雨","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"南风","night_wind_power":"3-4级10~17m/h","sun_begin_end":"06:49|17:08","weather_code":"07","weekday":7},"f6":{"day":"20151116","day_air_temperature":"11","day_weather":"小雨","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","day_wind_direction":"北风","day_wind_power":"3-4级10~17m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天降雨，有些凉意。","title":"较舒适"},"glass":{"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"},"travel":{"desc":"有降水，温度适宜，不要错过出游机会。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}},"night_air_temperature":"5","night_weather":"阴","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"东北风","night_wind_power":"3-4级10~17m/h","sun_begin_end":"06:49|17:08","weather_code":"02","weekday":1},"f7":{"day":"20151117","day_air_temperature":"12","day_weather":"多云","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","day_wind_direction":"东北风","day_wind_power":"3-4级10~17m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"感冒机率较低，避免长期处于空调屋中。","title":"少发"},"comfort":{"desc":"晴，炎热，酷暑难耐。","title":"极不舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"请减少运动时间并降低运动强度。","title":"较不宜"},"travel":{"desc":"温度很高，有风，建议选择水上活动。","title":"较不宜"},"uv":{"desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。","title":"弱"}},"night_air_temperature":"5","night_weather":"小雨","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"东北风","night_wind_power":"3-4级10~17m/h","sun_begin_end":"06:49|17:08","weather_code":"07","weekday":2},"now":{"aqi":250,"aqiDetail":{"aqi":250,"area":"德州","area_code":"dezhou","co":3.14,"no2":63,"o3":1,"o3_8h":1,"pm10":260,"pm2_5":199,"primary_pollutant":"颗粒物(PM2.5)","quality":"重度污染","so2":127},"sd":"85%","temperature":"6","temperature_time":"08:12","weather":"多云","weather_code":"01","weather_pic":"http://appimg.showapi.com/images/weather/icon/night/01.png","wind_direction":"北风","wind_power":"0级"},"ret_code":0,"time":"20151111080000"}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * cityInfo : {"c1":"101120401","c10":"2","c11":"0534","c12":"253000","c15":"23","c16":"AZ9531","c17":"+8","c2":"dezhou","c3":"德州","c4":"dezhou","c5":"德州","c6":"shandong","c7":"山东","c8":"china","c9":"中国","latitude":37.446,"longitude":116.279}
     * f1 : {"air_press":"1028 hPa","alarmList":[{"city":"","issueContent":"继续发布霾黄色预警信号:目前，鲁西北、鲁中和鲁南地区已出现中度以上霾天气，其中德州、聊城、济南、莱芜、淄博和菏泽6市已达到重度霾，部分地区能见度低于1000米。预计今天白天到明天，上述地区中度以上的霾天气仍将持续。为此，山东省气象台于11月11日06时00分继续发布霾黄色 预警信号。\r\n","issueTime":"2015-11-11 06:00:00","province":"山东省","signalLevel":"黄色","signalType":"霾"}],"day":"20151111","day_air_temperature":"9","day_weather":"阴","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","day_wind_direction":"东风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天阴沉，有点凉。","title":"较舒适"},"glass":{"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"推荐您在室内进行低强度运动。","title":"较不宜"},"travel":{"desc":"气温稍低感觉略凉，不过也是个好天气。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}},"jiangshui":"25%","night_air_temperature":"4","night_weather":"多云","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"东北风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"01","weekday":3,"ziwaixian":"最弱"}
     * f2 : {"day":"20151112","day_air_temperature":"10","day_weather":"多云","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","day_wind_direction":"东风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天晴，早晚偏凉，午后舒适。","title":"较舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"气温较低，推荐您进行室内运动。","title":"较适宜"},"travel":{"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}},"night_air_temperature":"6","night_weather":"阴","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"东风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"02","weekday":4}
     * f3 : {"day":"20151113","day_air_temperature":"10","day_weather":"小雨","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","day_wind_direction":"东风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天降雨，有些凉意。","title":"较舒适"},"glass":{"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"},"travel":{"desc":"较弱降水和微风将伴您共赴旅程。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}},"night_air_temperature":"4","night_weather":"多云","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"北风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"01","weekday":5}
     * f4 : {"day":"20151114","day_air_temperature":"10","day_weather":"多云","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","day_wind_direction":"南风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天不冷不热，风力不大。","title":"舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"温较低，推荐您进行室内运动。","title":"较适宜"},"travel":{"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}},"night_air_temperature":"6","night_weather":"多云","night_weather_pic":"http://app1.showapi.com/weather/icon/night/01.png","night_wind_direction":"南风","night_wind_power":"微风<10m/h","sun_begin_end":"06:49|17:08","weather_code":"01","weekday":6}
     * f5 : {"day":"20151115","day_air_temperature":"10","day_weather":"阴","day_weather_pic":"http://app1.showapi.com/weather/icon/day/02.png","day_wind_direction":"南风","day_wind_power":"微风<10m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天阴沉，有点凉。","title":"较舒适"},"glass":{"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"推荐您在室内进行低强度运动。","title":"较不宜"},"travel":{"desc":"温度适宜，可尽情享受大自然风光。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}},"night_air_temperature":"6","night_weather":"小雨","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"南风","night_wind_power":"3-4级10~17m/h","sun_begin_end":"06:49|17:08","weather_code":"07","weekday":7}
     * f6 : {"day":"20151116","day_air_temperature":"11","day_weather":"小雨","day_weather_pic":"http://app1.showapi.com/weather/icon/day/07.png","day_wind_direction":"北风","day_wind_power":"3-4级10~17m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天降雨，有些凉意。","title":"较舒适"},"glass":{"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"},"travel":{"desc":"有降水，温度适宜，不要错过出游机会。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}},"night_air_temperature":"5","night_weather":"阴","night_weather_pic":"http://app1.showapi.com/weather/icon/night/02.png","night_wind_direction":"东北风","night_wind_power":"3-4级10~17m/h","sun_begin_end":"06:49|17:08","weather_code":"02","weekday":1}
     * f7 : {"day":"20151117","day_air_temperature":"12","day_weather":"多云","day_weather_pic":"http://app1.showapi.com/weather/icon/day/01.png","day_wind_direction":"东北风","day_wind_power":"3-4级10~17m/h","index":{"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"感冒机率较低，避免长期处于空调屋中。","title":"少发"},"comfort":{"desc":"晴，炎热，酷暑难耐。","title":"极不舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"请减少运动时间并降低运动强度。","title":"较不宜"},"travel":{"desc":"温度很高，有风，建议选择水上活动。","title":"较不宜"},"uv":{"desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。","title":"弱"}},"night_air_temperature":"5","night_weather":"小雨","night_weather_pic":"http://app1.showapi.com/weather/icon/night/07.png","night_wind_direction":"东北风","night_wind_power":"3-4级10~17m/h","sun_begin_end":"06:49|17:08","weather_code":"07","weekday":2}
     * now : {"aqi":250,"aqiDetail":{"aqi":250,"area":"德州","area_code":"dezhou","co":3.14,"no2":63,"o3":1,"o3_8h":1,"pm10":260,"pm2_5":199,"primary_pollutant":"颗粒物(PM2.5)","quality":"重度污染","so2":127},"sd":"85%","temperature":"6","temperature_time":"08:12","weather":"多云","weather_code":"01","weather_pic":"http://appimg.showapi.com/images/weather/icon/night/01.png","wind_direction":"北风","wind_power":"0级"}
     * ret_code : 0
     * time : 20151111080000
     */

    private ShowapiResBodyEntity showapi_res_body;

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public void setShowapi_res_body(ShowapiResBodyEntity showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public ShowapiResBodyEntity getShowapi_res_body() {
        return showapi_res_body;
    }

    public static class ShowapiResBodyEntity {
        /**
         * c1 : 101120401
         * c10 : 2
         * c11 : 0534
         * c12 : 253000
         * c15 : 23
         * c16 : AZ9531
         * c17 : +8
         * c2 : dezhou
         * c3 : 德州
         * c4 : dezhou
         * c5 : 德州
         * c6 : shandong
         * c7 : 山东
         * c8 : china
         * c9 : 中国
         * latitude : 37.446
         * longitude : 116.279
         */

        private CityInfoEntity cityInfo;
        /**
         * air_press : 1028 hPa
         * alarmList : [{"city":"","issueContent":"继续发布霾黄色预警信号:目前，鲁西北、鲁中和鲁南地区已出现中度以上霾天气，其中德州、聊城、济南、莱芜、淄博和菏泽6市已达到重度霾，部分地区能见度低于1000米。预计今天白天到明天，上述地区中度以上的霾天气仍将持续。为此，山东省气象台于11月11日06时00分继续发布霾黄色 预警信号。\r\n","issueTime":"2015-11-11 06:00:00","province":"山东省","signalLevel":"黄色","signalType":"霾"}]
         * day : 20151111
         * day_air_temperature : 9
         * day_weather : 阴
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/02.png
         * day_wind_direction : 东风
         * day_wind_power : 微风<10m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天阴沉，有点凉。","title":"较舒适"},"glass":{"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"推荐您在室内进行低强度运动。","title":"较不宜"},"travel":{"desc":"气温稍低感觉略凉，不过也是个好天气。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}}
         * jiangshui : 25%
         * night_air_temperature : 4
         * night_weather : 多云
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/01.png
         * night_wind_direction : 东北风
         * night_wind_power : 微风<10m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 01
         * weekday : 3
         * ziwaixian : 最弱
         */

        private F1Entity f1;
        /**
         * day : 20151112
         * day_air_temperature : 10
         * day_weather : 多云
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/01.png
         * day_wind_direction : 东风
         * day_wind_power : 微风<10m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天晴，早晚偏凉，午后舒适。","title":"较舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"气温较低，推荐您进行室内运动。","title":"较适宜"},"travel":{"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}}
         * night_air_temperature : 6
         * night_weather : 阴
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/02.png
         * night_wind_direction : 东风
         * night_wind_power : 微风<10m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 02
         * weekday : 4
         */

        private F2Entity f2;
        /**
         * day : 20151113
         * day_air_temperature : 10
         * day_weather : 小雨
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
         * day_wind_direction : 东风
         * day_wind_power : 微风<10m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天降雨，有些凉意。","title":"较舒适"},"glass":{"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"},"travel":{"desc":"较弱降水和微风将伴您共赴旅程。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}}
         * night_air_temperature : 4
         * night_weather : 多云
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/01.png
         * night_wind_direction : 北风
         * night_wind_power : 微风<10m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 01
         * weekday : 5
         */

        private F3Entity f3;
        /**
         * day : 20151114
         * day_air_temperature : 10
         * day_weather : 多云
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/01.png
         * day_wind_direction : 南风
         * day_wind_power : 微风<10m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天不冷不热，风力不大。","title":"舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"温较低，推荐您进行室内运动。","title":"较适宜"},"travel":{"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}}
         * night_air_temperature : 6
         * night_weather : 多云
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/01.png
         * night_wind_direction : 南风
         * night_wind_power : 微风<10m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 01
         * weekday : 6
         */

        private F4Entity f4;
        /**
         * day : 20151115
         * day_air_temperature : 10
         * day_weather : 阴
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/02.png
         * day_wind_direction : 南风
         * day_wind_power : 微风<10m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天阴沉，有点凉。","title":"较舒适"},"glass":{"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"推荐您在室内进行低强度运动。","title":"较不宜"},"travel":{"desc":"温度适宜，可尽情享受大自然风光。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}}
         * night_air_temperature : 6
         * night_weather : 小雨
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/07.png
         * night_wind_direction : 南风
         * night_wind_power : 3-4级10~17m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 07
         * weekday : 7
         */

        private F5Entity f5;
        /**
         * day : 20151116
         * day_air_temperature : 11
         * day_weather : 小雨
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/07.png
         * day_wind_direction : 北风
         * day_wind_power : 3-4级10~17m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"天较凉，增加衣服，注意防护。","title":"较易发"},"comfort":{"desc":"白天降雨，有些凉意。","title":"较舒适"},"glass":{"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"},"sports":{"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"},"travel":{"desc":"有降水，温度适宜，不要错过出游机会。","title":"适宜"},"uv":{"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"},"wash_car":{"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}}
         * night_air_temperature : 5
         * night_weather : 阴
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/02.png
         * night_wind_direction : 东北风
         * night_wind_power : 3-4级10~17m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 02
         * weekday : 1
         */

        private F6Entity f6;
        /**
         * day : 20151117
         * day_air_temperature : 12
         * day_weather : 多云
         * day_weather_pic : http://app1.showapi.com/weather/icon/day/01.png
         * day_wind_direction : 东北风
         * day_wind_power : 3-4级10~17m/h
         * index : {"beauty":{"desc":"请选用保湿型霜类化妆品。","title":"保湿"},"clothes":{"desc":"建议着厚外套加毛衣等服装。","title":"较冷"},"cold":{"desc":"感冒机率较低，避免长期处于空调屋中。","title":"少发"},"comfort":{"desc":"晴，炎热，酷暑难耐。","title":"极不舒适"},"glass":{"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"},"sports":{"desc":"请减少运动时间并降低运动强度。","title":"较不宜"},"travel":{"desc":"温度很高，有风，建议选择水上活动。","title":"较不宜"},"uv":{"desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。","title":"弱"}}
         * night_air_temperature : 5
         * night_weather : 小雨
         * night_weather_pic : http://app1.showapi.com/weather/icon/night/07.png
         * night_wind_direction : 东北风
         * night_wind_power : 3-4级10~17m/h
         * sun_begin_end : 06:49|17:08
         * weather_code : 07
         * weekday : 2
         */

        private F7Entity f7;
        /**
         * aqi : 250
         * aqiDetail : {"aqi":250,"area":"德州","area_code":"dezhou","co":3.14,"no2":63,"o3":1,"o3_8h":1,"pm10":260,"pm2_5":199,"primary_pollutant":"颗粒物(PM2.5)","quality":"重度污染","so2":127}
         * sd : 85%
         * temperature : 6
         * temperature_time : 08:12
         * weather : 多云
         * weather_code : 01
         * weather_pic : http://appimg.showapi.com/images/weather/icon/night/01.png
         * wind_direction : 北风
         * wind_power : 0级
         */

        private NowEntity now;
        private int ret_code;
        private String time;

        public void setCityInfo(CityInfoEntity cityInfo) {
            this.cityInfo = cityInfo;
        }

        public void setF1(F1Entity f1) {
            this.f1 = f1;
        }

        public void setF2(F2Entity f2) {
            this.f2 = f2;
        }

        public void setF3(F3Entity f3) {
            this.f3 = f3;
        }

        public void setF4(F4Entity f4) {
            this.f4 = f4;
        }

        public void setF5(F5Entity f5) {
            this.f5 = f5;
        }

        public void setF6(F6Entity f6) {
            this.f6 = f6;
        }

        public void setF7(F7Entity f7) {
            this.f7 = f7;
        }

        public void setNow(NowEntity now) {
            this.now = now;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public CityInfoEntity getCityInfo() {
            return cityInfo;
        }

        public F1Entity getF1() {
            return f1;
        }

        public F2Entity getF2() {
            return f2;
        }

        public F3Entity getF3() {
            return f3;
        }

        public F4Entity getF4() {
            return f4;
        }

        public F5Entity getF5() {
            return f5;
        }

        public F6Entity getF6() {
            return f6;
        }

        public F7Entity getF7() {
            return f7;
        }

        public NowEntity getNow() {
            return now;
        }

        public int getRet_code() {
            return ret_code;
        }

        public String getTime() {
            return time;
        }

        public static class CityInfoEntity {
            private String c1;
            private String c10;
            private String c11;
            private String c12;
            private String c15;
            private String c16;
            private String c17;
            private String c2;
            private String c3;
            private String c4;
            private String c5;
            private String c6;
            private String c7;
            private String c8;
            private String c9;
            private double latitude;
            private double longitude;

            public void setC1(String c1) {
                this.c1 = c1;
            }

            public void setC10(String c10) {
                this.c10 = c10;
            }

            public void setC11(String c11) {
                this.c11 = c11;
            }

            public void setC12(String c12) {
                this.c12 = c12;
            }

            public void setC15(String c15) {
                this.c15 = c15;
            }

            public void setC16(String c16) {
                this.c16 = c16;
            }

            public void setC17(String c17) {
                this.c17 = c17;
            }

            public void setC2(String c2) {
                this.c2 = c2;
            }

            public void setC3(String c3) {
                this.c3 = c3;
            }

            public void setC4(String c4) {
                this.c4 = c4;
            }

            public void setC5(String c5) {
                this.c5 = c5;
            }

            public void setC6(String c6) {
                this.c6 = c6;
            }

            public void setC7(String c7) {
                this.c7 = c7;
            }

            public void setC8(String c8) {
                this.c8 = c8;
            }

            public void setC9(String c9) {
                this.c9 = c9;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getC1() {
                return c1;
            }

            public String getC10() {
                return c10;
            }

            public String getC11() {
                return c11;
            }

            public String getC12() {
                return c12;
            }

            public String getC15() {
                return c15;
            }

            public String getC16() {
                return c16;
            }

            public String getC17() {
                return c17;
            }

            public String getC2() {
                return c2;
            }

            public String getC3() {
                return c3;
            }

            public String getC4() {
                return c4;
            }

            public String getC5() {
                return c5;
            }

            public String getC6() {
                return c6;
            }

            public String getC7() {
                return c7;
            }

            public String getC8() {
                return c8;
            }

            public String getC9() {
                return c9;
            }

            public double getLatitude() {
                return latitude;
            }

            public double getLongitude() {
                return longitude;
            }
        }

        public static class F1Entity {
            private String air_press;
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"天较凉，增加衣服，注意防护。","title":"较易发"}
             * comfort : {"desc":"白天阴沉，有点凉。","title":"较舒适"}
             * glass : {"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"}
             * sports : {"desc":"推荐您在室内进行低强度运动。","title":"较不宜"}
             * travel : {"desc":"气温稍低感觉略凉，不过也是个好天气。","title":"适宜"}
             * uv : {"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"}
             * wash_car : {"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}
             */

            private IndexEntity index;
            private String jiangshui;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;
            private String ziwaixian;
            /**
             * city :
             * issueContent : 继续发布霾黄色预警信号:目前，鲁西北、鲁中和鲁南地区已出现中度以上霾天气，其中德州、聊城、济南、莱芜、淄博和菏泽6市已达到重度霾，部分地区能见度低于1000米。预计今天白天到明天，上述地区中度以上的霾天气仍将持续。为此，山东省气象台于11月11日06时00分继续发布霾黄色 预警信号。

             * issueTime : 2015-11-11 06:00:00
             * province : 山东省
             * signalLevel : 黄色
             * signalType : 霾
             */

            private List<AlarmListEntity> alarmList;

            public void setAir_press(String air_press) {
                this.air_press = air_press;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setJiangshui(String jiangshui) {
                this.jiangshui = jiangshui;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public void setZiwaixian(String ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public void setAlarmList(List<AlarmListEntity> alarmList) {
                this.alarmList = alarmList;
            }

            public String getAir_press() {
                return air_press;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getJiangshui() {
                return jiangshui;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public String getZiwaixian() {
                return ziwaixian;
            }

            public List<AlarmListEntity> getAlarmList() {
                return alarmList;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 天较凉，增加衣服，注意防护。
                 * title : 较易发
                 */

                private ColdEntity cold;
                /**
                 * desc : 白天阴沉，有点凉。
                 * title : 较舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天光线弱不需要佩戴太阳镜
                 * title : 不需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 推荐您在室内进行低强度运动。
                 * title : 较不宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 气温稍低感觉略凉，不过也是个好天气。
                 * title : 适宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                 * title : 最弱
                 */

                private UvEntity uv;
                /**
                 * desc : 无雨且风力较小，易保持清洁度。
                 * title : 较适宜
                 */

                private WashCarEntity wash_car;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public void setWash_car(WashCarEntity wash_car) {
                    this.wash_car = wash_car;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public WashCarEntity getWash_car() {
                    return wash_car;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class WashCarEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }

            public static class AlarmListEntity {
                private String city;
                private String issueContent;
                private String issueTime;
                private String province;
                private String signalLevel;
                private String signalType;

                public void setCity(String city) {
                    this.city = city;
                }

                public void setIssueContent(String issueContent) {
                    this.issueContent = issueContent;
                }

                public void setIssueTime(String issueTime) {
                    this.issueTime = issueTime;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public void setSignalLevel(String signalLevel) {
                    this.signalLevel = signalLevel;
                }

                public void setSignalType(String signalType) {
                    this.signalType = signalType;
                }

                public String getCity() {
                    return city;
                }

                public String getIssueContent() {
                    return issueContent;
                }

                public String getIssueTime() {
                    return issueTime;
                }

                public String getProvince() {
                    return province;
                }

                public String getSignalLevel() {
                    return signalLevel;
                }

                public String getSignalType() {
                    return signalType;
                }
            }
        }

        public static class F2Entity {
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"天较凉，增加衣服，注意防护。","title":"较易发"}
             * comfort : {"desc":"白天晴，早晚偏凉，午后舒适。","title":"较舒适"}
             * glass : {"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"}
             * sports : {"desc":"气温较低，推荐您进行室内运动。","title":"较适宜"}
             * travel : {"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"}
             * uv : {"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"}
             * wash_car : {"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}
             */

            private IndexEntity index;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 天较凉，增加衣服，注意防护。
                 * title : 较易发
                 */

                private ColdEntity cold;
                /**
                 * desc : 白天晴，早晚偏凉，午后舒适。
                 * title : 较舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天根据户外光线情况佩戴太阳镜
                 * title : 需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 气温较低，推荐您进行室内运动。
                 * title : 较适宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 天气较好，丝毫不会影响您出行的心情。
                 * title : 适宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                 * title : 最弱
                 */

                private UvEntity uv;
                /**
                 * desc : 无雨且风力较小，易保持清洁度。
                 * title : 较适宜
                 */

                private WashCarEntity wash_car;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public void setWash_car(WashCarEntity wash_car) {
                    this.wash_car = wash_car;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public WashCarEntity getWash_car() {
                    return wash_car;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class WashCarEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }
        }

        public static class F3Entity {
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"天较凉，增加衣服，注意防护。","title":"较易发"}
             * comfort : {"desc":"白天降雨，有些凉意。","title":"较舒适"}
             * glass : {"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"}
             * sports : {"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"}
             * travel : {"desc":"较弱降水和微风将伴您共赴旅程。","title":"适宜"}
             * uv : {"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"}
             * wash_car : {"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}
             */

            private IndexEntity index;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 天较凉，增加衣服，注意防护。
                 * title : 较易发
                 */

                private ColdEntity cold;
                /**
                 * desc : 白天降雨，有些凉意。
                 * title : 较舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天能见度差不需要佩戴太阳镜
                 * title : 不需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 有降水，推荐您在室内进行休闲运动。
                 * title : 较不宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 较弱降水和微风将伴您共赴旅程。
                 * title : 适宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                 * title : 最弱
                 */

                private UvEntity uv;
                /**
                 * desc : 有雨，雨水和泥水会弄脏爱车。
                 * title : 不宜
                 */

                private WashCarEntity wash_car;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public void setWash_car(WashCarEntity wash_car) {
                    this.wash_car = wash_car;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public WashCarEntity getWash_car() {
                    return wash_car;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class WashCarEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }
        }

        public static class F4Entity {
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"天较凉，增加衣服，注意防护。","title":"较易发"}
             * comfort : {"desc":"白天不冷不热，风力不大。","title":"舒适"}
             * glass : {"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"}
             * sports : {"desc":"温较低，推荐您进行室内运动。","title":"较适宜"}
             * travel : {"desc":"天气较好，丝毫不会影响您出行的心情。","title":"适宜"}
             * uv : {"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"}
             * wash_car : {"desc":"无雨且风力较小，易保持清洁度。","title":"较适宜"}
             */

            private IndexEntity index;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 天较凉，增加衣服，注意防护。
                 * title : 较易发
                 */

                private ColdEntity cold;
                /**
                 * desc : 白天不冷不热，风力不大。
                 * title : 舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天根据户外光线情况佩戴太阳镜
                 * title : 需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 温较低，推荐您进行室内运动。
                 * title : 较适宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 天气较好，丝毫不会影响您出行的心情。
                 * title : 适宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                 * title : 最弱
                 */

                private UvEntity uv;
                /**
                 * desc : 无雨且风力较小，易保持清洁度。
                 * title : 较适宜
                 */

                private WashCarEntity wash_car;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public void setWash_car(WashCarEntity wash_car) {
                    this.wash_car = wash_car;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public WashCarEntity getWash_car() {
                    return wash_car;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class WashCarEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }
        }

        public static class F5Entity {
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"天较凉，增加衣服，注意防护。","title":"较易发"}
             * comfort : {"desc":"白天阴沉，有点凉。","title":"较舒适"}
             * glass : {"desc":"白天光线弱不需要佩戴太阳镜","title":"不需要"}
             * sports : {"desc":"推荐您在室内进行低强度运动。","title":"较不宜"}
             * travel : {"desc":"温度适宜，可尽情享受大自然风光。","title":"适宜"}
             * uv : {"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"}
             * wash_car : {"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}
             */

            private IndexEntity index;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 天较凉，增加衣服，注意防护。
                 * title : 较易发
                 */

                private ColdEntity cold;
                /**
                 * desc : 白天阴沉，有点凉。
                 * title : 较舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天光线弱不需要佩戴太阳镜
                 * title : 不需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 推荐您在室内进行低强度运动。
                 * title : 较不宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 温度适宜，可尽情享受大自然风光。
                 * title : 适宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                 * title : 最弱
                 */

                private UvEntity uv;
                /**
                 * desc : 有雨，雨水和泥水会弄脏爱车。
                 * title : 不宜
                 */

                private WashCarEntity wash_car;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public void setWash_car(WashCarEntity wash_car) {
                    this.wash_car = wash_car;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public WashCarEntity getWash_car() {
                    return wash_car;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class WashCarEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }
        }

        public static class F6Entity {
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"天较凉，增加衣服，注意防护。","title":"较易发"}
             * comfort : {"desc":"白天降雨，有些凉意。","title":"较舒适"}
             * glass : {"desc":"白天能见度差不需要佩戴太阳镜","title":"不需要"}
             * sports : {"desc":"有降水，推荐您在室内进行休闲运动。","title":"较不宜"}
             * travel : {"desc":"有降水，温度适宜，不要错过出游机会。","title":"适宜"}
             * uv : {"desc":"辐射弱，涂擦SPF8-12防晒护肤品。","title":"最弱"}
             * wash_car : {"desc":"有雨，雨水和泥水会弄脏爱车。","title":"不宜"}
             */

            private IndexEntity index;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 天较凉，增加衣服，注意防护。
                 * title : 较易发
                 */

                private ColdEntity cold;
                /**
                 * desc : 白天降雨，有些凉意。
                 * title : 较舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天能见度差不需要佩戴太阳镜
                 * title : 不需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 有降水，推荐您在室内进行休闲运动。
                 * title : 较不宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 有降水，温度适宜，不要错过出游机会。
                 * title : 适宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射弱，涂擦SPF8-12防晒护肤品。
                 * title : 最弱
                 */

                private UvEntity uv;
                /**
                 * desc : 有雨，雨水和泥水会弄脏爱车。
                 * title : 不宜
                 */

                private WashCarEntity wash_car;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public void setWash_car(WashCarEntity wash_car) {
                    this.wash_car = wash_car;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public WashCarEntity getWash_car() {
                    return wash_car;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class WashCarEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }
        }

        public static class F7Entity {
            private String day;
            private String day_air_temperature;
            private String day_weather;
            private String day_weather_pic;
            private String day_wind_direction;
            private String day_wind_power;
            /**
             * beauty : {"desc":"请选用保湿型霜类化妆品。","title":"保湿"}
             * clothes : {"desc":"建议着厚外套加毛衣等服装。","title":"较冷"}
             * cold : {"desc":"感冒机率较低，避免长期处于空调屋中。","title":"少发"}
             * comfort : {"desc":"晴，炎热，酷暑难耐。","title":"极不舒适"}
             * glass : {"desc":"白天根据户外光线情况佩戴太阳镜","title":"需要"}
             * sports : {"desc":"请减少运动时间并降低运动强度。","title":"较不宜"}
             * travel : {"desc":"温度很高，有风，建议选择水上活动。","title":"较不宜"}
             * uv : {"desc":"辐射较弱，涂擦SPF12-15、PA+护肤品。","title":"弱"}
             */

            private IndexEntity index;
            private String night_air_temperature;
            private String night_weather;
            private String night_weather_pic;
            private String night_wind_direction;
            private String night_wind_power;
            private String sun_begin_end;
            private String weather_code;
            private int weekday;

            public void setDay(String day) {
                this.day = day;
            }

            public void setDay_air_temperature(String day_air_temperature) {
                this.day_air_temperature = day_air_temperature;
            }

            public void setDay_weather(String day_weather) {
                this.day_weather = day_weather;
            }

            public void setDay_weather_pic(String day_weather_pic) {
                this.day_weather_pic = day_weather_pic;
            }

            public void setDay_wind_direction(String day_wind_direction) {
                this.day_wind_direction = day_wind_direction;
            }

            public void setDay_wind_power(String day_wind_power) {
                this.day_wind_power = day_wind_power;
            }

            public void setIndex(IndexEntity index) {
                this.index = index;
            }

            public void setNight_air_temperature(String night_air_temperature) {
                this.night_air_temperature = night_air_temperature;
            }

            public void setNight_weather(String night_weather) {
                this.night_weather = night_weather;
            }

            public void setNight_weather_pic(String night_weather_pic) {
                this.night_weather_pic = night_weather_pic;
            }

            public void setNight_wind_direction(String night_wind_direction) {
                this.night_wind_direction = night_wind_direction;
            }

            public void setNight_wind_power(String night_wind_power) {
                this.night_wind_power = night_wind_power;
            }

            public void setSun_begin_end(String sun_begin_end) {
                this.sun_begin_end = sun_begin_end;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeekday(int weekday) {
                this.weekday = weekday;
            }

            public String getDay() {
                return day;
            }

            public String getDay_air_temperature() {
                return day_air_temperature;
            }

            public String getDay_weather() {
                return day_weather;
            }

            public String getDay_weather_pic() {
                return day_weather_pic;
            }

            public String getDay_wind_direction() {
                return day_wind_direction;
            }

            public String getDay_wind_power() {
                return day_wind_power;
            }

            public IndexEntity getIndex() {
                return index;
            }

            public String getNight_air_temperature() {
                return night_air_temperature;
            }

            public String getNight_weather() {
                return night_weather;
            }

            public String getNight_weather_pic() {
                return night_weather_pic;
            }

            public String getNight_wind_direction() {
                return night_wind_direction;
            }

            public String getNight_wind_power() {
                return night_wind_power;
            }

            public String getSun_begin_end() {
                return sun_begin_end;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public int getWeekday() {
                return weekday;
            }

            public static class IndexEntity {
                /**
                 * desc : 请选用保湿型霜类化妆品。
                 * title : 保湿
                 */

                private BeautyEntity beauty;
                /**
                 * desc : 建议着厚外套加毛衣等服装。
                 * title : 较冷
                 */

                private ClothesEntity clothes;
                /**
                 * desc : 感冒机率较低，避免长期处于空调屋中。
                 * title : 少发
                 */

                private ColdEntity cold;
                /**
                 * desc : 晴，炎热，酷暑难耐。
                 * title : 极不舒适
                 */

                private ComfortEntity comfort;
                /**
                 * desc : 白天根据户外光线情况佩戴太阳镜
                 * title : 需要
                 */

                private GlassEntity glass;
                /**
                 * desc : 请减少运动时间并降低运动强度。
                 * title : 较不宜
                 */

                private SportsEntity sports;
                /**
                 * desc : 温度很高，有风，建议选择水上活动。
                 * title : 较不宜
                 */

                private TravelEntity travel;
                /**
                 * desc : 辐射较弱，涂擦SPF12-15、PA+护肤品。
                 * title : 弱
                 */

                private UvEntity uv;

                public void setBeauty(BeautyEntity beauty) {
                    this.beauty = beauty;
                }

                public void setClothes(ClothesEntity clothes) {
                    this.clothes = clothes;
                }

                public void setCold(ColdEntity cold) {
                    this.cold = cold;
                }

                public void setComfort(ComfortEntity comfort) {
                    this.comfort = comfort;
                }

                public void setGlass(GlassEntity glass) {
                    this.glass = glass;
                }

                public void setSports(SportsEntity sports) {
                    this.sports = sports;
                }

                public void setTravel(TravelEntity travel) {
                    this.travel = travel;
                }

                public void setUv(UvEntity uv) {
                    this.uv = uv;
                }

                public BeautyEntity getBeauty() {
                    return beauty;
                }

                public ClothesEntity getClothes() {
                    return clothes;
                }

                public ColdEntity getCold() {
                    return cold;
                }

                public ComfortEntity getComfort() {
                    return comfort;
                }

                public GlassEntity getGlass() {
                    return glass;
                }

                public SportsEntity getSports() {
                    return sports;
                }

                public TravelEntity getTravel() {
                    return travel;
                }

                public UvEntity getUv() {
                    return uv;
                }

                public static class BeautyEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ClothesEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ColdEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class ComfortEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class GlassEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class SportsEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class TravelEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }

                public static class UvEntity {
                    private String desc;
                    private String title;

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public String getTitle() {
                        return title;
                    }
                }
            }
        }

        public static class NowEntity {
            private int aqi;
            /**
             * aqi : 250
             * area : 德州
             * area_code : dezhou
             * co : 3.14
             * no2 : 63
             * o3 : 1
             * o3_8h : 1
             * pm10 : 260
             * pm2_5 : 199
             * primary_pollutant : 颗粒物(PM2.5)
             * quality : 重度污染
             * so2 : 127
             */

            private AqiDetailEntity aqiDetail;
            private String sd;
            private String temperature;
            private String temperature_time;
            private String weather;
            private String weather_code;
            private String weather_pic;
            private String wind_direction;
            private String wind_power;

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public void setAqiDetail(AqiDetailEntity aqiDetail) {
                this.aqiDetail = aqiDetail;
            }

            public void setSd(String sd) {
                this.sd = sd;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public void setTemperature_time(String temperature_time) {
                this.temperature_time = temperature_time;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public void setWeather_pic(String weather_pic) {
                this.weather_pic = weather_pic;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public void setWind_power(String wind_power) {
                this.wind_power = wind_power;
            }

            public int getAqi() {
                return aqi;
            }

            public AqiDetailEntity getAqiDetail() {
                return aqiDetail;
            }

            public String getSd() {
                return sd;
            }

            public String getTemperature() {
                return temperature;
            }

            public String getTemperature_time() {
                return temperature_time;
            }

            public String getWeather() {
                return weather;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public String getWeather_pic() {
                return weather_pic;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public String getWind_power() {
                return wind_power;
            }

            public static class AqiDetailEntity {
                private int aqi;
                private String area;
                private String area_code;
                private double co;
                private int no2;
                private int o3;
                private int o3_8h;
                private int pm10;
                private int pm2_5;
                private String primary_pollutant;
                private String quality;
                private int so2;

                public void setAqi(int aqi) {
                    this.aqi = aqi;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public void setArea_code(String area_code) {
                    this.area_code = area_code;
                }

                public void setCo(double co) {
                    this.co = co;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public void setO3_8h(int o3_8h) {
                    this.o3_8h = o3_8h;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public void setPm2_5(int pm2_5) {
                    this.pm2_5 = pm2_5;
                }

                public void setPrimary_pollutant(String primary_pollutant) {
                    this.primary_pollutant = primary_pollutant;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public int getAqi() {
                    return aqi;
                }

                public String getArea() {
                    return area;
                }

                public String getArea_code() {
                    return area_code;
                }

                public double getCo() {
                    return co;
                }

                public int getNo2() {
                    return no2;
                }

                public int getO3() {
                    return o3;
                }

                public int getO3_8h() {
                    return o3_8h;
                }

                public int getPm10() {
                    return pm10;
                }

                public int getPm2_5() {
                    return pm2_5;
                }

                public String getPrimary_pollutant() {
                    return primary_pollutant;
                }

                public String getQuality() {
                    return quality;
                }

                public int getSo2() {
                    return so2;
                }
            }
        }
    }
}
